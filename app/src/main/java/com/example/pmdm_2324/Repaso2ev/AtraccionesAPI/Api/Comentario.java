package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api;

import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;

import java.io.Serializable;
import java.util.ArrayList;

public class Comentario implements Serializable {
    String texto;

    public String getTexto() {
        return texto;
    }

    public static ArrayList<Comentario> generador(ArrayList<Comentario> listadoApiComentarios) {

        ArrayList<Comentario> listadoMisComentarios = new ArrayList<Comentario>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoApiComentarios != null && !listadoApiComentarios.isEmpty()) {
            listadoMisComentarios.addAll(listadoApiComentarios);
        }

        return listadoMisComentarios;
    }
}
