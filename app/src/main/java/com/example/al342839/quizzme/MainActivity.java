package com.example.al342839.quizzme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private CategoriaAdapter adaptador;
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
        usarToolbar();

        SharedPreferences pref= getSharedPreferences("pref", this.MODE_PRIVATE);
        String nombre = pref.getString("crearBD", "true");

        MiBaseDeDatos MDB = new MiBaseDeDatos(getApplicationContext());
        if(nombre == "true")
        {
            ingresarDatosBD(MDB);
            SharedPreferences.Editor editor =pref.edit();
            editor.putString("crearBD", "false");
            editor.commit();
        }
        
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
            //textView.setText(encuestas[i]);
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

        gridView = (GridView) findViewById(R.id.grid);
        adaptador = new CategoriaAdapter(this);
        gridView.setAdapter(adaptador);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(getApplicationContext(), "Click en registro " +  position, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, ListaEncuestasActivity.class);
                intent.putExtra("idCategoria", position + "");
                startActivity(intent);
            }
        });
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void ingresarDatosBD(MiBaseDeDatos MDB)
    {
        MDB.borrarCATEGORIAS();
        MDB.insertarCATEGORIA(1,"Personajes", R.drawable.personaje);
        MDB.insertarCATEGORIA(2,"YouTubers", R.drawable.youtube);
        MDB.insertarCATEGORIA(3,"Amor", R.drawable.heart);
        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarENCUESTAS();
        MDB.insertarENCUESTA(1, "Princesas de Disney", 1);
        MDB.insertarENCUESTA(2, "Príncipes de Disney", 1);
        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarPREGUNTAS();
        MDB.insertarPREGUNTA(1, "¿Dónde preferirías vivir?", 1);
        MDB.insertarPREGUNTA(2, "¿Cómo es tu personalidad?", 1);
        MDB.insertarPREGUNTA(3, "¿Cuál es tu estilo al vestir?", 2);
        MDB.insertarPREGUNTA(4, "¿Cómo sería tu chica ideal?", 2);
        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarRESPUESTAS();
        MDB.insertarRESPUESTA(1, "Mansión", 1);
        MDB.insertarRESPUESTA(2, "Casa", 1);
        MDB.insertarRESPUESTA(3, "Departamento", 1);
        MDB.insertarRESPUESTA(4, "Hotel", 1);

        MDB.insertarRESPUESTA(5, "Ruda", 2);
        MDB.insertarRESPUESTA(6, "Timida", 2);
        MDB.insertarRESPUESTA(7, "Alegre", 2);
        MDB.insertarRESPUESTA(8, "Traviesa", 2);

        MDB.insertarRESPUESTA(9, "Colorida", 3);
        MDB.insertarRESPUESTA(10, "Con bonita personalidad", 4);
    }

}
