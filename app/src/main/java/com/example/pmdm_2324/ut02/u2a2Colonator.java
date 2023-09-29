package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u2a2Colonator extends AppCompatActivity {
    SeekBar sbBarraColor;
    TextView tvDimeColor;
    Button btGenerar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u2a2_colonator);

        sbBarraColor=findViewById(R.id.u2a2sbRojo);
        tvDimeColor=findViewById(R.id.u2a2tvColorResultado);
        btGenerar=findViewById(R.id.u2a2btGenerar);


        btGenerar.setOnClickListener((View v)-> {
            int valorBarra=sbBarraColor.getProgress();

            tvDimeColor.setText(String.valueOf(valorBarra));

        });
    }
}