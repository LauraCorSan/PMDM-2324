package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u8a2SumarNumeros extends AppCompatActivity {
    EditText etNum1, etNum2;
    TextView tvResult;
    Button btSumar;
    ProgressBar pbCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a2_sumar_numeros);

        etNum1=findViewById(R.id.u8a2etNum1);
        etNum2=findViewById(R.id.u8a2etNum2);

        btSumar=findViewById(R.id.u8a2btSumar);

        pbCargando=findViewById(R.id.u8a2pbCargando);
        tvResult = findViewById(R.id.u8a2tvResult);

        //Para que no aparezca nada mas abrir la actividad
        pbCargando.setVisibility(View.INVISIBLE);

        u8a2SumarNumerosVM vm = new ViewModelProvider(this).get(u8a2SumarNumerosVM.class);
        vm.getNumero().observe(this, integer -> {
            //Actualizar interfaz
            if (integer == u8a2SumarNumerosVM.FAIL) {
                tvResult.setText("ERROR: No se ha podido realizar la operacion");
            } else {
                tvResult.setText(String.valueOf(integer));
            }

            pbCargando.setVisibility(View.INVISIBLE);
            tvResult.setVisibility(View.VISIBLE);
            btSumar.setEnabled(true);
        });

        btSumar.setOnClickListener((v) -> {
            pbCargando.setVisibility(View.VISIBLE);
            tvResult.setVisibility(View.INVISIBLE);
            btSumar.setEnabled(false);
            vm.sumarNumeros(Integer.parseInt(etNum1.getText().toString()), Integer.parseInt(etNum2.getText().toString()));
        });
    }
}