package com.example.pmdm_2324.ut04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut03.Monstruo;
import com.example.pmdm_2324.ut03.u3a8aCrearMonstruo;
import com.example.pmdm_2324.ut03.u3a8bMostrarMonstruo;

public class u4a2MasMonstruos extends AppCompatActivity {
    public static final int MAX_NUM_PATAS = 10;

    u4f2MasMonstruos fragment1, fragment2, fragment3, fragment4;
    TextView tvMuestraColor;
    EditText etNombre, etNumPatas;
    SeekBar sbBarraRojo, sbBarraVerde, sbBarraAzul;
    Spinner spNumMonstruos;
    Button btCrear;

    //TODO RECUERDA HACER LO DE QUE ENCAJEN LOS FRAGMENTS

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a2_mas_monstruos);

        fragment1 = (u4f2MasMonstruos) getSupportFragmentManager().findFragmentById(R.id.u4a2fcMonstruo1);
        fragment2 = (u4f2MasMonstruos) getSupportFragmentManager().findFragmentById(R.id.u4a2fcMonstruo2);
        fragment3 = (u4f2MasMonstruos) getSupportFragmentManager().findFragmentById(R.id.u4a2fcMonstruo3);
        fragment4 = (u4f2MasMonstruos) getSupportFragmentManager().findFragmentById(R.id.u4a2fcMonstruo4);

        etNombre=findViewById(R.id.u4a2etNombre);
        etNumPatas=findViewById(R.id.u4a2etNumPatas);

        sbBarraRojo=findViewById(R.id.u4a2sbRojo);
        sbBarraVerde=findViewById(R.id.u4a2sbVerde);
        sbBarraAzul=findViewById(R.id.u4a2sbAzul);

        tvMuestraColor=findViewById(R.id.u4a2tvMuestraColor);

        spNumMonstruos=findViewById(R.id.u4a2spNumMonstruos);

        btCrear=findViewById(R.id.u4a2btCrear);

        tvMuestraColor.setOnClickListener(view -> {
            int color = Color.rgb(sbBarraRojo.getProgress(), sbBarraVerde.getProgress(), sbBarraAzul.getProgress());
            tvMuestraColor.setBackgroundColor(color);
        });


        btCrear.setOnClickListener((View v)->{

            if(etNombre.getText().toString().trim().isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(u4a2MasMonstruos.this);
                builder.setMessage("Debes ponerle un nombre a tu monstruo")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            } else if (etNumPatas.getText().toString().trim().isEmpty() ||
                    Integer.parseInt(etNumPatas.getText().toString()) > MAX_NUM_PATAS){
                AlertDialog.Builder builder = new AlertDialog.Builder(u4a2MasMonstruos.this);
                builder.setMessage("Tu monstruo debe tener más de 0 patas")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            } else {
                int numMonstruos=spNumMonstruos.getSelectedItemPosition()+1;

                //Creamos el objeto Monstruo
                String nombre = etNombre.getText().toString();
                int numPatitas = Integer.parseInt(etNumPatas.getText().toString());
                int color = Color.rgb(sbBarraRojo.getProgress(), sbBarraVerde.getProgress(), sbBarraAzul.getProgress());

                Monstruo miCreacion = new Monstruo(nombre, numPatitas, color);

                switch (numMonstruos){
                    case 1:
                        fragment1.pintarMonstruo(miCreacion);
                        fragment2.limpiar();
                        fragment3.limpiar();
                        fragment4.limpiar();
                        break;
                    case 2:
                        fragment1.pintarMonstruo(miCreacion);
                        fragment2.pintarMonstruo(miCreacion);
                        fragment3.limpiar();
                        fragment4.limpiar();
                        break;
                    case 3:
                        fragment1.pintarMonstruo(miCreacion);
                        fragment2.pintarMonstruo(miCreacion);
                        fragment3.pintarMonstruo(miCreacion);
                        fragment4.limpiar();
                        break;
                    case 4:
                        fragment1.pintarMonstruo(miCreacion);
                        fragment2.pintarMonstruo(miCreacion);
                        fragment3.pintarMonstruo(miCreacion);
                        fragment4.pintarMonstruo(miCreacion);
                        break;
                    default:
                        //error fatal
                }
            }
        });
    }
}