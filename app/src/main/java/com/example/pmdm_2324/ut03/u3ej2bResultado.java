package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.pmdm_2324.R;

public class u3ej2bResultado extends AppCompatActivity {

    public static final String CLAVE_NUMERO = "miNumero";

    Button btAceptar, btCancelar;
    EditText etNumero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ej_u3a2b_resultado);
        btAceptar=findViewById(R.id.u3ej2btAceptar);
        btCancelar=findViewById(R.id.u3ej2btCancelar);
        etNumero=findViewById(R.id.u3ej2etNumero);

        btAceptar.setOnClickListener(view->{
            Intent data = new Intent();
            data.putExtra(CLAVE_NUMERO, etNumero.getText().toString());
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