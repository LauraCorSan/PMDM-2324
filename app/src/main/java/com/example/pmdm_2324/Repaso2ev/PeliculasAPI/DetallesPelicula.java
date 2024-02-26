package com.example.pmdm_2324.Repaso2ev.PeliculasAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;

import java.io.Serializable;
import java.util.ArrayList;

public class DetallesPelicula extends AppCompatActivity {
    TextView tvNombre, tvDescripcion, tvEstrellas;
    RecyclerView rvActores;
    ActoresAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_detalles_pelicula);
        tvNombre = findViewById(R.id.tvTituloPeliculaDetalle);
        tvDescripcion = findViewById(R.id.tvDescripcionPelicula);
        tvEstrellas = findViewById(R.id.tvEstrellasPeliculaDetalle);

        rvActores = findViewById(R.id.rvActoresPelicula);
        rvActores.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        //una manera
        Intent i = getIntent();

        Serializable peliculaRecibida = i.getSerializableExtra(VerPeliculasMain.INFO_PELICULA);
        Pelicula nuevaPelicula = (Pelicula) peliculaRecibida;


        //una manera
        /*Bundle i =getIntent().getExtras();
        Pelicula nuevaPelicula = (Pelicula) i.getSerializable(VerPeliculasMain.INFO_PELICULA);*/

        tvNombre.setText(nuevaPelicula.getNombre());
        tvDescripcion.setText(nuevaPelicula.getDescripcion());
        tvEstrellas.setText(nuevaPelicula.getStringEstrellas());

        adapter = new ActoresAdapter(new ArrayList<>());

        rvActores.setAdapter(adapter);
        adapter.setActores(nuevaPelicula.getActores());




    }
}