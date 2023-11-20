package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pmdm_2324.R;

public class u3a1bResultado extends AppCompatActivity {
    TextView tvResultado;
    ImageView ivResultado;
    Button btCerrar;
    String resultado="";
    char operador;
    static final String  ERROR_DIV_CERO="No se puede dividir por cero";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.u3a1b_resultado);

        tvResultado=findViewById(R.id.u3a1tvResultado);
        ivResultado=findViewById(R.id.u3a1ivResultado);

        btCerrar=findViewById(R.id.u3a1btCerrar);
        int num1=0;
        int num2=0;

        Bundle info = getIntent().getExtras();
        try{num1 = Integer.valueOf(info.getString(u3a1aCalcular.INFO_NUMERO1));}
        catch(NumberFormatException e){
            resultado+="El primer operador es incorrecto\n";
            ivResultado.setImageResource(R.drawable.malpng);
        }

        try{num2 = Integer.valueOf(info.getString(u3a1aCalcular.INFO_NUMERO2));}
        catch(NumberFormatException e){
            resultado+="El segundo operador es incorrecto\n";
            ivResultado.setImageResource(R.drawable.malpng);
        }

        operador=info.getString(u3a1aCalcular.INFO_OPERADOR).charAt(0);

        if(resultado.isEmpty()) {//significa que se han ejecutado correctamente los try
            switch (operador) {
                case '+':
                    resultado = String.valueOf(num1 + num2);
                    break;
                case '-':
                    resultado = String.valueOf(num1 - num2);
                    break;
                case 'x':
                    resultado = String.valueOf(num1 * num2);
                    break;
                case '/':
                    if (num2 != 0) {
                        resultado = String.valueOf(num1 + num2);
                    } else {
                        resultado = ERROR_DIV_CERO;
                        ivResultado.setImageResource(R.drawable.malpng);
                    }
                    break;
                default:
                    break;
            }
        }
        tvResultado.setText(resultado);

        btCerrar.setOnClickListener((View v)->{
            finish();
        });

    }
}