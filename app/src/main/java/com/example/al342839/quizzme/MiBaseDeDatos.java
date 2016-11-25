package com.example.al342839.quizzme;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by al342839 on 10/27/2016.
 */

public class MiBaseDeDatos extends SQLiteOpenHelper {
    private static final int VERSION_BD = 1;
    private static final String NOMBRE_BD = "miBD.db";
    private static final String TABLA_CATEGORIA = "CREATE TABLE IF NOT EXISTS categoria" + "(id_cat INTEGER, categoria TEXT, id_img INTEGER)";
    private static final String TABLA_ENCUESTA=  "CREATE TABLE IF NOT EXISTS encuesta" + "(id_enc INTEGER, encuesta TEXT, id_cat INTEGER)";
    private static final String TABLA_PREGUNTA = "CREATE TABLE IF NOT EXISTS pregunta" + "(id_pre INTEGER, pregunta TEXT, id_enc INTEGER)";
    private static final String TABLA_RESPUESTA = "CREATE TABLE IF NOT EXISTS respuesta" + "(id_res INTEGER, respuesta TEXT, id_pre INTEGER)";
    private static final String TABLA_RESULTADO = "CREATE TABLE IF NOT EXISTS resultado" + "(id_resu INTEGER, resultado TEXT, descripcion TEXT, id_enc INTEGER, imagen INTEGER)";
    public MiBaseDeDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CATEGORIA);
        db.execSQL(TABLA_ENCUESTA);
        db.execSQL(TABLA_PREGUNTA);
        db.execSQL(TABLA_RESPUESTA);
        db.execSQL(TABLA_RESULTADO);
        Log.i("APP BD", "La Base de Datos y las Tablas han sido creadas!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL("DROP TABLE IF EXISTS encuesta");
        db.execSQL("DROP TABLE IF EXISTS pregunta");
        db.execSQL("DROP TABLE IF EXISTS respuesta");
        db.execSQL("DROP TABLE IF EXISTS resultado");
        onCreate(db);
    }


    public void insertarCATEGORIA(int id_cat, String categoria, int id_img) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id_cat", id_cat);
            valores.put("categoria", categoria);
            valores.put("id_img", id_img);
            db.insert("categoria", null, valores);
            db.close();
        }
    }

    public void insertarENCUESTA(int id_enc, String encuesta, int id_cat) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id_enc", id_enc);
            valores.put("encuesta", encuesta);
            valores.put("id_cat", id_cat);

            db.insert("encuesta", null, valores);

            db.close();
        }
    }

    public void insertarPREGUNTA(int id_pre, String pregunta, int id_enc) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id_pre", id_pre);
            valores.put("pregunta", pregunta);
            valores.put("id_enc", id_enc);

            db.insert("pregunta", null, valores);

            db.close();
        }
    }

    public void insertarRESPUESTA(int id_res, String respuesta, int id_pre) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id_res", id_res);
            valores.put("respuesta", respuesta);
            valores.put("id_pre", id_pre);

            db.insert("respuesta", null, valores);

            db.close();
        }
    }

    public void insertarRESULTADO(int id_resu, String resultado, String descripcion, int id_enc, int imagen) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            valores.put("id_resu", id_resu);
            valores.put("resultado", resultado);
            valores.put("descripcion", descripcion);
            valores.put("id_enc", id_enc);
            valores.put("imagen", imagen);

            db.insert("resultado", null, valores);

            db.close();
        }
    }

    public Categoria recuperarCATEGORIA(int id_cat) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_cat", "categoria", "id_img"};
        Cursor cursor = db.query("categoria", valores_recuperar, "id_cat=" + id_cat,
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Categoria categoria = new Categoria(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        db.close();
        cursor.close();
        return categoria;
    }

    public Encuesta recuperarENCUESTA(int id_enc) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_enc", "encuesta", "id_cat"};
        Cursor cursor = db.query("encuesta", valores_recuperar, "id_enc=" + id_enc,
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Encuesta encuesta = new Encuesta(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        db.close();
        cursor.close();
        return encuesta;
    }

    public Encuesta recuperarENCUESTA_ID(String encuestaid) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_enc", "encuesta", "id_cat"};
        Cursor cursor = db.query("encuesta", valores_recuperar, "encuesta = '" + encuestaid+ "'",
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Encuesta encuesta = new Encuesta(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        db.close();
        cursor.close();
        return encuesta;
    }

    public Pregunta recuperarPREGUNTA(int id_pre) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_pre", "pregunta", "id_enc"};
        Cursor cursor = db.query("pregunta", valores_recuperar, "id_pre=" + id_pre,
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Pregunta pregunta = new Pregunta(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        db.close();
        cursor.close();
        return pregunta;
    }

    public Respuesta recuperarRESPUESTA(int id_res) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_res", "respuesta", "id_pre"};
        Cursor cursor = db.query("respuesta", valores_recuperar, "id_res=" + id_res,
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Respuesta respuesta = new Respuesta(cursor.getInt(0),cursor.getString(1), cursor.getInt(2));
        db.close();
        cursor.close();
        return respuesta;
    }

    public Resultado recuperarRESULTADO(int id_resu, int id_enc) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id_resu", "resultado","descripcion", "id_enc", "imagen"};
        Cursor cursor = db.query("resultado", valores_recuperar, "id_resu=" + id_resu+" and id_enc="+id_enc,null,null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Resultado resultado = new Resultado(cursor.getInt(0),cursor.getString(1),cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
        db.close();
        cursor.close();
        return resultado;
    }

    public List<Categoria> recuperarCATEGORIAS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Categoria> lista_categorias = new ArrayList<Categoria>();
        String[] valores_recuperar = {"id_cat", "categoria", "id_img"};
        Cursor cursor = db.query("categoria", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Categoria categorias = new Categoria(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_categorias.add(categorias);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_categorias;
    }

    public List<Encuesta> recuperarENCUESTAS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Encuesta> lista_encuestas = new ArrayList<Encuesta>();
        String[] valores_recuperar = {"id_enc", "encuesta", "id_cat"};
        Cursor cursor = db.query("encuesta", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Encuesta encuesta = new Encuesta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_encuestas.add(encuesta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_encuestas;
    }

    public List<Encuesta> recuperarENCUESTAS(int id) {
        SQLiteDatabase db = getReadableDatabase();
        List<Encuesta> lista_encuestas = new ArrayList<Encuesta>();
        String[] valores_recuperar = {"id_enc", "encuesta", "id_cat"};
        Cursor cursor = db.query("encuesta", valores_recuperar,"id_cat=" + id, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Encuesta encuesta = new Encuesta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_encuestas.add(encuesta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_encuestas;
    }

    public List<Pregunta> recuperarPREGUNTAS() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Pregunta> lista_preguntas = new ArrayList<Pregunta>();
        String[] valores_recuperar = {"id_pre", "pregunta", "id_enc"};
        Cursor cursor = db.query("pregunta", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Pregunta pregunta = new Pregunta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_preguntas.add(pregunta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_preguntas;
    }

    public List<Respuesta> recuperarRESPUESTAS() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Respuesta> lista_respuestas = new ArrayList<Respuesta>();
        String[] valores_recuperar = {"id_res", "respuesta", "id_pre"};
        Cursor cursor = db.query("respuesta", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Respuesta respuesta = new Respuesta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_respuestas.add(respuesta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_respuestas;
    }

    public List<Resultado> recuperarRESULTADOS() {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Resultado> lista_resultados = new ArrayList<Resultado>();
        String[] valores_recuperar = {"id_resu", "resultado","descripcion", "id_enc", "imagen"};
        Cursor cursor = db.query("resultado", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Resultado resultado = new Resultado(cursor.getInt(0), cursor.getString(1),cursor.getString(2), cursor.getInt(3), cursor.getInt(4));
            lista_resultados.add(resultado);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_resultados;
    }

    public void borrarCATEGORIAS()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS categoria");
        onCreate(db);
        db.close();
    }

    public void borrarENCUESTAS()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS encuesta");
        onCreate(db);
        db.close();
    }

    public void borrarPREGUNTAS()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS pregunta");
        onCreate(db);
        db.close();
    }

    public void borrarRESPUESTAS()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS respuesta");
        onCreate(db);
        db.close();
    }

    public void borrarRESULTADOS()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS resultado");
        onCreate(db);
        db.close();
    }

    public List<Pregunta> recuperarPREGUNTAS_DE_ENC(int id_enc) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Pregunta> lista_preguntas = new ArrayList<Pregunta>();
        String[] valores_recuperar = {"id_pre", "pregunta", "id_enc"};
        Cursor cursor = db.query("pregunta", valores_recuperar,"id_enc="+id_enc, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Pregunta pregunta = new Pregunta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_preguntas.add(pregunta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_preguntas;
    }


    public List<Respuesta> recuperarRESPUESTAS_DE_PRE(int id_pre) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Respuesta> lista_respuestas = new ArrayList<Respuesta>();
        String[] valores_recuperar = {"id_res", "respuesta", "id_pre"};
        Cursor cursor = db.query("respuesta", valores_recuperar,"id_pre="+id_pre, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Respuesta respuesta = new Respuesta(cursor.getInt(0), cursor.getString(1), cursor.getInt(2));
            lista_respuestas.add(respuesta);
        } while (cursor.moveToNext());
        db.close();
        cursor.close();
        return lista_respuestas;
    }

}
