package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RepoAtraccion {
    @GET("/api/atracciones/")
    Call<List<Atraccion>> getAtracciones();

    @GET("/api/atracciones/{id}/")
    Call <Atraccion> getAtraccionDetalles(@Path("id") int id);//o puede ser AtraccionDetallada

}
