package com.example.pmdm_2324.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3ej2aLanza extends AppCompatActivity {

    private static final String VACIO = "";
    Button btObtenerNumero;
    TextView tvNumero, tvSMS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3ej2a_lanza);

        btObtenerNumero=findViewById(R.id.u3ej2btObtenerNumero);
        tvNumero=findViewById(R.id.u3ej2tvNumero);
        tvSMS=findViewById(R.id.u3ej2tvSMS);


        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvNumero.setText(data.getStringExtra(u3ej2bResultado.CLAVE_NUMERO));
                            tvSMS.setText(VACIO);
                            tvSMS.setTextColor(Color.GREEN);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            tvSMS.setText("El usuario a cancelado la operacion");
                            tvSMS.setTextColor(Color.RED);
                        }else {
                            tvSMS.setText("No obtenemos cosdigo");
                            tvSMS.setTextColor(Color.RED);
                        }
                    }
                }
        );
        btObtenerNumero.setOnClickListener(view -> {
            Intent i =new Intent(this, u3ej2bResultado.class);
            lanzador.launch(i);
        });

    }
}