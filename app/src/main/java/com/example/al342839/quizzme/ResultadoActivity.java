package com.example.al342839.quizzme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    TextView descripcionTextView;
    TextView resultadoTextView;
    TextView encuestaTextView;
    ImageView resultadoImageView;
    MiBaseDeDatos MBD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        usarToolbar();

        descripcionTextView = (TextView)findViewById(R.id.descripcionTextView);
        resultadoImageView = (ImageView) findViewById(R.id.resultadoImageView);
        encuestaTextView = (TextView) findViewById(R.id.encuestaTextView);
        resultadoTextView = (TextView) findViewById(R.id.resultadoTextView);
        Intent i = getIntent();
        int id_enc = Integer.parseInt(i.getStringExtra("id_enc"));
        int mayoria = Integer.parseInt(i.getStringExtra("mayoria")) + 1;

         MBD = new MiBaseDeDatos(getApplicationContext());


        Resultado resultado = MBD.recuperarRESULTADO(mayoria,id_enc);
        Encuesta encuesta = MBD.recuperarENCUESTA(id_enc);

        resultadoImageView.setImageResource(resultado.getImagen());
        encuestaTextView.setText(encuesta.getEncuesta());
        descripcionTextView.setText(resultado.getDescripcion());
        resultadoTextView.setText(resultado.getResultado());

    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
