package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api;


import java.io.Serializable;
import java.util.ArrayList;

public class Atraccion implements Serializable {
    public String url;
    public String nombre;
    public String descripcion;
    public int ocupantes;
    public Comentario[] comentarios;

    public String getUrl() {
        return url;
    }

    public int getIdByUrl() {
        String[]partes = url.split("/");
        int id = Integer.parseInt(partes[5]);
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getOcupantes() {
        return ocupantes;
    }

    public Comentario[] getComentarios() {
        return comentarios;
    }

    public static ArrayList<Atraccion> generador(ArrayList<Atraccion> listadoApiAtracciones) {

        ArrayList<Atraccion> listadoAtracciones = new ArrayList<Atraccion>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoApiAtracciones != null && !listadoApiAtracciones.isEmpty()) {
            listadoAtracciones.addAll(listadoApiAtracciones);
        }

        return listadoAtracciones;
    }
}
