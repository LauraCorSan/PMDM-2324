package com.example.pmdm_2324.ut09;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut09.data_losSimpson.Personaje;
import com.example.pmdm_2324.ut09.data_losSimpson.ServiceSimpsons;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class u9a2FrasesSimpsons extends AppCompatActivity {
    private static final String MSG_ERROR = "No se ha encontrado el personaje";
    Button get;
    EditText name;
    TextView info;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u9a2_frases_simpsons);
        name=findViewById(R.id.u9a2etName);
        get=findViewById(R.id.u9a2btGet);
        info=findViewById(R.id.u9a2tvInfo);

        get.setOnClickListener((v)->{
            ServiceSimpsons ser = ServiceSimpsons.getInstancia();
            Call <List<Personaje>> llamada = ser.getRepo().getCharacter(name.getText().toString());
            llamada.enqueue(new Callback<List<Personaje>>() {
                @Override
                public void onResponse(Call <List<Personaje>> call, Response<List<Personaje>> response) {
                    List<Personaje> pList = response.body();
                    if (!pList.isEmpty()){
                        Personaje p = pList.get(0);
                        info.setVisibility(View.VISIBLE);
                        info.setTextColor(Color.BLACK);
                        info.setText(p.quote);
                    }else{
                        info.setVisibility(View.VISIBLE);
                        info.setTextColor(Color.GRAY);
                        info.setText(MSG_ERROR);
                    }
                }

                @Override
                public void onFailure(Call<List<Personaje>> call, Throwable t) {
                    String nuncaToast = "Debug";
                }
            });
        });
    }
}