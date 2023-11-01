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
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a5aFibonacci extends AppCompatActivity {
    public static final String INFO_NUM1 = "numero1";
    public static final String INFO_NUM2 = "numero2";
    TextView tvNumero1, tvNumero2;
    Button btSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a5a_fibonacci);

        tvNumero1=findViewById(R.id.u3a5tvNum1);
        tvNumero2=findViewById(R.id.u3a5tvNum2);

        btSiguiente=findViewById(R.id.u3a5btSiguiente);

        //n1 será el antiguo n2 y n2 será el resultado de la suma.

        ActivityResultLauncher<Intent> lanzador = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {

                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if (result.getResultCode() == Activity.RESULT_OK) {
                            // Here, no request code
                            Intent data = result.getData();
                            tvNumero1.setText(tvNumero2.getText().toString());
                            tvNumero2.setText(data.getStringExtra(u3a5bSiguienteNumero.CLAVE_RESULTADO));
                        }
                    }
                }
        );

        btSiguiente.setOnClickListener(view -> {
            Intent i = new Intent(this, u3a5bSiguienteNumero.class);
            i.putExtra(INFO_NUM1, tvNumero1.getText().toString());
            i.putExtra(INFO_NUM2, tvNumero2.getText().toString());

            lanzador.launch(i);
        });
    }
}