package com.example.labsoftware20.academia;

/**
 * Created by labSoftware20 on 16/08/17.
 */
public abstract class Persona {

private String nombre,ID,Direccion,Rol;


    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setID(String id){
        this.ID=id;
    }

    public String getID()
    {
        return ID;
    }
    public void setDireccion(String direccion){
        this.Direccion=direccion;
    }

    public String getDireccion()
    {
        return Direccion;
    }
    public void setRol(String rol){
        this.Rol=rol;
    }

    public String getRol()
    {
        return Rol;
    }

    public abstract String getInformation();





}
