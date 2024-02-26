package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Atraccion;

import java.util.ArrayList;

public class VerAtraccionesMain extends AppCompatActivity {
    public static final String INFO_ATRACCION = "info de la atraccion";
    RecyclerView rvListadoAtracciones;
    AtraccionesAdapter adapter;
    AtraccionesViewModel vmAtraccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_atracciones_main);
        rvListadoAtracciones = findViewById(R.id.rvListadoAtracciones);
        rvListadoAtracciones.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        adapter = new AtraccionesAdapter(new ArrayList<>());
        rvListadoAtracciones.setAdapter(adapter);

        // Inicializa y observa los cambios en el ViewModel
        vmAtraccion = new ViewModelProvider(this).get(AtraccionesViewModel.class);
        vmAtraccion.getAtracciones().observe(this, atracciones -> {
            // Actualiza los datos del adaptador cuando cambia la lista en el ViewModel
            adapter.setAtracciones(atracciones);
        });

        adapter.setClickListener(new AtraccionesAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Atraccion unaAtraccion) {
                Intent i = new Intent(VerAtraccionesMain.this, ComentariosAtraccion.class);
                i.putExtra(INFO_ATRACCION, unaAtraccion);
                startActivity(i);
            }
        });
    }
}