package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a9Intents extends AppCompatActivity {
    public static final String URL_CANCION = "https://youtu.be/RCJDY26yVcQ?si=0Ixuj01iKgUD1zgG";
    public static final String CADENA_SMS_A_PACO = "Te veo hoy a las 6pm";
    public static final String NUMERO_PACO = "123456789";
    public static final String STRING_GEOLOCA = "geo:0,0?q=C.+de+la+Caoba,+1,+28005+Madrid";
    Button btCancion, bt666, btSMS, btSorpresa;
    TextView tvError;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a9_intents);

        btCancion=findViewById(R.id.u3a9btCancion);
        bt666=findViewById(R.id.u3a9btMarcarNum);
        btSMS=findViewById(R.id.u3a9btEnviarSMS);
        btSorpresa=findViewById(R.id.u3a9btSorpresa);
        tvError=findViewById(R.id.u3a9tvError);

        btCancion.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            intent.putExtra(SearchManager.QUERY, URL_CANCION);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Si no hay ninguna aplicación para realizar la búsqueda web, muestra un mensaje de error
                tvError.setText("No se encontró una aplicación para realizar la búsqueda web.");
            }
        });

        bt666.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "666"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                tvError.setText("No se encontró una aplicación para llamar.");
            }
        });

        btSMS.setOnClickListener(view -> {
            Uri uri = Uri.parse("smsto:" + NUMERO_PACO);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", CADENA_SMS_A_PACO);

            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                // Si no hay ninguna aplicación para enviar mensajes de texto, muestra un mensaje de error
                tvError.setText("No se encontró una aplicación para enviar mensajes de texto.");
            }
        });

        /*btSorpresa.setOnClickListener(view -> {
            Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM)
                    .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                    .putExtra(AlarmClock.EXTRA_HOUR, 20)
                    .putExtra(AlarmClock.EXTRA_MINUTES, 30);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }else{
                // Si no hay ninguna aplicación para poner alarma
                tvError.setText("No se encontró una aplicación para alarmas.");
            }
        });*/

    }
}