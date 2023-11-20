package com.example.pmdm_2324.ut02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u2a3Propinatron2000 extends AppCompatActivity {
    Button btUno, btDos, btTres, btCuatro, btCinco, btSeis, btSiete, btOcho, btnueve, btCero, btBorrar ,btClear, btTotal;
    TextView tvResultado, tvResTotal;
    RadioGroup grbServicio ;
    RadioButton rbExcelente, rbBueno, rbMalo;
    View.OnClickListener teclasNumeros;
    String cadenaNumeros="";
    final String limpiar="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u2a3_propinatron2000);
        //numeros
        btUno=findViewById(R.id.u2a3btUno);
        btDos=findViewById(R.id.u2a3btDos);
        btTres=findViewById(R.id.u2a3btTres);
        btCuatro=findViewById(R.id.u2a3btCuatro);
        btCinco=findViewById(R.id.u2a3btCinco);
        btSeis=findViewById(R.id.u2a3btSeis);
        btSiete=findViewById(R.id.u2a3btSiete);
        btOcho=findViewById(R.id.u2a3btOcho);
        btnueve=findViewById(R.id.u2a3btNueve);
        btCero=findViewById(R.id.u2a3btCero);
        //botone c y borar
        btBorrar=findViewById(R.id.u2a3btBorrar);
        btClear=findViewById(R.id.u2a3btClear);
        //boton final
        btTotal=findViewById(R.id.u2a3btTotal);

        tvResultado=findViewById(R.id.u2a3tvResultado);

        tvResTotal=findViewById(R.id.u2a3tvResultadoTotal);

        grbServicio=findViewById(R.id.u2a3grbServicio);

        rbExcelente=findViewById(R.id.u2a3rbExcelente);
        rbBueno= findViewById(R.id.u2a3rbBueno);
        rbMalo=findViewById(R.id.u2a3rbMalo);

        //manejador de las teclas numericas
        teclasNumeros = (View pulsado) -> {
            Button unaTecla = (Button) pulsado;
            cadenaNumeros+=unaTecla.getText().toString();
            tvResultado.setText(cadenaNumeros);
        };

        btUno.setOnClickListener(teclasNumeros);
        btDos.setOnClickListener(teclasNumeros);
        btTres.setOnClickListener(teclasNumeros);
        btCuatro.setOnClickListener(teclasNumeros);
        btCinco.setOnClickListener(teclasNumeros);
        btSeis.setOnClickListener(teclasNumeros);
        btSiete.setOnClickListener(teclasNumeros);
        btOcho.setOnClickListener(teclasNumeros);
        btnueve.setOnClickListener(teclasNumeros);
        btCero.setOnClickListener(teclasNumeros);

        btBorrar.setOnClickListener((View v) -> {
            String cadenaBorrar = tvResultado.getText().toString() ;
            if (cadenaBorrar.length() > 0) {
                cadenaBorrar = cadenaBorrar.substring(0, cadenaBorrar.length() - 1);
                cadenaNumeros=cadenaBorrar;
                tvResultado.setText(cadenaNumeros);
            }
        });

        btClear.setOnClickListener((View v) -> {
            cadenaNumeros=limpiar;
            tvResultado.setText(cadenaNumeros);
        });

        btTotal.setOnClickListener((View v)->{
            final double serExcelente=0.2;
            final double serBueno=0.1;
            if(tvResultado.getText().toString().length()>0){
                double totalCuenta= Double.parseDouble(tvResultado.getText().toString()) ;
                if(grbServicio.getCheckedRadioButtonId()==rbExcelente.getId()){
                    totalCuenta+=totalCuenta*serExcelente;
                    cadenaNumeros=String.format("%.2f€", totalCuenta);
                    tvResTotal.setText(cadenaNumeros);
                    cadenaNumeros=limpiar;
                    tvResultado.setText(cadenaNumeros);
                }else if(grbServicio.getCheckedRadioButtonId()==rbBueno.getId()){
                    totalCuenta+=totalCuenta*serBueno;
                    cadenaNumeros=String.format("%.2f€", totalCuenta);
                    tvResTotal.setText(cadenaNumeros);
                    cadenaNumeros=limpiar;
                    tvResultado.setText(cadenaNumeros);
                }else if(grbServicio.getCheckedRadioButtonId()==rbMalo.getId()){
                    cadenaNumeros=String.format("%.2f€", totalCuenta);
                    tvResTotal.setText(cadenaNumeros);
                    cadenaNumeros=limpiar;
                    tvResultado.setText(cadenaNumeros);
                }else{
                /*cadenaNumeros=String.format("%.2f€", totalCuenta);
                tvResTotal.setText(cadenaNumeros);
                cadenaNumeros=limpiar;
                tvResultado.setText(cadenaNumeros);
                //sino
                tvResTotal.setText("Seleccione servicio");
                cadenaNumeros=limpiar;
                tvResultado.setText(cadenaNumeros);*/
                }
            }


        });



    }
}