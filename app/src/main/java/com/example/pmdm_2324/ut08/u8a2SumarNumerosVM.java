package com.example.pmdm_2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class u8a2SumarNumerosVM extends ViewModel {
    private static final double DELAY = 500;
    public static final Integer FAIL = -1;
    private MutableLiveData<Integer> misDatos;

    public LiveData<Integer> getNumero() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<Integer>();
            //sumarNumeros();
        }
        return misDatos;
    }

    public void sumarNumeros(int num1, int num2) {
        // Magia de threads!!!
        new Thread(
                () -> {
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        //He recibido los datos (simila peticion remoto)
                        int i = num1+num2;
                        //¿?
                        misDatos.postValue(i);
                    } catch (InterruptedException e) {
                        misDatos.postValue(FAIL);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();

    }
}
