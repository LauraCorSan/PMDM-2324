package com.example.pmdm_2324.ut03;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a6aTexto extends AppCompatActivity {
    public static final String INFO_TEXTO = "textoUsuario";
    EditText etTexto;
    TextView tvInfromacion;
    Button btAnalizar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a6a_texto);

        etTexto=findViewById(R.id.u3a6etTextoUsuario);
        tvInfromacion=findViewById(R.id.u3a6tvInfromacion);
        btAnalizar=findViewById(R.id.u3a6btAnalizar);


        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvInfromacion.setText("TOP 3 LETRAS MAS USADAS\n"+data.getStringExtra(u3a6bAnalisis.CLAVE_TOP_3));
                        }
                    }
                }
        );

        btAnalizar.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a6bAnalisis.class);
            i.putExtra(INFO_TEXTO, etTexto.getText().toString());

            lanzador.launch(i);
        });
    }
}