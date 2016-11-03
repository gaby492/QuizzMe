package com.example.al342839.quizzme;

/**
 * Created by Gaby on 29/10/2016.
 */

public class Encuesta {
    private int id_enc;
    private String encuesta;
    private int id_cat;

    public Encuesta(int id_enc, String encuesta, int id_cat)
    {
        this.id_enc= id_enc;
        this.encuesta=encuesta;
        this.id_cat= id_cat;
    }

    public int getId_enc(){
        return id_enc;
    }

    public void setId_enc(int id_enc){
        this.id_enc=id_enc;
    }

    public String getEncuesta(){
        return encuesta;
    }

    public void setEncuesta(String encuesta){
        this.encuesta=encuesta;
    }

    public int getId_cat(){
        return id_cat;
    }

    public void setId_cat(int id_cat){
        this.id_cat= id_cat;
    }
}
