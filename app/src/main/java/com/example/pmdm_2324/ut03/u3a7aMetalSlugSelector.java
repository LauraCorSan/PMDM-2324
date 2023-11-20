package com.example.pmdm_2324.ut03;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pmdm_2324.R;

public class u3a7aMetalSlugSelector extends AppCompatActivity {
    public static final String INFO_PERS_USADO ="personaEnUso" ;
    public static final int MAX_JUGADORES = 2;
    View.OnClickListener seleccion;
    ImageView ivElegirPersonaje1, ivElegirArma1, ivElegirPersonaje2, ivElegirArma2;
    Button btJugar;
    Boolean jugador1=false, jugador2=false;
    int personajeEnUso1, personajeEnUso2, contPersonajes, contArmas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a7a_metal_slug_selector);

        ivElegirPersonaje1=findViewById(R.id.u3a7ivElegirPersonajeJug1);
        ivElegirArma1=findViewById(R.id.u3a7ivElegirArmaJug1);

        ivElegirPersonaje2=findViewById(R.id.u3a7ivElegirPersonajeJug2);
        ivElegirArma2=findViewById(R.id.u3a7ivElegirArmaJug2);

        btJugar=findViewById(R.id.u3a7btJugar);

        ActivityResultLauncher<Intent> lanzadorPersonaje = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Here, no request code
                        Intent data = result.getData();
                            if(jugador1){
                                ivElegirPersonaje1.setImageResource(data.getExtras().getInt(u3a7bElegirPersonaje.CLAVE_PERSONAJE_SELECT));
                                personajeEnUso1=data.getExtras().getInt(u3a7bElegirPersonaje.CLAVE_PERSONAJE_SELECT);
                                contPersonajes++;
                            }else if (jugador2){
                                ivElegirPersonaje2.setImageResource(data.getExtras().getInt(u3a7bElegirPersonaje.CLAVE_PERSONAJE_SELECT));
                                personajeEnUso2=data.getExtras().getInt(u3a7bElegirPersonaje.CLAVE_PERSONAJE_SELECT);
                                contPersonajes++;
                            }

                    }else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        if(jugador1){
                            ivElegirPersonaje1.setImageResource(R.drawable.personaje_desc);
                            personajeEnUso1=0;
                            contPersonajes--;
                        }else if (jugador2){
                            ivElegirPersonaje2.setImageResource(R.drawable.personaje_desc);
                            personajeEnUso2=0;
                            contPersonajes--;
                        }

                    }else if (result.getResultCode() == Activity.RESULT_CANCELED){

                    }else{
                        //tvMensajes.setText("No obtenemos codigo");
                    }
                }
        );

        ActivityResultLauncher<Intent> lanzadorArma = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // Here, no request code
                        Intent data = result.getData();
                        if(jugador1){
                            ivElegirArma1.setImageResource(data.getExtras().getInt(u3a7cElegirArma.CLAVE_ARMA_SELECT));
                            contArmas++;
                        }else if (jugador2){
                            ivElegirArma2.setImageResource(data.getExtras().getInt(u3a7cElegirArma.CLAVE_ARMA_SELECT));
                            contArmas++;
                        }

                    }else if (result.getResultCode() == Activity.RESULT_FIRST_USER) {
                        if(jugador1){
                            ivElegirArma1.setImageResource(R.drawable.arma_desc);
                            contArmas--;
                        }else if (jugador2){
                            ivElegirArma2.setImageResource(R.drawable.arma_desc);
                            contArmas--;
                        }

                    }else if (result.getResultCode() == Activity.RESULT_CANCELED){
                        //nada porque ha cancelado la operación
                    }else{
                        //tvMensajes.setText("No obtenemos codigo");
                    }
                }
        );

        seleccion = (View pulsado) -> {
            if(pulsado.getId()==R.id.u3a7ivElegirPersonajeJug1){
                jugador1=true;
                jugador2=false;
                Intent i = new Intent(this, u3a7bElegirPersonaje.class);
                i.putExtra(INFO_PERS_USADO,personajeEnUso2);
                lanzadorPersonaje.launch(i);
            }
            if(pulsado.getId()==R.id.u3a7ivElegirPersonajeJug2){
                jugador2=true;
                jugador1=false;
                Intent i = new Intent(this, u3a7bElegirPersonaje.class);
                i.putExtra(INFO_PERS_USADO,personajeEnUso1);
                lanzadorPersonaje.launch(i);
            }
            if(pulsado.getId()==R.id.u3a7ivElegirArmaJug1){
                jugador1=true;
                jugador2=false;
                Intent i = new Intent(this, u3a7cElegirArma.class);
                //i.putExtra(algoo); aqui pasariamos algo a la actividad que llamemos
                lanzadorArma.launch(i);
            }
            if(pulsado.getId()==R.id.u3a7ivElegirArmaJug2){
                jugador2=true;
                jugador1=false;
                Intent i = new Intent(this, u3a7cElegirArma.class);
                //i.putExtra(algoo); aqui pasariamos algo a la actividad que llamemos
                lanzadorArma.launch(i);
            }
        };

        ivElegirPersonaje1.setOnClickListener(seleccion);
        ivElegirPersonaje2.setOnClickListener(seleccion);
        ivElegirArma1.setOnClickListener(seleccion);
        ivElegirArma2.setOnClickListener(seleccion);

        btJugar.setOnClickListener((View)->{
            if(contPersonajes>=MAX_JUGADORES && contArmas>=MAX_JUGADORES){
                finish();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(u3a7aMetalSlugSelector.this);
            builder.setMessage("No estas listo...")
                    .setPositiveButton("Entendido", null);
            AlertDialog alert = builder.create();
            alert.show();

        });
    }
}