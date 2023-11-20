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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a4aMostrarNombre extends AppCompatActivity {

    ImageView ivUsuario;
    TextView tvNombre, tvMensajes;
    Button btIngresarNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a4a_mostrar_nombre);

        ivUsuario=findViewById(R.id.u3a4ivUsuario);

        tvNombre=findViewById(R.id.u3a4tvNombre);
        btIngresarNombre=findViewById(R.id.u3a4btIngresarNombre);
        tvMensajes=findViewById(R.id.u3a4tvMensajes);


        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvNombre.setText(data.getStringExtra(u3a4bPedirNombre.CLAVE_NOMBRE));
                            ivUsuario.setImageResource(R.drawable.usuario__1_);
                            tvMensajes.setText("Nombre cambiado con exito");
                            tvMensajes.setTextColor(Color.GREEN);
                        } else if (result.getResultCode() == Activity.RESULT_CANCELED) {
                            tvMensajes.setText("El usuario a cancelado la operacion");
                            tvMensajes.setTextColor(Color.RED);
                        }else if (result.getResultCode() == Activity.RESULT_FIRST_USER){
                            tvNombre.setText("Anonimo");
                            ivUsuario.setImageResource(R.drawable.anonimo_);
                            tvMensajes.setText("Se ha limpiado el nombre");
                            tvMensajes.setTextColor(Color.BLUE);
                        }else{
                            tvMensajes.setText("No obtenemos cosdigo");
                            tvMensajes.setTextColor(Color.RED);
                        }
                    }
                }
        );
        btIngresarNombre.setOnClickListener(view -> {
            Intent i =new Intent(this, u3a4bPedirNombre.class);
            lanzador.launch(i);
        });
    }
}