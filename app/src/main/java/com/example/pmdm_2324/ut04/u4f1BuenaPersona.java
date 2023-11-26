package com.example.pmdm_2324.ut04;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link u4f1BuenaPersona#newInstance} factory method to
 * create an instance of this fragment.
 */
public class u4f1BuenaPersona extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public u4f1BuenaPersona() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment u4f1BuenaPersona.
     */
    // TODO: Rename and change types and number of parameters
    public static u4f1BuenaPersona newInstance(String param1, String param2) {
        u4f1BuenaPersona fragment = new u4f1BuenaPersona();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    TextView tvBuenaConducta;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.u4f1_buena_persona, container, false);
        // Inflate the layout for this fragment
        tvBuenaConducta=layout.findViewById(R.id.u4f1tvBuenaConducta);

        tvBuenaConducta.setOnClickListener(view -> {
            tvBuenaConducta.append(" | ");
        });
        return layout;
    }

}