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
        MDB.insertarCATEGORIA("Personajes");
        MDB.insertarCATEGORIA("YouTubers");
        MDB.insertarCATEGORIA("Amor");
        MDB.insertarCATEGORIA("Peliculas");

        MDB.borrarENCUESTAS();
        MDB.insertarENCUESTA(1, "Princesas de Disney", 1);
        MDB.insertarENCUESTA(2, "Príncipes de Disney", 1);

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




        /*categoriasGridView = (GridView) findViewById(R.id.categoriasGridVew);

        ListAdapter myImageAdapter = new ImageAdapter(this, R.layout.categoria_layout, categorias);
        categoriasGridView.setAdapter(myImageAdapter);



        categoriasGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String peli = categoriasGridView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(),"Click en registro " + peli, Toast.LENGTH_SHORT).show();

                Intent i = new Intent(MainActivity.this,ImagenPelicula.class);
                i.putExtra("peli",peli);
                startActivity(i);


            }
        });*/




    }
}
