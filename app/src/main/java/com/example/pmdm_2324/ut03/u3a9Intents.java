package com.example.pmdm_2324.ut03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.pmdm_2324.R;

public class u3a9Intents extends AppCompatActivity {
    Button btCancion, bt666, btSMS, btSorpresa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_u3a9_intents);

        btCancion=findViewById(R.id.u3a9btCancion);
        bt666=findViewById(R.id.u3a9btMarcarNum);
        btSMS=findViewById(R.id.u3a9btEnviarSMS);
        btSorpresa=findViewById(R.id.u3a9btSorpresa);

    }
}