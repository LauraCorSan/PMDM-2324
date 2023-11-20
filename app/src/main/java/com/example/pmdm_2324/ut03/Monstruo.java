package com.example.pmdm_2324.ut03;

import java.io.Serializable;
import java.util.ArrayList;

public class Monstruo implements Serializable {
    static final String CABEZA = "*", CUERPO = "O", PATA_IZQUIERDA = "/", PATA_DERECHA = "\\";
    static final int LEFT_ARMS_POSITION = 0, RIGHT_ARMS_POSITION = 1, LEFT_LEGS_POSITION = 2, RIGHT_LEGS_POSITION = 3;
    String nombre;
    int numPatas;
    int color, brazosIzquierdos, brazosDerechos, piernasIzquierdas, piernasDerechas;

    public Monstruo(String nombre, int numPatas, int color) {
        this.nombre = nombre;
        this.numPatas = numPatas;
        this.color = color;

        ArrayList<Integer> limbsDistribution = distributeLimbs();
        this.brazosIzquierdos = limbsDistribution.get(LEFT_ARMS_POSITION);
        this.brazosDerechos = limbsDistribution.get(RIGHT_ARMS_POSITION);
        this.piernasIzquierdas = limbsDistribution.get(LEFT_LEGS_POSITION);
        this.piernasDerechas = limbsDistribution.get(RIGHT_LEGS_POSITION);
    }


    public ArrayList<Integer> distributeLimbs() {
        ArrayList<Integer> limbsDistribution = new ArrayList<>();
        int remaininglimbs = numPatas;

        int leftArms = (int) (Math.random() * remaininglimbs);
        remaininglimbs -= leftArms;
        limbsDistribution.add(leftArms);

        int rightArms = (int) (Math.random() * remaininglimbs);
        remaininglimbs -= rightArms;
        limbsDistribution.add(rightArms);

        int leftLegs = (int) (Math.random() * remaininglimbs);
        remaininglimbs -= leftLegs;
        limbsDistribution.add(leftLegs);

        int rightLegs = remaininglimbs;
        limbsDistribution.add(rightLegs);

        return limbsDistribution;
    }

    @Override
    public String toString() {
        String resultado="";
        resultado+="Nombre: "+nombre+"\n\n";

        resultado+= CABEZA + "\n";
        if(brazosIzquierdos < brazosDerechos){
            for (int i = 0; i < brazosDerechos - brazosIzquierdos; i++){
                resultado = resultado + " ";
            }
        }
        for (int i = 0; i < brazosIzquierdos; i++){
            resultado = resultado + PATA_IZQUIERDA;
        }
        resultado = resultado + " " + CUERPO + " ";
        for (int i = 0; i < brazosDerechos; i++){
            resultado = resultado + PATA_DERECHA;
        }
        if(brazosDerechos < brazosIzquierdos){
            for (int i = 0; i < brazosIzquierdos - brazosDerechos; i++){
                resultado = resultado + " ";
            }
        }
        resultado = resultado + "\n";

        //drawing lower limbs
        if(piernasIzquierdas < piernasDerechas){
            for (int i = 0; i < piernasDerechas - piernasIzquierdas; i++){
                resultado = resultado + " ";
            }
        }
        for (int i = 0; i < piernasIzquierdas; i++){
            resultado = resultado + PATA_IZQUIERDA;
        }
        resultado = resultado + "   ";
        for (int i = 0; i < piernasDerechas; i++){
            resultado = resultado + PATA_DERECHA;
        }
        if(piernasDerechas < piernasIzquierdas){
            for (int i = 0; i < piernasIzquierdas - piernasDerechas; i++){
                resultado = resultado + " ";
            }
        }
        resultado = resultado + "\n";

        return resultado;
    }
}
