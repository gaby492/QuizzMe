package com.example.al342839.quizzme;

/**
 * Created by Anairene on 22/11/2016.
 */

public class Resultado {
    private int id_resu;
    private String resultado;
    private String descripcion;
    private int id_enc;
    private int imagen;

    public Resultado(int id_resu, String resultado, String descripcion, int id_enc, int imagen)
    {
        this.resultado = resultado;
        this.id_resu = id_resu;
        this.id_enc = id_enc;
        this.imagen = imagen;
        this.descripcion = descripcion;

    }

    public int getId_enc() {
        return id_enc;
    }

    public void setId_enc(int id_enc) {
        this.id_enc = id_enc;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    public int getId_resu() {
        return id_resu;
    }

    public void setId_resu(int id_resu) {
        this.id_resu = id_resu;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
