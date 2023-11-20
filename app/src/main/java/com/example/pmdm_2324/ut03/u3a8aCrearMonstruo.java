package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.pmdm_2324.R;

public class u3a8aCrearMonstruo extends AppCompatActivity {
    public static final int MAX_NUM_PATAS = 10;
    public static final String INFO_MONSTRUO = "miMonstruo";

    EditText etNombre, etNumPatas;
    SeekBar sbBarraRojo, sbBarraVerde, sbBarraAzul;
    Button btCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8a_crear_monstruo);

        etNombre=findViewById(R.id.u3a8etNombre);
        etNumPatas=findViewById(R.id.u3a8etNumPatas);

        sbBarraRojo=findViewById(R.id.u3a8sbRojo);
        sbBarraVerde=findViewById(R.id.u3a8sbVerde);
        sbBarraAzul=findViewById(R.id.u3a8sbAzul);

        btCrear=findViewById(R.id.u3a8btCrear);


        btCrear.setOnClickListener((View v)->{

            if(etNombre.getText().toString().trim().isEmpty()){
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a8aCrearMonstruo.this);
                builder.setMessage("Debes ponerle un nombre a tu monstruo")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            } else if (etNumPatas.getText().toString().trim().isEmpty() ||
                    Integer.parseInt(etNumPatas.getText().toString()) > MAX_NUM_PATAS){
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a8aCrearMonstruo.this);
                builder.setMessage("Tu monstruo debe tener más de 0 patas")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            } else {
                //creating Monster object
                String nombre = etNombre.getText().toString();
                int numPatitas = Integer.parseInt(etNumPatas.getText().toString());

                int rojo=sbBarraRojo.getProgress();
                int verde=sbBarraVerde.getProgress();
                int azul=sbBarraAzul.getProgress();

                int color = Color.rgb(sbBarraRojo.getProgress(), sbBarraVerde.getProgress(), sbBarraAzul.getProgress());
                Monstruo miCreacion = new Monstruo(nombre, numPatitas, color);

                //launching Activity2
                Intent intent = new Intent(u3a8aCrearMonstruo.this, u3a8bMostrarMonstruo.class);
                intent.putExtra(INFO_MONSTRUO, miCreacion);
                startActivity(intent);
            }
        });
    }
}