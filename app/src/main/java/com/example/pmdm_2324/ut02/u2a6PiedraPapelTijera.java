package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.example.pmdm_2324.R;

public class u2a6PiedraPapelTijera extends AppCompatActivity {
    View.OnClickListener manejador;
    TextView tvContUsuario, tvContMaquina, tvMensaje, tvFinJuego;
    ImageView ivPiedra, ivPapel, ivTijera, ivRespuesta, ivFinJuego;
    Button btReintentar;
    ViewFlipper vfFinJuego, vfFinJuegoLand;
    public enum Eleccion {
        PIEDRA(1),
        PAPEL(2),
        TIJERA(3);
        private final int valor;
        Eleccion(int valor) {
            this.valor = valor;
        }
        public int getValor() {
            return valor;
        }
    }

    public static final String VACIO="";
    public static final String MSG_USUARIO_PIERDE="¡Tu has perdido! :(";
    public static final String MSG_USUARIO_GANA="¡Tu has ganado! :D";
    public static final String MSG_EMPATE="¡Empate!";
    public static final String MSG_VICTORIA="¡HAS GANADO!";
    public static final String MSG_DERROTA="¡HAS PERDIDO!";

    public static final int MAX_VICTORIAS=3;
    public int contUsuario=0;
    public  int contMaquina=0;
    public int contEmpate=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Obtén la orientación actual del dispositivo
        int orientacion = getResources().getConfiguration().orientation;

        if (orientacion == Configuration.ORIENTATION_LANDSCAPE) {
            // Si el dispositivo está en orientación horizontal, carga el layout horizontal
            setContentView(R.layout.activity_u2a6_piedra_papel_tijera_land);
        } else {
            // Si el dispositivo está en orientación vertical, carga el layout vertical
            setContentView(R.layout.activity_u2a6_piedra_papel_tijera);
        }


        tvContUsuario=findViewById(R.id.u2a6tvContUsuario);
        tvContMaquina=findViewById(R.id.u2a6tvContMaquina);

        ivPiedra=findViewById(R.id.u2a6ivPiedra);
        ivPapel=findViewById(R.id.u2a6ivPapel);
        ivTijera=findViewById(R.id.u2a6ivTijeras);

        ivRespuesta=findViewById(R.id.u2a6ivRespuesta);
        tvMensaje=findViewById(R.id.u2a6tvMensaje);

        btReintentar=findViewById(R.id.u2a6btReiniciar);

        vfFinJuego=findViewById(R.id.u2a6vfFinJuego);

        tvFinJuego=findViewById(R.id.u2a6tvMensajeFinJuego);
        ivFinJuego=findViewById(R.id.u2a6ivFinJuego);


        manejador = (View pulsado) -> {
            if(contMaquina<MAX_VICTORIAS && contUsuario<MAX_VICTORIAS){
                if(pulsado.getId()==R.id.u2a6ivPiedra){
                    jugar(Eleccion.PIEDRA);
                }
                if(pulsado.getId()==R.id.u2a6ivPapel){
                    jugar( Eleccion.PAPEL);
                }
                if(pulsado.getId()==R.id.u2a6ivTijeras){
                    jugar( Eleccion.TIJERA);
                }
            }else {
                if (contMaquina >= MAX_VICTORIAS) {
                    tvFinJuego.setText(MSG_DERROTA);
                    ivFinJuego.setImageResource(R.drawable.sad_face);
                } else if (contUsuario >= MAX_VICTORIAS) {
                    tvFinJuego.setText(MSG_VICTORIA);
                    ivFinJuego.setImageResource(R.drawable.trofeo_png);
                }

                    vfFinJuego.setVisibility(View.VISIBLE);
                    vfFinJuego.showNext();

            }
        };
        ivPiedra.setOnClickListener(manejador);
        ivPapel.setOnClickListener(manejador);
        ivTijera.setOnClickListener(manejador);

        btReintentar.setOnClickListener((View v)->{
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Alerta")
                    .setMessage("¿Estas seguro?")
                    .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Acciones a realizar cuando el usuario hace clic en "Aceptar"
                            vfFinJuego.setVisibility(View.GONE);
                            ivRespuesta.setImageResource(R.drawable.pregunta);

                            contUsuario=0;
                            tvContUsuario.setText(String.valueOf(contUsuario));
                            contMaquina=0;
                            tvContMaquina.setText(String.valueOf(contMaquina));
                            contEmpate=0;
                            tvMensaje.setText(VACIO);
                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // Acciones a realizar cuando el usuario hace clic en "Cancelar"
                            dialog.dismiss();
                        }
                    });

            // Crear y mostrar el AlertDialog
            AlertDialog alertDialog = builder.create();
            alertDialog.show();

        });

        //cambiar layout


    }


    public void jugar (Eleccion eleccionUsuario){
        int eleccionMaquina = (int) (Math.random() * 3) + 1;
        switch (eleccionMaquina){
            case(1)://piedra
                ivRespuesta.setImageResource(R.drawable.piedra);
                if(eleccionUsuario==Eleccion.PAPEL){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    contUsuario++;
                    tvContUsuario.setText(String.valueOf(contUsuario));
                } else if (eleccionUsuario==Eleccion.TIJERA) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    contMaquina++;
                    tvContMaquina.setText(String.valueOf(contMaquina));
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                }
            break;

            case(2)://papel
                ivRespuesta.setImageResource(R.drawable.papel);
                if(eleccionUsuario==Eleccion.TIJERA){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    contUsuario++;
                    tvContUsuario.setText(String.valueOf(contUsuario));
                } else if (eleccionUsuario==Eleccion.PIEDRA) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    contMaquina++;
                    tvContMaquina.setText(String.valueOf(contMaquina));
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                }
            break;

            case(3)://tijera
                ivRespuesta.setImageResource(R.drawable.tijera);
                if(eleccionUsuario==Eleccion.PIEDRA){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    contUsuario++;
                    tvContUsuario.setText(String.valueOf(contUsuario));
                } else if (eleccionUsuario==Eleccion.PAPEL) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    contMaquina++;
                    tvContMaquina.setText(String.valueOf(contMaquina));
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                }
            break;
        }
    }

}