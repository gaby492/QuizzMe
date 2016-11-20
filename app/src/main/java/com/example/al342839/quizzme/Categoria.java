package com.example.al342839.quizzme;

/**
 * Created by al342839 on 10/27/2016.
 */

public class Categoria {
    private int id;
    private String nombre;
    private int idDrawable;

    public Categoria(int id, String nombre, int idDrawable){
        this.id = id;
        this.nombre = nombre;
        this.idDrawable= idDrawable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return nombre.hashCode();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDrawable(){
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable){
        this.idDrawable=idDrawable;
    }

}
