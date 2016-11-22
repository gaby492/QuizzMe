package com.example.al342839.quizzme;

/**
 * Created by Anairene on 22/11/2016.
 */

public class Resultado {
    private int id_resu;
    private String resultado;
    private int id_enc;

    public Resultado(int id_resu, String resultado, int id_enc)
    {
        this.resultado = resultado;
        this.id_resu = id_resu;
        this.id_enc = id_enc;
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
}
