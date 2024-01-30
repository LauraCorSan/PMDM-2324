package InicioProyecto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pmdm_2324.R;


public class APListadoConsejos extends AppCompatActivity {
    public static final String INFO_CONSEJO = "unConsejilloPaPadres" ;
    public static final String INFO_TITULO = "unTitulo" ;
    public static final String INFO_DESCRIPCION = "unaDescripcionChula" ;
    public static final String INFO_EDAD_MESES = "unosMeses" ;
    RecyclerView rcv;
    ConsejoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.a_p_listado_consejos);
        rcv = findViewById(R.id.PrcvListaConsejos);
        rcv.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ConsejoAdapter(Consejo.generador());
        rcv.setAdapter(adapter);

        adapter.setClickListener(new ConsejoAdapter.ItemClickListener() {
            @Override
            public void onClick(View view, int position, Consejo consejillo) {

                Intent i = new Intent(APListadoConsejos.this, APDetallesConsejos.class);
                i.putExtra(INFO_CONSEJO,consejillo);

                //i.putExtra(INFO_TITULO, consejillo.getTitulo());
                //i.putExtra(INFO_DESCRIPCION, consejillo.getDescripcion());
                //i.putExtra(INFO_EDAD_MESES, String.valueOf(consejillo.getEdadMeses()));

                startActivity(i);
            }
        });
    }
}