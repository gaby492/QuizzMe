package com.example.al342839.quizzme;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.widget.GridView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    //GridView categoriasGridView;
    TextView textView;

    @Override
    public void onProvideAssistData(Bundle data) {
        super.onProvideAssistData(data);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView=(TextView) findViewById(R.id.textView);

        MiBaseDeDatos MDB = new MiBaseDeDatos(getApplicationContext());
        // Escribimos 4 registros en nuestra tabla
        MDB.borrarCATEGORIAS();
        MDB.insertarCATEGORIA(1,"Personajes");
        MDB.insertarCATEGORIA(2,"YouTubers");
        MDB.insertarCATEGORIA(3,"Amor");
        MDB.insertarCATEGORIA(4,"Peliculas");

        MDB.borrarENCUESTAS();
        MDB.insertarENCUESTA(1, "Princesas de Disney", 1);
        MDB.insertarENCUESTA(2, "Príncipes de Disney", 1);

        MDB.borrarPREGUNTAS();
        MDB.insertarPREGUNTA(1, "¿Dónde preferirías vivir?", 1);
        MDB.insertarPREGUNTA(2, "¿Cómo es tu personalidad?", 1);
        MDB.insertarPREGUNTA(3, "¿Cuál es tu estilo al vestir?", 2);
        MDB.insertarPREGUNTA(4, "¿Cómo sería tu chica ideal?", 2);

        MDB.borrarPREGUNTAS();
        MDB.insertarPREGUNTA(1, "¿Dónde preferirías vivir?", 1);
        MDB.insertarPREGUNTA(2, "¿Cómo es tu personalidad?", 1);
        MDB.insertarPREGUNTA(3, "¿Cuál es tu estilo al vestir?", 2);
        MDB.insertarPREGUNTA(4, "¿Cómo sería tu chica ideal?", 2);

        MDB.borrarRESPUESTAS();
        MDB.insertarRESPUESTA(1, "Mansión", 1);
        MDB.insertarRESPUESTA(2, "Ruda", 2);
        MDB.insertarRESPUESTA(3, "Colorida", 3);
        MDB.insertarRESPUESTA(4, "Con bonita personalidad", 4);

        // Recuperamos los 4 registros y los mostramos en el log
        int num = MDB.recuperarCATEGORIAS().size();

        Log.d("TOTAL", Integer.toString(num));
        int[] ids = new int[num];
        String[] nombres = new String[num];
        for (int i = 0; i < num; i++) {
            ids[i] = MDB.recuperarCATEGORIAS().get(i).getId();
            nombres[i] = MDB.recuperarCATEGORIAS().get(i).getNombre();
            Log.i(""+ids[i], nombres[i]);
        }


        int num2 = MDB.recuperarENCUESTAS().size();
        //textView.setText(num2);

        Log.d("TOTAL", Integer.toString(num2));
        int[] idsEnc = new int[num2];
        String[]encuestas = new String[num2];
        int[] idsCat = new int[num2];
        for (int i = 0; i < num2; i++) {
            idsEnc[i] = MDB.recuperarENCUESTAS().get(i).getId_enc();
            encuestas[i] = MDB.recuperarENCUESTAS().get(i).getEncuesta();
            idsCat[i] = MDB.recuperarENCUESTAS().get(i).getId_cat();
            Log.i(""+idsEnc[i], encuestas[i]);
            textView.setText(encuestas[i]);
        }

        int num3 = MDB.recuperarPREGUNTAS().size();

        Log.d("TOTAL", Integer.toString(num3));
        int[] idsPre = new int[num3];
        String[]preguntas = new String[num3];
        for (int i = 0; i < num3; i++) {
            idsPre[i] = MDB.recuperarPREGUNTAS().get(i).getId_pre();
            preguntas[i] = MDB.recuperarPREGUNTAS().get(i).getPregunta();
            Log.i(""+idsPre[i], preguntas[i]);

        }

        int num4 = MDB.recuperarRESPUESTAS().size();

        Log.d("TOTAL", Integer.toString(num4));
        int[] idsRes = new int[num4];
        String[]respuestas = new String[num4];
        for (int i = 0; i < num4; i++) {
            idsRes[i] = MDB.recuperarRESPUESTAS().get(i).getId_res();
            respuestas[i] = MDB.recuperarRESPUESTAS().get(i).getRespuesta();
            Log.i(""+idsRes[i], respuestas[i]);

        }





    }
}
