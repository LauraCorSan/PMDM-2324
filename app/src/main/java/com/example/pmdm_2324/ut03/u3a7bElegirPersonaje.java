package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.pmdm_2324.R;

public class u3a7bElegirPersonaje extends AppCompatActivity {
    public static final String CLAVE_PERSONAJE_SELECT = "personajeElegido";
    private static final String VACIO = "";
    View.OnClickListener seleccionado;
    ImageView ivMarco, ivEri, ivTarma, ivNadia;
    Button btSeleccionar, btLimpiar, btCancelar;
    int elElegidoId;
    int personajeEnUso;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7b_elegir_personaje);
        ivMarco=findViewById(R.id.u3a7ivMarcoRossi);
        ivEri=findViewById(R.id.u3a7ivEriKasamoto);
        ivTarma=findViewById(R.id.u3a7ivTarmaRoving);
        ivNadia=findViewById(R.id.u3a7ivNadiaCassel);

        btSeleccionar=findViewById(R.id.u3a7btSeleccionar);
        btLimpiar=findViewById(R.id.u3a7btLimpiar);
        btCancelar=findViewById(R.id.u3a7btCancelar);


        seleccionado = (View pulsado) -> {
            if(pulsado.getId()==R.id.u3a7ivMarcoRossi){
                ivMarco.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivEri.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivTarma.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivNadia.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.marco_rossi;
            }
            if(pulsado.getId()==R.id.u3a7ivEriKasamoto){
                ivEri.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivMarco.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivTarma.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivNadia.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.eri_kasamoto;
            }
            if(pulsado.getId()==R.id.u3a7ivTarmaRoving){
                ivTarma.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivMarco.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivEri.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivNadia.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.tarma_roving;
            }
            if(pulsado.getId()==R.id.u3a7ivNadiaCassel){
                ivNadia.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivMarco.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivEri.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivTarma.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.nadia_cassel;            }
        };

        ivMarco.setOnClickListener(seleccionado);
        ivEri.setOnClickListener(seleccionado);
        ivTarma.setOnClickListener(seleccionado);
        ivNadia.setOnClickListener(seleccionado);

        Bundle info = getIntent().getExtras();
        personajeEnUso = info.getInt(u3a7aMetalSlugSelector.INFO_PERS_USADO);

        if (personajeEnUso == R.drawable.marco_rossi) {
            ivMarco.setColorFilter(Color.argb(150, 0, 0, 0));
            ivMarco.setClickable(false);
        } else if (personajeEnUso == R.drawable.eri_kasamoto) {
            ivEri.setColorFilter(Color.argb(150, 0, 0, 0));
            ivEri.setClickable(false);
        } else if (personajeEnUso == R.drawable.tarma_roving) {
            ivTarma.setColorFilter(Color.argb(150, 0, 0, 0));
            ivTarma.setClickable(false);
        } else if (personajeEnUso == R.drawable.nadia_cassel) {
            ivNadia.setColorFilter(Color.argb(150, 0, 0, 0));
            ivNadia.setClickable(false);
        }

        btSeleccionar.setOnClickListener(view-> {
            if(elElegidoId!=0){
                    Intent data = new Intent();
                    data.putExtra(CLAVE_PERSONAJE_SELECT, elElegidoId);
                    setResult(Activity.RESULT_OK, data);
                    finish();//IMPORTANTE: NO hacer startactivity
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a7bElegirPersonaje.this);
                builder.setMessage("No has seleccionado ningun personaje")
                        .setPositiveButton("Entendido", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btLimpiar.setOnClickListener(view->{
            Intent data = new Intent();
            data.putExtra(CLAVE_PERSONAJE_SELECT, VACIO);
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });

        btCancelar.setOnClickListener(view->{
            setResult(Activity.RESULT_CANCELED);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });

    }
}