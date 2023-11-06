package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.pmdm_2324.R;

public class u3a7cElegirArma extends AppCompatActivity {
    public static final String CLAVE_ARMA_SELECT = "armaElegida";
    private static final String VACIO = "";
    View.OnClickListener seleccionado;

    ImageView ivAmetralladora, ivLanzacohetes, ivPistolaLaser, ivLanzallamas;
    Button btSelecciona, btLimpia, btCancela;
    int elElegidoId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a7c_elegir_arma);

        ivAmetralladora=findViewById(R.id.u3a7ivAmetralladora);
        ivLanzacohetes=findViewById(R.id.u3a7ivLanzacohetes);
        ivPistolaLaser=findViewById(R.id.u3a7ivPistolaLaser);
        ivLanzallamas=findViewById(R.id.u3a7ivLanzallamas);

        btSelecciona=findViewById(R.id.u3a7btSelecciona);
        btLimpia=findViewById(R.id.u3a7btLimpia);
        btCancela=findViewById(R.id.u3a7btCancela);

        seleccionado = (View pulsado) -> {

            if(pulsado.getId()==R.id.u3a7ivAmetralladora){
                ivAmetralladora.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivLanzacohetes.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivPistolaLaser.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivLanzallamas.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.ametralladora;
            }
            if(pulsado.getId()==R.id.u3a7ivLanzacohetes){
                ivLanzacohetes.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivAmetralladora.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivPistolaLaser.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivLanzallamas.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.lanzacohetes;
            }
            if(pulsado.getId()==R.id.u3a7ivPistolaLaser){
                ivPistolaLaser.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivAmetralladora.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivLanzacohetes.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivLanzallamas.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.pistola_laser;
            }
            if(pulsado.getId()==R.id.u3a7ivLanzallamas){
                ivLanzallamas.setBackgroundResource(android.R.drawable.alert_light_frame);
                ivAmetralladora.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivLanzacohetes.setBackgroundResource(android.R.drawable.gallery_thumb);
                ivPistolaLaser.setBackgroundResource(android.R.drawable.gallery_thumb);
                elElegidoId= R.drawable.lanzallamas;            }
        };
        ivAmetralladora.setOnClickListener(seleccionado);
        ivLanzacohetes.setOnClickListener(seleccionado);
        ivPistolaLaser.setOnClickListener(seleccionado);
        ivLanzallamas.setOnClickListener(seleccionado);

        btSelecciona.setOnClickListener(view->{
            if(elElegidoId!=0){
                Intent data = new Intent();
                data.putExtra(CLAVE_ARMA_SELECT, elElegidoId);
                setResult(Activity.RESULT_OK, data);
                finish();//IMPORTANTE: NO hacer startactivity
            }else{
                AlertDialog.Builder builder = new AlertDialog.Builder(u3a7cElegirArma.this);
                builder.setMessage("No has seleccionado ningun arma")
                        .setPositiveButton("Entendido", null);
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        btLimpia.setOnClickListener(view->{
            Intent data = new Intent();
            data.putExtra(CLAVE_ARMA_SELECT, VACIO);
            setResult(Activity.RESULT_FIRST_USER, data);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });

        btCancela.setOnClickListener(view->{
            setResult(Activity.RESULT_CANCELED);
            finish();
            //IMPORTANTE: NO hacer startactivity
        });
    }
}