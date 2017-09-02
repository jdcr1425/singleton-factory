package com.example.labsoftware20.academia;

/**
 * Created by Juan David on 02/09/2017.
 */

public class asistenciaSingleton {
    private static final asistenciaSingleton contador=new asistenciaSingleton();
    private int Asistencia=0;

    private asistenciaSingleton(){}

    public static asistenciaSingleton getInstance() {
        return contador;
    }

    public void setAsistencia(int a){
        Asistencia+=a;
    }

    public int getAsistencia(){
        return Asistencia;
    }
}
