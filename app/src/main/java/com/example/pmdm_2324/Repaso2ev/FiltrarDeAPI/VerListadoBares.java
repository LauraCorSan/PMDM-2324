package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.Bar;

import java.util.ArrayList;

public class VerListadoBares extends AppCompatActivity {
    public static final String INFO_BARES = "info de bares";
    RecyclerView rvBares;
    Spinner spEstrellas;
    String [] courses = {"Estrellas", "1", "2", "3", "4", "5"};
    int estrellas;
    BaresAdapter adapter;
    BaresViewModel baresViewModel;
    Button btFiltrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_listado_bares);

        rvBares = findViewById(R.id.rvBares);
        spEstrellas = findViewById(R.id.spNumEstrellas);
        btFiltrar = findViewById(R.id.btFiltrar);

        ArrayAdapter<String> ad = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, courses);
        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEstrellas.setAdapter(ad);

        // Configuración inicial del RecyclerView, adaptador y ViewModel
        rvBares.setLayoutManager(new LinearLayoutManager(this));
        adapter = new BaresAdapter(new ArrayList<>());
        rvBares.setAdapter(adapter);
        baresViewModel = new ViewModelProvider(this).get(BaresViewModel.class);
        estrellas = 0;
        baresViewModel.getBares(estrellas).observe(this, bares -> {
            adapter.setBares(bares);
            adapter.notifyDataSetChanged(); // Notificar al adaptador que los datos han cambiado
        });


        btFiltrar.setOnClickListener((v) -> {
            int estrellas = spEstrellas.getSelectedItemPosition();

            if(estrellas==0){
                baresViewModel.generarTodosLosBares();// Manejar el caso predeterminado si es necesario

            }else {
                baresViewModel.generarBares(estrellas);
            }

        });

        adapter.setClickListener(new BaresAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Bar unBar) {
                Intent i = new Intent(VerListadoBares.this, DetallesBares.class);
                i.putExtra(INFO_BARES,unBar);

                startActivity(i);
            }
        });
    }
}