package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.Color;
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

    public static final int MAX_VICTORIAS=10;
    public int contUsuario=0;
    public  int contMaquina=0;
    public int multiplicadorEmpate=1;

    /*Cuando la actividad se recrea después de un cambio de configuración, como una rotación, Android llama al método onRestoreInstanceState(Bundle savedInstanceState).
     En este método, puedes recuperar los valores que guardaste previamente en onSaveInstanceState(). Si savedInstanceState no es nulo, significa que hay datos
     guardados y puedes recuperarlos de savedInstanceState.*/
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Guarda el estado de los contadores en el Bundle
        outState.putInt("contUsuario", contUsuario);
        outState.putInt("contMaquina", contMaquina);
        outState.putInt("multiplicadorEmpate", multiplicadorEmpate);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // La orientación actual del dispositivo
        int orientacion = getResources().getConfiguration().orientation;

        if (orientacion == Configuration.ORIENTATION_LANDSCAPE) {
            // Si el dispositivo está en horizontal (layout horizontal)
            setContentView(R.layout.u2a6_piedra_papel_tijera_land);
        } else {
            // Si el dispositivo está en vertical (layout vertical)
            setContentView(R.layout.u2a6_piedra_papel_tijera);
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
            if(pulsado.getId()==R.id.u2a6ivPiedra){
                ivPiedra.clearColorFilter();

                ivPapel.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)
                ivTijera.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)

                jugar(Eleccion.PIEDRA);
            }
            if(pulsado.getId()==R.id.u2a6ivPapel){
                ivPapel.clearColorFilter();
                ivPiedra.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)
                ivTijera.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)

                jugar( Eleccion.PAPEL);
            }
            if(pulsado.getId()==R.id.u2a6ivTijeras){
                ivTijera.clearColorFilter();

                ivPiedra.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)
                ivPapel.setColorFilter(Color.argb(100, 0, 0, 0)); // 150 es la opacidad (0-255)

                jugar( Eleccion.TIJERA);
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
                            ivPiedra.clearColorFilter();
                            ivPapel.clearColorFilter();
                            ivTijera.clearColorFilter();

                            vfFinJuego.setVisibility(View.GONE);
                            ivRespuesta.setImageResource(R.drawable.pregunta);

                            contUsuario=0;
                            tvContUsuario.setText(String.valueOf(contUsuario));

                            contMaquina=0;
                            tvContMaquina.setText(String.valueOf(contMaquina));

                            multiplicadorEmpate=1;
                            tvMensaje.setText(VACIO);

                            dialog.dismiss();
                        }
                    })
                    .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            dialog.dismiss();
                        }
                    });
            // Crear y mostrar el alert
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
        });

        /*se están guardando los valores actuales de contUsuario y contMaquina en el objeto Bundle llamado outState.
        Un Bundle es un contenedor de pares clave-valor, donde puedes almacenar datos para ser recuperados más tarde*/
        if (savedInstanceState != null) {
            contUsuario = savedInstanceState.getInt("contUsuario", 0);
            contMaquina = savedInstanceState.getInt("contMaquina", 0);
            multiplicadorEmpate = savedInstanceState.getInt("multiplicadorEmpate", 1);
            // Actualiza la interfaz de usuario con los valores restaurados
            tvContUsuario.setText(String.valueOf(contUsuario));
            tvContMaquina.setText(String.valueOf(contMaquina));
        }
    }


    public void jugar (Eleccion eleccionUsuario){
        int eleccionMaquina = (int) (Math.random() * 3) + 1;
        switch (eleccionMaquina){
            case(1)://piedra
                ivRespuesta.setImageResource(R.drawable.piedra);
                if(eleccionUsuario==Eleccion.PAPEL){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    if(multiplicadorEmpate<=1){
                        contUsuario++;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }else{
                        contUsuario+=multiplicadorEmpate;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }
                    multiplicadorEmpate=1;
                } else if (eleccionUsuario==Eleccion.TIJERA) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    if(multiplicadorEmpate<=1){
                    contMaquina++;
                    tvContMaquina.setText(String.valueOf(contMaquina));
                    }else{
                        contMaquina+=multiplicadorEmpate;
                        tvContMaquina.setText(String.valueOf(contMaquina));
                    }
                    multiplicadorEmpate=1;
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                    multiplicadorEmpate*=2;
                }
            break;

            case(2)://papel
                ivRespuesta.setImageResource(R.drawable.papel);
                if(eleccionUsuario==Eleccion.TIJERA){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    if(multiplicadorEmpate<=1){
                        contUsuario++;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }else{
                        contUsuario+=multiplicadorEmpate;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }
                    multiplicadorEmpate=1;
                } else if (eleccionUsuario==Eleccion.PIEDRA) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    if(multiplicadorEmpate<=1){
                        contMaquina++;
                        tvContMaquina.setText(String.valueOf(contMaquina));
                    }else{
                        contMaquina+=multiplicadorEmpate;
                        tvContMaquina.setText(String.valueOf(contMaquina));
                    }
                    multiplicadorEmpate=1;
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                    multiplicadorEmpate*=2;
                }
            break;

            case(3)://tijera
                ivRespuesta.setImageResource(R.drawable.tijera);
                if(eleccionUsuario==Eleccion.PIEDRA){//gana
                    tvMensaje.setText(MSG_USUARIO_GANA);
                    if(multiplicadorEmpate<=1){
                        contUsuario++;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }else{
                        contUsuario+=multiplicadorEmpate;
                        tvContUsuario.setText(String.valueOf(contUsuario));
                    }
                    multiplicadorEmpate=1;
                } else if (eleccionUsuario==Eleccion.PAPEL) {//pierde
                    tvMensaje.setText(MSG_USUARIO_PIERDE);
                    if(multiplicadorEmpate<=1){
                        contMaquina++;
                        tvContMaquina.setText(String.valueOf(contMaquina));
                    }else{
                        contMaquina+=multiplicadorEmpate;
                        tvContMaquina.setText(String.valueOf(contMaquina));
                    }
                    multiplicadorEmpate=1;
                }else{//empate
                    tvMensaje.setText(MSG_EMPATE);
                    multiplicadorEmpate*=2;
                }
            break;
        }
        if(contMaquina>=MAX_VICTORIAS || contUsuario>=MAX_VICTORIAS){
            finDeJuego();
        }
    }

    public void finDeJuego(){
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

}