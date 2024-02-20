package com.example.pmdm_2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class u8a1NumAleatorioViewModel extends ViewModel {
    private static final double DELAY = 500;
    private static final int MAX_NUM = 10000;
    public static final Integer FAIL = -1;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<Integer>();
            cargaNumero();
        }
        return misDatos;
    }

    public void cargaNumero() {
        // Magia de threads!!!
        new Thread(
                () -> {
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        //He recibido los datos (simila peticion remoto)
                        int i = (int) (Math.random() * MAX_NUM);
                        //¿?
                        misDatos.postValue(i);// IDK este metodo realiza dos operaciones importantes: 1. cambia el valor interno de "misDatos" 2. hace notify a todos sus suscriptores (añadidos al usar .observe)
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();

    }
}
