package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.pmdm_2324.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class u3a6bAnalisis extends AppCompatActivity {
    public static final int NUM_ELEMENTOS_PASAR = 3;
    public static final String CLAVE_TOP_3 = "top3MasUsados";
    ListView lvListaLetras;
    Button btFinAnalisis;
    ArrayList<String> arrayListViewLetras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a6b_analisis);

        lvListaLetras = findViewById(R.id.u3a6lvListaLetras);
        btFinAnalisis = findViewById(R.id.u3a6btFinAnalisis);


        arrayListViewLetras = new ArrayList<>();
        Bundle info = getIntent().getExtras();
        String texto = info.getString(u3a6aTexto.INFO_TEXTO);

        //Llamamos a contarletras pasandole el texto de A1, y este nos devuelve un linkedhashmap
        LinkedHashMap<Character, Integer> mapaContadorLetras = contarLetras(texto);

        // Llamamos a mapaLetrasToArrayList para pasarlo a arraylist y poder usarlo al darle los datos a la listView
        mapaLetrasToArrayList(mapaContadorLetras);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, R.layout.u3a6_list_view, arrayListViewLetras);

        lvListaLetras.setAdapter(adaptador);

        //Llamamos al metodo para ordenar el linkkedhashmap, que nos lo devuelve el top3 en forma de string
        String topLetras = ordenar_Top3ToString(mapaContadorLetras);

        btFinAnalisis.setOnClickListener((View) -> {
            Intent data = new Intent();
            data.putExtra(CLAVE_TOP_3, topLetras);
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }

    public static LinkedHashMap<Character, Integer> contarLetras(String texto) {
        LinkedHashMap<Character, Integer> mapaContadorLetra = new LinkedHashMap<>();
        int intLetra;
        Character letra;

        for (int i = 0; i < texto.length(); i++) {
            if ((intLetra = texto.charAt(i)) != 0) {
                if (Character.isAlphabetic(intLetra)) {
                    intLetra = Character.toLowerCase(intLetra);
                    letra = (char) intLetra;
                    if (mapaContadorLetra.containsKey(letra)) {
                        mapaContadorLetra.put(letra, mapaContadorLetra.get(letra) + 1);
                    } else {
                        mapaContadorLetra.put(letra, 1);
                    }
                }
            }
        }
        return mapaContadorLetra;
    }

    public void mapaLetrasToArrayList(LinkedHashMap<Character, Integer> mapaContadorLetras) {
        for (Map.Entry<Character, Integer> entry : mapaContadorLetras.entrySet()) {
            StringBuilder listaLetras = new StringBuilder();
            char letra = entry.getKey();
            int contador = entry.getValue();
            //añadimos lo del linkedhashmap a nuestro arraylist que usaremos para el listView
            arrayListViewLetras.add(listaLetras.append(letra).append(": ").append(contador).append("\n").toString());
        }
    }

    public String ordenar_Top3ToString(Map<Character, Integer> mapaContadorLetras) {
        List<Map.Entry<Character, Integer>> listaOrdenada = new ArrayList<>(mapaContadorLetras.entrySet());
        Collections.sort(listaOrdenada, (o1, o2) -> o2.getValue().compareTo(o1.getValue())); // Ordena en orden descendente

        StringBuilder topLetras = new StringBuilder();
        for (int i = 0; i < NUM_ELEMENTOS_PASAR && i < listaOrdenada.size(); i++) {
            Map.Entry<Character, Integer> entry = listaOrdenada.get(i);
            char letra = entry.getKey();
            int contador = entry.getValue();
            topLetras.append(letra).append(": ").append(contador).append("\n");
        }
        return topLetras.toString();
    }
}
