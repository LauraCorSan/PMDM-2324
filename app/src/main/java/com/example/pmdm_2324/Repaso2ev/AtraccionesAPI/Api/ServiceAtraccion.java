package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api;

import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.RepoPelicula;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.ServicePelicula;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceAtraccion {
    private static ServiceAtraccion instancia;
    private static RepoAtraccion repo;

    private ServiceAtraccion() {
        // Hago cosas
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoAtraccion.class);
    }

    public static RepoAtraccion getRepo() {
        return repo;
    }

    public static ServiceAtraccion getInstancia() {
        if (instancia == null) {
            instancia = new ServiceAtraccion();
        }
        return instancia;
    }
}
