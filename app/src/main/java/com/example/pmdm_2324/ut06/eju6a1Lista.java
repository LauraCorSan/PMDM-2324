package com.example.pmdm_2324.ut06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2324.R;

public class eju6a1Lista extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button add;
    eju6a1PartidoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eju6a1_lista);

        reyclerViewUser = (RecyclerView) findViewById(R.id.ut06ListaContenedor);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new eju6a1PartidoAdapter(ejPartido.generatePartidos(ejPartido.PARTIDOS_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add = findViewById(R.id.ut06idListaAdd);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(ejPartido.generatePartidos(ejPartido.PARTIDOS_INICIALES));
            }
        });

        //adapter.notifyDataSetChanged();
    }
}