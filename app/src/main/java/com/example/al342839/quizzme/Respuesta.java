package com.example.al342839.quizzme;

/**
 * Created by Anairene on 13/11/2016.
 */

public class Respuesta {
    private int id_res;
    private String respuesta;
    private int id_pre;

    public Respuesta(int id_res, String respuesta, int id_pre) {
        this.id_res = id_res;
        this.id_pre = id_pre;
        this.respuesta = respuesta;
    }

    public int getId_res() {
        return id_res;
    }

    public void setId_res(int id_res) {
        this.id_res = id_res;
    }

    public int getId_pre() {
        return id_pre;
    }

    public void setId_pre(int id_pre) {
        this.id_pre = id_pre;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
}
