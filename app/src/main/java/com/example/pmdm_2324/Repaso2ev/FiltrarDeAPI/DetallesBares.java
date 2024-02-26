package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.Bar;

public class DetallesBares extends AppCompatActivity {
    TextView tvNombre, tvDescripcion, tvEstrellas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_detalles_bares);
        //Fatla hacer las cosas en el layout y tal
        /*tvNombre = findViewById(R.id.tvNombreDetalles);
        tvDescripcion = findViewById(R.id.tvDescripcionDetalles);
        tvEstrellas = findViewById(R.id.tvEstrellasDetalles);*/

        Bundle bares = getIntent().getExtras();
        Bar bar = (Bar) bares.getSerializable(VerListadoBares.INFO_BARES);
        tvNombre.setText(bar.getNombre());
        tvDescripcion.setText(bar.getDescripcion());
        tvEstrellas.setText(String.valueOf(bar.getEstrellas()));
    }
}