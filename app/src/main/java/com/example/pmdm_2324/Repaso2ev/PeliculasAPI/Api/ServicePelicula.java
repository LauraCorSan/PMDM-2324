package com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServicePelicula {
    private static ServicePelicula instancia;
    private static RepoPelicula repo;

    private ServicePelicula() {
        // Hago cosas
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoPelicula.class);
    }

    public static RepoPelicula getRepo() {
        return repo;
    }

    public static ServicePelicula getInstancia() {
        if (instancia == null) {
            instancia = new ServicePelicula();
        }
        return instancia;
    }
}
