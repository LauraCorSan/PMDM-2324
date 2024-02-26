package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceBares {
    private static ServiceBares instancia;
    private static RepoBares repo;

    private ServiceBares() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.56.101:8000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(RepoBares.class);
    }

    public static RepoBares getRepo() {
        return repo;
    }

    public static ServiceBares getInstancia() {
        if (instancia == null) {
            instancia = new ServiceBares();
        }
        return instancia;
    }
}
