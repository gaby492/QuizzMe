package com.example.al342839.quizzme;

/**
 * Created by al342839 on 10/27/2016.
 */

public class Categoria {
    private int id;
    private String nombre;


    public Categoria(int id, String nombre){
         this.id = id;
        this.nombre = nombre;
     }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
