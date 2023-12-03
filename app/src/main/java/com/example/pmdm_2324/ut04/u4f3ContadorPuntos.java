package com.example.pmdm_2324.ut04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.pmdm_2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4f3ContadorPuntos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4f3ContadorPuntos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public u4f3ContadorPuntos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4f3ContadorPuntos.
     */
    // TODO: Rename and change types and number of parameters
    public static u4f3ContadorPuntos newInstance(String param1, String param2) {
        u4f3ContadorPuntos fragment = new u4f3ContadorPuntos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public static final int PUNTUACION_VICTORIA = 5;
    TextView tvContPuntosA, tvContPuntosB;
    EditText etNombrePartida;
    int contA = 0, contB = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.u4f3_contador_puntos, container, false);
        //Encontramos nuestas cositas
        tvContPuntosA = layout.findViewById(R.id.u4f3tvContPuntosA);
        tvContPuntosB = layout.findViewById(R.id.u4f3tvContPuntosB);
        etNombrePartida = layout.findViewById(R.id.u4f3etNombrePartida);

        tvContPuntosA.setOnClickListener((v) -> {
            contA++;
            tvContPuntosA.setText(String.valueOf(contA));
            gestionarFinPartida();
        });

        tvContPuntosB.setOnClickListener((v) -> {
            contB++;
            tvContPuntosB.setText(String.valueOf(contB));
            gestionarFinPartida();
        });

        return layout;
    }

    public void gestionarFinPartida() {
        if (contA < PUNTUACION_VICTORIA && contB < PUNTUACION_VICTORIA) return;

        //NOTIFICAR FINAL DE PARTIDA a los suscriptores
        char ganador = contA > contB ? 'A' : 'B';
        finalPartidaListener.indicarFin(etNombrePartida.getText().toString(), ganador);
    }

    public interface IFinalPartidaListener {
        //En este metodo le pasa unos datos a todos sus suscriptores, y cada suscriptor hara lo que sea que diga su metodo
        public void indicarFin(String nombrePartida, char ganador);
    }

    IFinalPartidaListener finalPartidaListener;

    public void setFinalPartidaListener(IFinalPartidaListener obs) {
        finalPartidaListener = obs;
    }
}