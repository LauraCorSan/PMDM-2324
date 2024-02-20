package com.example.pmdm_2324.ut09.data_losSimpson;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceSimpsons {
    private static ServiceSimpsons instancia;
    private static SimpsonsRepo repo;

    private ServiceSimpsons(){
        // Hago cosas
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://thesimpsonsquoteapi.glitch.me/quotes/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        repo = retrofit.create(SimpsonsRepo.class);
    }

    public static SimpsonsRepo getRepo(){
        return repo;
    }

    public static ServiceSimpsons getInstancia(){
        if(instancia == null){
            instancia =  new ServiceSimpsons();
        }
        return instancia;
    }
}
