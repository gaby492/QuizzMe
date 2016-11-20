package com.example.al342839.quizzme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ListaEncuestasActivity extends AppCompatActivity {
    TextView encabezado;
    ImageView imgEncabezado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_encuestas);
        encabezado =(TextView) findViewById(R.id.textView);
        imgEncabezado=(ImageView) findViewById(R.id.imageView2);
        usarToolbar();
        MiBaseDeDatos MDB = new MiBaseDeDatos(getApplicationContext());

        List<Encuesta> encuestas;

        Intent intent= getIntent();
        Bundle b=  intent.getExtras();
        b.get("idCategoria");
        String id= (String) b.get("idCategoria");
        int idCategoria= Integer.parseInt(id) +1;

        //Obtener el titulo e imagen de la categoria
        Categoria categoria=MDB.recuperarCATEGORIA(idCategoria);
        encabezado.setText(categoria.getNombre());
        imgEncabezado.setImageResource(categoria.getIdDrawable());



        encuestas=MDB.recuperarENCUESTAS(idCategoria);
        ListView encuestasListView=(ListView) findViewById(R.id.listView);

        ArrayAdapter<Encuesta> myAdapter = new ArrayAdapter<Encuesta>(getApplicationContext(),
                android.R.layout.simple_list_item_1, android.R.id.text1, encuestas);

        ListAdapter myCustomAdapter= new ListaEncuestaCustomAdapter(this,R.layout.encuestas, encuestas);
        encuestasListView.setAdapter(myCustomAdapter);
    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
