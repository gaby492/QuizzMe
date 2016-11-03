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
    private static final String TABLA_CATEGORIA = "CREATE TABLE IF NOT EXISTS categoria" + "(id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT)";
    private static final String TABLA_ENCUESTA=  "CREATE TABLE IF NOT EXISTS encuesta" + "(id_enc INTEGER, encuesta TEXT, id_cat INTEGER)";
    public MiBaseDeDatos(Context context) {
        super(context, NOMBRE_BD, null, VERSION_BD);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLA_CATEGORIA);
        db.execSQL(TABLA_ENCUESTA);
        Log.i("APP BD", "Las bases de datos han sido creadas");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS categoria");
        db.execSQL("DROP TABLE IF EXISTS encuesta");
        onCreate(db);
    }


    public void insertarCATEGORIA(String nombre) {
        SQLiteDatabase db = getWritableDatabase();
        if(db != null){
            ContentValues valores = new ContentValues();
            //valores.put("id", id);
            valores.put("nombre", nombre);
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

    public Categoria recuperarCATEGORIA(int id) {
        SQLiteDatabase db = getReadableDatabase();
        String[] valores_recuperar = {"id", "nombre"};
        Cursor cursor = db.query("categoria", valores_recuperar, "id=" + id,
                null, null, null, null, null);
        if(cursor != null) {
            cursor.moveToFirst();
        }
        Categoria categoria = new Categoria(cursor.getInt(0),cursor.getString(1));
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

    public List<Categoria> recuperarCATEGORIAS() {
        SQLiteDatabase db = getReadableDatabase();
        List<Categoria> lista_categorias = new ArrayList<Categoria>();
        String[] valores_recuperar = {"id", "nombre"};
        Cursor cursor = db.query("categoria", valores_recuperar,null, null, null, null, null, null);
        cursor.moveToFirst();
        do {
            Categoria categorias = new Categoria(cursor.getInt(0), cursor.getString(1));
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
}
