package com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api;

import java.io.Serializable;
import java.util.ArrayList;

public class Pelicula implements Serializable {
    public String nombre;
    public String descripcion;
    public int estrellas;
    public Actor[] actores;

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

    public Actor[] getActores() {
        return actores;
    }

    public static ArrayList<Pelicula> generador(ArrayList<Pelicula> listadoApiPeliculas) {

        ArrayList<Pelicula> listadoPeliculas = new ArrayList<Pelicula>();

        // Si se proporciona una lista de consejos desde el ViewModel, la utilizamos
        if (listadoApiPeliculas != null && !listadoApiPeliculas.isEmpty()) {
            listadoPeliculas.addAll(listadoApiPeliculas);
        }

        return listadoPeliculas;
    }
}
