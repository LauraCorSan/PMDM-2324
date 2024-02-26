package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Atraccion;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Comentario;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.ServiceAtraccion;

import java.util.ArrayList;
import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComentariosViewModel extends ViewModel {
    private static final double DELAY = 500;

    private MutableLiveData<ArrayList<Comentario>> comentarios;

    public LiveData<ArrayList<Comentario>> getComentarios(int id) {
        if (comentarios == null) {
            comentarios = new MutableLiveData<ArrayList<Comentario>>();
            generarComentarios(id);
        }
        return comentarios;
    }

    public void generarComentarios(int id) {
        new Thread(() -> {
            try {
                Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                ServiceAtraccion ser = ServiceAtraccion.getInstancia();
                Call<Atraccion> llamada = ser.getRepo().getAtraccionDetalles(id);
                llamada.enqueue(new Callback<Atraccion>() {
                    @Override
                    public void onResponse(Call<Atraccion> call, Response<Atraccion> response) {
                        if (response.isSuccessful()) {
                            Atraccion miAtraccion = response.body();
                            ArrayList<Comentario> listadoMisComentarios = new ArrayList<>(Arrays.asList(miAtraccion.getComentarios()));

                            ArrayList<Comentario> comentariosProcesados = Comentario.generador(listadoMisComentarios);
                            comentarios.postValue(comentariosProcesados);
                        }
                    }

                    @Override
                    public void onFailure(Call<Atraccion> call, Throwable t) {
                        System.out.println("Error en la llamada: " + t.getMessage());
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        ).start();
    }
}
