package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.pmdm_2324.R;

public class u3a1aCalcular extends AppCompatActivity {
    public static final String VACIO = "";
    public static final String INFO_NUMERO1 = "num1";
    public static final String INFO_NUMERO2 = "num2";
    public static final String INFO_OPERADOR = "op";
    Button btCalcular;
    EditText etNumero1, etNumero2;
    RadioGroup rgOperaciones;
    RadioButton radioSeleccionado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a1a_calcular);

        etNumero1=findViewById(R.id.u3a1etNumero1);
        etNumero2=findViewById(R.id.u3a1etNumero2);

        rgOperaciones=findViewById(R.id.u3a1rgOperaciones);

        btCalcular=findViewById(R.id.u3a1btCalcular);



        //Le paso todos los datos a la otra activity
        btCalcular.setOnClickListener(view -> {
            radioSeleccionado=findViewById(rgOperaciones.getCheckedRadioButtonId());

            if(radioSeleccionado!=null){
                Intent i = new Intent(this, u3a1bResultado.class);
                i.putExtra(INFO_NUMERO1, etNumero1.getText().toString());
                i.putExtra(INFO_NUMERO2, etNumero2.getText().toString());
                i.putExtra(INFO_OPERADOR, radioSeleccionado.getText().toString());
                startActivity(i);
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a1aCalcular.this);
                builder.setMessage("Debe seleccionar una operacion")
                        .setPositiveButton("Entendido", null);

                AlertDialog alert = builder.create();
                alert.show();
            }

            etNumero1.setText(VACIO);
            etNumero2.setText(VACIO);
            radioSeleccionado.setChecked(false);

        });
    }
}