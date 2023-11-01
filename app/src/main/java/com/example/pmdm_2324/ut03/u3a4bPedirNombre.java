package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2324.R;

public class u3a4bPedirNombre extends AppCompatActivity {
    private static final String VACIO = "";
    public static final String CLAVE_NOMBRE = "NombreUsuario";
    EditText etNombre;
    Button btLimpiar, btAceptar, btCancelar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a4b_pedir_nombre);

        etNombre=findViewById(R.id.u3a4etNombre);

        btLimpiar=findViewById(R.id.u3a4btLimpiar);
        btAceptar=findViewById(R.id.u3a4btAceptar);
        btCancelar=findViewById(R.id.u3a4btCancelar);

        btLimpiar.setOnClickListener(view->{
            Intent data = new Intent();
            etNombre.setText(VACIO);
            data.putExtra(CLAVE_NOMBRE, etNombre.getText().toString());
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });

        btAceptar.setOnClickListener(view->{
            Intent data = new Intent();
            data.putExtra(CLAVE_NOMBRE, etNombre.getText().toString());
            setResult(Activity.RESULT_OK, data);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });

        btCancelar.setOnClickListener(view->{
            setResult(Activity.RESULT_CANCELED);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });


    }
}