package com.example.pmdm_2324.ut08;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class u8a3ParesNonesVM extends ViewModel {
    private static final double DELAY = 500;
    private static final int MAX_NUM = 5;
    public static final Integer FAIL = -1;
    private MutableLiveData<Resultado> misDatos;

    public LiveData<Resultado> getResultado() {
        if (misDatos == null) {
            misDatos = new MutableLiveData<Resultado>();
            //jugar();
        }
        return misDatos;
    }

    public void jugar(int numUsuario, boolean juegaPares) {
        // Magia de threads!!!
        new Thread(
                () -> {
                    try {
                        Thread.sleep((long) ((Math.random() * DELAY) + DELAY));
                        // Creamos aleatoriamente el numero que juega la maquina
                        int numMaquina = (int) (Math.random() * MAX_NUM);

                        //Segun sea el resultado y segun la eleccion de usuario enviamos un objeto resultado
                        Resultado miResultado;
                        if (juegaPares) miResultado = new Resultado(numMaquina, (numMaquina + numUsuario) % 2 == 0);
                        else   miResultado = new Resultado(numMaquina, (numMaquina + numUsuario) % 2 != 0);

                        //miResultado = new Resultado(numMaquina, !(juegaPares ^ (numMaquina+numUsuario) % 2 == 0)); Fer (usad xor pendejos)

                        misDatos.postValue(miResultado);
                    } catch (InterruptedException e) {
                        //si algo saliese mal
                        misDatos.postValue(null);
                        //throw new RuntimeException(e);
                    }
                }
        ).start();

    }

    public class Resultado {
        private Integer numMaquina;
        private Boolean victoriaUsuario;

        public Resultado(Integer numMaquina, Boolean victoriaUsuario) {
            this.numMaquina = numMaquina;
            this.victoriaUsuario = victoriaUsuario;
        }
        public Integer getNumMaquina() {
            return numMaquina;
        }

        public Boolean getVictoriaUsuario() {
            return victoriaUsuario;
        }
        
    }
}
