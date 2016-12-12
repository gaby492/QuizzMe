package com.example.al342839.quizzme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ListaEncuestasActivity extends AppCompatActivity {
    TextView encabezado;
    ImageView imgEncabezado;
    List<Encuesta> encuestas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_encuestas);
        encabezado =(TextView) findViewById(R.id.textView);
        imgEncabezado=(ImageView) findViewById(R.id.imageView2);
        usarToolbar();
        MiBaseDeDatos MDB = new MiBaseDeDatos(getApplicationContext());

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
        ListAdapter myCustomAdapter= new ListaEncuestaCustomAdapter(this,R.layout.encuestas, encuestas);
        encuestasListView.setAdapter(myCustomAdapter);

        encuestasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView v = (TextView) view.findViewById(R.id.textView2);

                Toast.makeText(getApplicationContext(), "" +  v.getText(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ListaEncuestasActivity.this, Test.class);
                intent.putExtra("pregunta", v.getText() + "");
                startActivity(intent);
            }
        });

    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
