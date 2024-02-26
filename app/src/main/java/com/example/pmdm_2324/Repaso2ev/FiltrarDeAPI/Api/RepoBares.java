package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api;

import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.Bar;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

import java.util.List;

public interface RepoBares {
    @GET("/api/bares/")
    Call<List<Bar>> getBares();

    @GET("/api/bares/")
    Call<List<Bar>> getBaresPorEstrella(@Query("estrellas") int num);
}
