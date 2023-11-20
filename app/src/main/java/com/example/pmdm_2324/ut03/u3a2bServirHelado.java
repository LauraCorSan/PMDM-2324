package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a2bServirHelado extends AppCompatActivity {

    TextView tvVainilla, tvFresa, tvChocolate, tvTipoHelado;
    Button btListo;

    public static final String CUCURUCHO = "V";
    public static final String P_CUCURUCHO = "Cucurucho";
    public static final String P_CHOCORUCHO = "ChocoRucho";
    public static final String TARRINA = "U";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a2b_servir_helado);

        btListo=findViewById(R.id.u3a2btListo);

        tvVainilla=findViewById(R.id.u3a2tvCantVainilla);
        tvFresa=findViewById(R.id.u3a2tvCantFresa);
        tvChocolate=findViewById(R.id.u3a2tvCantChocolate);
        tvTipoHelado=findViewById(R.id.u3a2tvTipoHelado);

        int numVainilla=0, numFresa=0, numChocolate=0;

        Bundle info = getIntent().getExtras();
        try{numVainilla = Integer.valueOf(info.getString(u3a2aCrearHelado.INFO_VAINILLA));}
        catch(NumberFormatException e){

        }
        tvVainilla.setText(pintarBolitas(numVainilla));

        try{numFresa = Integer.valueOf(info.getString(u3a2aCrearHelado.INFO_FRESA));}
        catch(NumberFormatException e) {

        }
        tvFresa.setText(pintarBolitas(numFresa));

        try{numChocolate = Integer.valueOf(info.getString(u3a2aCrearHelado.INFO_CHOCOLATE));}
        catch(NumberFormatException e) {

        }
        tvChocolate.setText(pintarBolitas(numChocolate));

        String tipoHelado=info.getString(u3a2aCrearHelado.INFO_TIPO);
        if (tipoHelado.equals(P_CUCURUCHO)) {
            tvTipoHelado.setText(CUCURUCHO);
            tvTipoHelado.setTextColor(Color.parseColor("#FFA500")); // Naranja
        } else if (tipoHelado.equals(P_CHOCORUCHO)) {
            tvTipoHelado.setText(CUCURUCHO);
            tvTipoHelado.setTextColor(Color.parseColor("#8B4513")); // Marrón
        } else {
            tvTipoHelado.setText(TARRINA);
            tvTipoHelado.setTextColor(Color.GRAY); // Gris
        }


        btListo.setOnClickListener((View v)->{
            finish();
        });
    }

    public String pintarBolitas(int numBolitas){
        String pintaBolitas="";
        for(int i=1 ; i<=numBolitas; i++){
            pintaBolitas+="O";
        }
        return pintaBolitas;
    }
}