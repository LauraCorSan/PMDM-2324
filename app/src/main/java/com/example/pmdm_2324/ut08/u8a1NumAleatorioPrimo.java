package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u8a1NumAleatorioPrimo extends AppCompatActivity {

    TextView tvNumero;
    Button btGenerar;
    ProgressBar pbCargando;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a1_num_aleatorio_primo);

        tvNumero = findViewById(R.id.u8a1tvNumero);
        btGenerar = findViewById(R.id.u8a1btGenerar);
        pbCargando = findViewById(R.id.u8a1pbCargando);

        u8a1NumAleatorioViewModel vm = new ViewModelProvider(this).get(u8a1NumAleatorioViewModel.class);
        vm.getNumero().observe(this, integer -> {
            //Actualizar interfaz
            if(integer == u8a1NumAleatorioViewModel.FAIL){
                tvNumero.setText("ERROR: No se ha podido acceder a los datos");
            }else {
                tvNumero.setText(String.valueOf(integer));
            }

            pbCargando.setVisibility(View.INVISIBLE);
            tvNumero.setVisibility(View.VISIBLE);
            btGenerar.setEnabled(true);
        });

        btGenerar.setOnClickListener((v)->{
            pbCargando.setVisibility(View.VISIBLE);
            tvNumero.setVisibility(View.INVISIBLE);
            btGenerar.setEnabled(false);
            vm.cargaNumero();
        });

    }
}