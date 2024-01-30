package com.example.pmdm_2324.ut06;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.pmdm_2324.R;

public class u6a1ListaDulces extends AppCompatActivity {
    RecyclerView reyclerViewUser;
    Button add;
    u6a1DulceAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u6a1_lista_dulces);

        reyclerViewUser = (RecyclerView) findViewById(R.id.u6a1ListaContenedorDulces);
        add = findViewById(R.id.u6a1btAddDulces);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getApplicationContext());
        reyclerViewUser.setLayoutManager(layoutManager);

        adapter = new u6a1DulceAdapter(DulcesNavideños.generateDulces(DulcesNavideños.DULCES_INICIALES));
        reyclerViewUser.setAdapter(adapter);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.add(DulcesNavideños.generateDulces(ejPartido.PARTIDOS_INICIALES));
            }
        });
    }
}