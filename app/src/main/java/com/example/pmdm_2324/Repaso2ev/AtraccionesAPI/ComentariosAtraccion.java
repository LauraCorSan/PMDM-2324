package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Atraccion;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Comentario;

import java.util.ArrayList;

public class ComentariosAtraccion extends AppCompatActivity {
    TextView tvNombre;
    RecyclerView rvComentarios;
    ProgressBar pbCargando;
    ComentariosAdapter adapter;
    ComentariosViewModel vmComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ver_comentarios_atraccion);

        tvNombre = findViewById(R.id.tvNombreDichaAtraccion);
        rvComentarios = findViewById(R.id.rvComentariosAtraccion);
        pbCargando=findViewById(R.id.pbEsperaComentarios);

        rvComentarios.setLayoutManager(new LinearLayoutManager(this.getApplicationContext()));

        Bundle i = getIntent().getExtras();
        Atraccion atraccionRecibida = (Atraccion) i.getSerializable(VerAtraccionesMain.INFO_ATRACCION);

        tvNombre.setText(atraccionRecibida.getNombre());

        adapter = new ComentariosAdapter(new ArrayList<>());

        rvComentarios.setAdapter(adapter);

        // Inicializa y observa los cambios en el ViewModel
        vmComentario = new ViewModelProvider(this).get(ComentariosViewModel.class);
        vmComentario.getComentarios(atraccionRecibida.getIdByUrl()).observe(this, comentarios -> {
            adapter.setComentarios(comentarios);
            pbCargando.setVisibility(View.INVISIBLE);
            rvComentarios.setVisibility(View.VISIBLE);
        });


    }
}