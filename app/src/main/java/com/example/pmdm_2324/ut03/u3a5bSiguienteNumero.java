package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a5bSiguienteNumero extends AppCompatActivity {
    public static final String CLAVE_RESULTADO = "NumResultado";
    TextView tvResultado;
    Button btAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a5b_siguiente_numero);

        tvResultado=findViewById(R.id.u3a5tvResultado);
        btAceptar=findViewById(R.id.u3a5btAceptar);

        int num1=0, num2=0, resultado=0;

        Bundle info = getIntent().getExtras();
        try{num1 = Integer.valueOf(info.getString(u3a5aFibonacci.INFO_NUM1));}
        catch(NumberFormatException e){

        }

        try{num2 = Integer.valueOf(info.getString(u3a5aFibonacci.INFO_NUM2));}
        catch(NumberFormatException e) {

        }

        resultado=num1+num2;

        tvResultado.setText(String.valueOf(resultado));

        btAceptar.setOnClickListener((View)->{
            Intent data = new Intent();
            data.putExtra(CLAVE_RESULTADO, tvResultado.getText().toString());
            setResult(Activity.RESULT_OK, data);
            finish();
        });
    }
}