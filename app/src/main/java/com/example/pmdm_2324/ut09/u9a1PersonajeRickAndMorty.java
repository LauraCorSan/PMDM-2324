package com.example.pmdm_2324.ut09;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut09.data_RickAndMorty.Personaje;
import com.example.pmdm_2324.ut09.data_RickAndMorty.ServiceRickAndMorty;

public class u9a1PersonajeRickAndMorty extends AppCompatActivity {

    EditText id;
    Button get;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9a1_personaje);
        id=findViewById(R.id.u9a1etId);
        get=findViewById(R.id.u9a1btGet);
        info=findViewById(R.id.u9a1tvInfo);

        get.setOnClickListener((v)->{
            ServiceRickAndMorty ser = ServiceRickAndMorty.getInstancia();
            Call<Personaje> llamada = ser.getRepo().getCharacter(Integer.parseInt(id.getText().toString()));
            llamada.enqueue(new Callback<Personaje>() {
                @Override
                public void onResponse(Call<Personaje> call, Response<Personaje> response) {
                    Personaje p = response.body();
                    info.setText(p.name);
                }

                @Override
                public void onFailure(Call<Personaje> call, Throwable t) {
                    String nuncaToast = "Debug";
                }
            });
        });
    }
}