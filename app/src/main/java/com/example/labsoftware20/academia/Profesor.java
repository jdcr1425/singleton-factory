package com.example.labsoftware20.academia;

/**
 * Created by labSoftware20 on 16/08/17.
 */
public class Profesor extends Persona {

    public String getInformation(){

        return "Id: "+getID()+"\n"+"Nombre : "+getNombre()+ "\n"+ "Direccion : "+ getDireccion()+"\n"+ "Rol :"+ getRol();
    }


}
