package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u2a2Colonator extends AppCompatActivity {
    EditText etNoombreColor;
    SeekBar sbBarraRojo, sbBarraVerde, sbBarraAzul;
    Switch swContraste;
    Button btGenerar;
    TextView tvColorResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2_colonator);

        //nombre color
        etNoombreColor=findViewById(R.id.u2a2etColor);

        //barras de colores
        sbBarraRojo=findViewById(R.id.u2a2sbRojo);
        sbBarraVerde=findViewById(R.id.u2a2sbVerde);
        sbBarraAzul=findViewById(R.id.u2a2sbAzul);

        //contraste o no
        swContraste=findViewById(R.id.u2a2swContraste);

        //Boton
        btGenerar=findViewById(R.id.u2a2btGenerar);

        //Caja de texto con nombre y color de fondo
        tvColorResultado=findViewById(R.id.u2a2tvColorResultado);

        swContraste.setOnClickListener((View v)->{
            if(swContraste.isChecked()){
                tvColorResultado.setTextColor(Color.BLACK);
            }else{
                tvColorResultado.setTextColor(Color.WHITE);
            }
        });

        btGenerar.setOnClickListener((View v)-> {
            String nomColor=etNoombreColor.getText().toString();
            int rojo=sbBarraRojo.getProgress();
            int verde=sbBarraVerde.getProgress();
            int azul=sbBarraAzul.getProgress();

            tvColorResultado.setText(nomColor);
            tvColorResultado.setBackgroundColor(Color.rgb(rojo,verde,azul));

        });
    }
}