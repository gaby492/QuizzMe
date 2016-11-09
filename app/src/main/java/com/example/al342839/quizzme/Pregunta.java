package com.example.al342839.quizzme;

/**
 * Created by Anairene on 30/10/2016.
 */

public class Pregunta {
    private int id_pre;
    private String pregunta;
    private int id_enc;

    public Pregunta( int id_pre, String pregunta, int id_enc ) {
        this.id_enc = id_enc;
        this.id_pre = id_pre;
        this.pregunta = pregunta;
    }

    public int getId_pre() {
        return id_pre;
    }

    public void setId_pre(int id_pre) {
        this.id_pre = id_pre;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getId_enc() {
        return id_enc;
    }

    public void setId_enc(int id_enc) {
        this.id_enc = id_enc;
    }
}