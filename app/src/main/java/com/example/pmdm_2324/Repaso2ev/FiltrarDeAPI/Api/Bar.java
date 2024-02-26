package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api;

import java.io.Serializable;
import java.util.ArrayList;

public class Bar implements Serializable {
    public String nombre;
    public String descripcion;
    public int estrellas;

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getEstrellas() {
        return estrellas;
    }
    public String getStringEstrellas() {
        String estrellitas = "";
        for (int i = 0; i <= estrellas; i++) {
            estrellitas += "★";
        }
        return estrellitas;
    }


    public static ArrayList<Bar> generador(ArrayList<Bar> listadoApiBares) {

        ArrayList<Bar> listadoBares = new ArrayList<Bar>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoApiBares != null && !listadoApiBares.isEmpty()) {
            listadoBares.addAll(listadoApiBares);
        }

        return listadoBares;
    }
}
