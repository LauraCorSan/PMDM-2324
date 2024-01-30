package InicioProyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut03.u3a2aCrearHelado;

import java.io.Serializable;

public class APDetallesConsejos extends AppCompatActivity {

    TextView tvTitulo, tvDescripcion, tvEdad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_p_detalles_consejos);

        tvTitulo=findViewById(R.id.APtvTitulo);
        tvDescripcion=findViewById(R.id.APtvDescripcion);
        tvEdad=findViewById(R.id.APtvEdad);

        Intent i = getIntent();

        Serializable receivedConsejo = i.getSerializableExtra(APListadoConsejos.INFO_CONSEJO);
        Consejo newConsejo = (Consejo) receivedConsejo;

        tvTitulo.setText(newConsejo.getTitulo().toUpperCase());
        tvDescripcion.setText("\""+newConsejo.getDescripcion()+"\"");
        tvEdad.setText(newConsejo.getEdadMeses()+" meses");

        /*int edad=0;

        Bundle info = getIntent().getExtras();

        String tituloConsejo=info.getString(APListadoConsejos.INFO_TITULO);
        tvTitulo.setText(tituloConsejo);

        String descripcionConsejo=info.getString(APListadoConsejos.INFO_DESCRIPCION);
        tvDescripcion.setText(descripcionConsejo);

        try{edad = Integer.valueOf(info.getString(APListadoConsejos.INFO_EDAD_MESES));}
        catch(NumberFormatException e) {

        }
        tvEdad.setText(edad+" meses");*/

    }
}