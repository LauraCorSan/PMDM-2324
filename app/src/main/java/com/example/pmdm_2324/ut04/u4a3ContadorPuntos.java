package com.example.pmdm_2324.ut04;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.util.ArrayList;

public class u4a3ContadorPuntos extends AppCompatActivity {
    public static final int NUM_POSICIONES = 4;
    public static final int NUM_COLUMNAS = 2;
    public static final int NUM_PARTIDAS = 4;
    int indiceLibre = 0;

    TextView[][] tablaPosiciones = new TextView[NUM_POSICIONES][NUM_COLUMNAS];
    u4f3ContadorPuntos[] arrayFragments = new u4f3ContadorPuntos[NUM_PARTIDAS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u4a3_contador_puntos);

        arrayFragments[0] = (u4f3ContadorPuntos) getSupportFragmentManager().findFragmentById(R.id.u4a3fcPartida1);
        arrayFragments[1] = (u4f3ContadorPuntos) getSupportFragmentManager().findFragmentById(R.id.u4a3fcPartida2);
        arrayFragments[2] = (u4f3ContadorPuntos) getSupportFragmentManager().findFragmentById(R.id.u4a3fcPartida3);
        arrayFragments[3] = (u4f3ContadorPuntos) getSupportFragmentManager().findFragmentById(R.id.u4a3fcPartida4);

        tablaPosiciones[0][0] = findViewById(R.id.u4a3tvPrimeroNombre);
        tablaPosiciones[0][1] = findViewById(R.id.u4a3tvGanador1);

        tablaPosiciones[1][0] = findViewById(R.id.u4a3tvSegundoNombre);
        tablaPosiciones[1][1] = findViewById(R.id.u4a3tvGanador2);

        tablaPosiciones[2][0] = findViewById(R.id.u4a3tvTerceroNombre);
        tablaPosiciones[2][1] = findViewById(R.id.u4a3tvGanador3);

        tablaPosiciones[3][0] = findViewById(R.id.u4a3tvCuartoNombre);
        tablaPosiciones[3][1] = findViewById(R.id.u4a3tvGanador4);

        for (u4f3ContadorPuntos partida : arrayFragments) {
            partida.setFinalPartidaListener((nombrePartida, ganador) -> {
                tablaPosiciones[indiceLibre][0].setText(nombrePartida);
                tablaPosiciones[indiceLibre][1].setText(String.valueOf(ganador));
                indiceLibre++;
            });
        }

    }


}