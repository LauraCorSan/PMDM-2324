package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.pmdm_2324.R;

public class u3a2aCrearHelado extends AppCompatActivity {

    public static final String VACIO = "";
    public static final String INFO_VAINILLA = "numVainilla";
    public static final String INFO_FRESA = "numFresa";
    public static final String INFO_CHOCOLATE = "numChocolate";
    public static final String INFO_TIPO = "tipoHelado";
    EditText etVainilla, etFresa, etChocolate;
    Spinner spTiposHelado;
    Button btCrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a2a_crear_helado);

        etVainilla=findViewById(R.id.u3a2etNumVainilla);
        etFresa=findViewById(R.id.u3a2etNumFresa);
        etChocolate=findViewById(R.id.u3a2etNumChocolate);

        spTiposHelado=findViewById(R.id.u3a2spTipoHelado);

        btCrar=findViewById(R.id.u3a2btCrear);


        btCrar.setOnClickListener((View v)->{
            
            if(!spTiposHelado.getSelectedItem().toString().equals(VACIO)){
                Intent i = new Intent(this, u3a2bServirHelado.class);
                i.putExtra(INFO_VAINILLA, etVainilla.getText().toString());
                i.putExtra(INFO_FRESA, etFresa.getText().toString());
                i.putExtra(INFO_CHOCOLATE, etChocolate.getText().toString());
                i.putExtra(INFO_TIPO, spTiposHelado.getSelectedItem().toString());
                startActivity(i);

                //Quitamos todo para la vuelta
                etVainilla.setText(VACIO);
                etFresa.setText(VACIO);
                etChocolate.setText(VACIO);

                spTiposHelado.setSelection(0);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a2aCrearHelado.this);
                builder.setMessage("Debe seleccionar un tipo de helado")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            }


        });


    }
}