package com.example.pmdm_2324.ut06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class DulcesNavideños {
      String nombre;
      boolean frutosSecos;
      int calorias;

    private static final double MAX_CALORIAS = 500;
    public static final int DULCES_INICIALES = 5;
    private static ArrayList<String> dulces = new ArrayList<String>(Arrays.asList(
            new String[]{"Polvoron", "Frutas Escarchadas","Trufas de chocolate","Bastones de Caramelo","Polvoron de Chocolate", "Polvoron de Canela","Polvoron de Coco","Polvoron de Naranja", "Polvoron de Pistacho", "Polvoron de Limon", "Panettone con Pasas","Panettone con Chocolate", "Pannetone de Limon","Polvoron de almendras", "Mazapán", "Turrón de Trufa","Turrón de Alicante", "Turrón de Almendra","Turrón de Cafe", "Turrón de Frutas","Turrón de Yema", "Turrón de Chocolate", "Roscón de Reyes", "Chocolate caliente", "Galletas de jengibre"}));

    //sustituye a la llamada a api, porque lo estamos haciendo en local
    public static DulcesNavideños generateDulce(){
        // barajea el array y de este forma es "aleatorio" y coge las dos primeras posiciones
        Collections.shuffle(dulces);
        DulcesNavideños dulce = new DulcesNavideños();
        dulce.nombre = dulces.get(0);
        dulce.frutosSecos= (int)(Math.random()*100)>50;//Podria mejorar
        dulce.calorias = (int)(Math.random()* MAX_CALORIAS);
        return dulce;
    }

    public static DulcesNavideños[] generateDulces(int n) {
        DulcesNavideños[] dulces = new DulcesNavideños[n];
        for(int i = 0; i< n; i++){
            dulces[i] = DulcesNavideños.generateDulce();
        }
        return dulces;
    }
    //hasta aqui
}
