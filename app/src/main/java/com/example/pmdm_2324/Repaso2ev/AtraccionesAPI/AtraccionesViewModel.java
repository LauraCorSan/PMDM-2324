package com.example.pmdm_2324.Repaso2ev.AtraccionesAPI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.Atraccion;
import com.example.pmdm_2324.Repaso2ev.AtraccionesAPI.Api.ServiceAtraccion;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AtraccionesViewModel extends ViewModel {

    private MutableLiveData<ArrayList<Atraccion>> atracciones;

    public LiveData<ArrayList<Atraccion>> getAtracciones() {
        if (atracciones == null) {
            atracciones = new MutableLiveData<ArrayList<Atraccion>>();
            generarListaAtracciones();
        }
        return atracciones;
    }

    public void generarListaAtracciones() {
        new Thread(() -> {
            ServiceAtraccion ser = ServiceAtraccion.getInstancia();
            Call<List<Atraccion>> llamada = ser.getRepo().getAtracciones();
            llamada.enqueue(new Callback<List<Atraccion>>() {
                @Override
                public void onResponse(Call<List<Atraccion>> call, Response<List<Atraccion>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Atraccion> listadoAtracciones = new ArrayList<>(response.body());

                        ArrayList<Atraccion> atraccionesProcesadas = Atraccion.generador(listadoAtracciones);
                        atracciones.postValue(atraccionesProcesadas);
                    }
                }

                @Override
                public void onFailure(Call<List<Atraccion>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }
}
