package com.example.pmdm_2324.ut08;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u8a3ParesNones extends AppCompatActivity {
    RadioGroup rgEleccion;
    Button btJugar;
    ProgressBar pbCargando;
    EditText etNumero;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u8a3_pares_nones);

        rgEleccion = findViewById(R.id.u8a3rgEleccion);
        etNumero = findViewById(R.id.u8a3etNumero);
        btJugar = findViewById(R.id.u8a3btJugar);
        pbCargando = findViewById(R.id.u8a3pbCargando);
        tvResultado = findViewById(R.id.u8a3tvResultado);

        u8a3ParesNonesVM vm = new ViewModelProvider(this).get(u8a3ParesNonesVM.class);
        vm.getResultado().observe(this, pojo -> {
            //Actualizar interfaz
            if (pojo == null) {
                tvResultado.setText("ERROR: No se ha podido realizar la operacion");
            } else {
                if(pojo.getVictoriaUsuario()){
                    tvResultado.setTextColor(Color.GREEN);
                    tvResultado.setText("La maquina a elegido..."+pojo.getNumMaquina()+"\n!HAS GANADO!");
                }else{
                    tvResultado.setTextColor(Color.RED);
                    tvResultado.setText("La maquina a elegido..."+pojo.getNumMaquina()+"\n!HAS PERDIDO!");
                }
            }
            pbCargando.setVisibility(View.INVISIBLE);
            tvResultado.setVisibility(View.VISIBLE);
            btJugar.setEnabled(true);
        });

        btJugar.setOnClickListener((v) -> {
            pbCargando.setVisibility(View.VISIBLE);
            tvResultado.setVisibility(View.INVISIBLE);
            btJugar.setEnabled(false);

            // Recogemos en un boolean que ha jugado el usurio (pares o nones)
            boolean juegaPares;
            if(rgEleccion.getCheckedRadioButtonId()==R.id.u8a3rbPares) juegaPares=true;
            else juegaPares=false;

            vm.jugar(Integer.parseInt(etNumero.getText().toString()), juegaPares);
        });

    }
}
