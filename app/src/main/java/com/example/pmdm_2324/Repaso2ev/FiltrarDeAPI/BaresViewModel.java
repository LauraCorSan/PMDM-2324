package com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.Bar;
import com.example.pmdm_2324.Repaso2ev.FiltrarDeAPI.Api.ServiceBares;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BaresViewModel extends ViewModel {
    private MutableLiveData<ArrayList<Bar>> bares;

    public LiveData<ArrayList<Bar>> getBares(int estrellas) {

        if (bares == null) {
            bares = new MutableLiveData<ArrayList<Bar>>();
            if(estrellas == 0){
                generarTodosLosBares();
            }else{
                generarBares(estrellas);
            }

        }
        return bares;
    }

    public void generarBares(int estrellas) {
        new Thread(() -> {

            ServiceBares ser = ServiceBares.getInstancia();
            Call<List<Bar>> llamada = ser.getRepo().getBaresPorEstrella(estrellas);
            llamada.enqueue(new Callback<List<Bar>>() {
                @Override
                public void onResponse(Call<List<Bar>> call, Response<List<Bar>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Bar> listaApiBares = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Bar> baresProcesados = Bar.generador(listaApiBares);
                        bares.postValue(baresProcesados);
                    }
                }

                @Override
                public void onFailure(Call<List<Bar>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });

        }
        ).start();
    }

    public void generarTodosLosBares() {
        new Thread(() -> {

            ServiceBares ser = ServiceBares.getInstancia();
            Call<List<Bar>> llamada = ser.getRepo().getBares();
            llamada.enqueue(new Callback<List<Bar>>() {
                @Override
                public void onResponse(Call<List<Bar>> call, Response<List<Bar>> response) {
                    if (response.isSuccessful()) {
                        ArrayList<Bar> listaBares = new ArrayList<>(response.body());

                        // Utiliza el método generador() de Consejo para procesar los consejos
                        ArrayList<Bar> baresProcesados = Bar.generador(listaBares);
                        bares.postValue(baresProcesados);
                    }
                }

                @Override
                public void onFailure(Call<List<Bar>> call, Throwable t) {
                    System.out.println("Error en la llamada: " + t.getMessage());
                }
            });
        }
        ).start();
    }
}
