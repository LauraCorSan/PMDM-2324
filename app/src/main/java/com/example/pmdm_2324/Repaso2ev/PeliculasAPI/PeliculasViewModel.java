package com.example.pmdm_2324.Repaso2ev.PeliculasAPI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.Pelicula;
import com.example.pmdm_2324.Repaso2ev.PeliculasAPI.Api.ServicePelicula;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PeliculasViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Pelicula>> peliculas;

    public LiveData<ArrayList<Pelicula>> getPeliculas() {
        if (peliculas == null) {
            peliculas = new MutableLiveData<ArrayList<Pelicula>>();
            generarListPeliculas();
        }
        return peliculas;
    }

    public void generarListPeliculas() {
        new Thread(() -> {
            ServicePelicula ser = ServicePelicula.getInstancia();
            Call<List<Pelicula>> llamada = ser.getRepo().getPeliculas();
            llamada.enqueue(new Callback<List<Pelicula>>() {
                @Override
                public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Pelicula> listadoPeliculas = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Pelicula para procesar las peliculas
                        ArrayList<Pelicula> peliculasPorcesadas = Pelicula.generador(listadoPeliculas);
                        peliculas.postValue(peliculasPorcesadas);
                    }
                }

                @Override
                public void onFailure(Call<List<Pelicula>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
