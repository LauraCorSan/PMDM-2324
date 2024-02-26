package com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api;

import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RepoPelicula {
    @GET("/api/peliculas_related/")
    Call<List<Pelicula>> getPeliculas();
}
