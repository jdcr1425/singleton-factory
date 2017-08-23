package com.example.labsoftware20.academia;

/**
 * Created by labSoftware20 on 16/08/17.
 */
public class FactoryAcademia {


    public static Persona getPersona(String tipo){

        if(tipo.equals("estudiante")){
            return new Estudiante();
        }else{
            return new Profesor();
        }
    }


}
