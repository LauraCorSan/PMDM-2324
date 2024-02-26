package com.example.pmdm_2324.Repaso2ev.PeliculasAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;

import java.util.ArrayList;

public class VerPeliculasMain extends AppCompatActivity {
    public static final String INFO_PELICULA = "info peli";
    RecyclerView rvListaPelis;
    PeliculasAdapter adapter;
    PeliculasViewModel vmPelicula;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_peliculas);

        rvListaPelis = findViewById(R.id.rvListadoAtracciones);
        rvListaPelis.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        adapter = new PeliculasAdapter(new ArrayList<>());

        rvListaPelis.setAdapter(adapter);

        // Inicializa y observa los cambios en el ViewModel
        vmPelicula = new ViewModelProvider(this).get(PeliculasViewModel.class);
        vmPelicula.getPeliculas().observe(this, peliculas -> {
            // Actualiza los datos del adaptador cuando cambia la lista de consejos en el ViewModel
            adapter.setPeliculas(peliculas);
        });

        adapter.setClickListener(new PeliculasAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Pelicula unaPelicula) {
                Intent i = new Intent(VerPeliculasMain.this, DetallesPelicula.class);
                i.putExtra(INFO_PELICULA, unaPelicula);
                startActivity(i);
            }
        });

    }
}