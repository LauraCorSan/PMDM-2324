package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.io.Serializable;

public class u3a8bMostrarMonstruo extends AppCompatActivity {

    TextView tvMostrarMonstruo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a8b_mostrar_monstruo);
        tvMostrarMonstruo=findViewById(R.id.u3a8tvMostrarMonstruo);

        Intent intent = getIntent();
        Serializable receivedMonster;
        receivedMonster = intent.getSerializableExtra(u3a8aCrearMonstruo.INFO_MONSTRUO);

        Monstruo nuevoMonstruo = (Monstruo) receivedMonster;

        //tvMostrarMonstruo.setTextColor(serializedMonster.getColor());
        tvMostrarMonstruo.setTextColor(nuevoMonstruo.getColor());
        tvMostrarMonstruo.setText(nuevoMonstruo.toString());

    }
}