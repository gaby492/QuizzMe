package com.example.al342839.quizzme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import android.util.Log;

public class Test extends AppCompatActivity {
    List<Pregunta> preguntas;
    int[] conteo = {0,0,0,0};
    int numPre = 0;
    Pregunta PreActual;
    TextView pregunta;
    Button[] opciones;
    MiBaseDeDatos MBD;
    int id_enc;
    int k;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        MBD = new MiBaseDeDatos(getApplicationContext());
        Intent i = getIntent();
        id_enc = Integer.parseInt(i.getStringExtra("id_enc")) + 1;

        preguntas = MBD.recuperarPREGUNTAS_DE_ENC(id_enc);
        PreActual = preguntas.get(numPre);

        pregunta = (TextView) findViewById(R.id.pregunta);

        opciones = new Button[4];
        opciones[0] = (Button) findViewById(R.id.opt1);
        opciones[1] = (Button) findViewById(R.id.opt2);
        opciones[2] = (Button) findViewById(R.id.opt3);
        opciones[3] = (Button) findViewById(R.id.opt4);

        setQuestionView();
        opciones[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numPre < preguntas.size()){
                    conteo[0] = conteo[0] + 1;
                    Log.i("conteo"+0,conteo[0]+"");
                    PreActual = preguntas.get(numPre);
                    setQuestionView();
                }else{
                    int indiceMax = getMaximo(conteo);
                    Intent nombreIntent = new Intent(Test.this,ResultadoActivity.class);
                    nombreIntent.putExtra("mayoria",indiceMax+"");
                    nombreIntent.putExtra("id_enc",id_enc+ "");
                    startActivity(nombreIntent);
                    finish();
                }
            }
        });
        opciones[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numPre < preguntas.size()){
                    conteo[1] = conteo[1] + 1;
                    Log.i("conteo"+1,conteo[1]+"");
                    PreActual = preguntas.get(numPre);
                    setQuestionView();
                }else{
                    int indiceMax = getMaximo(conteo);
                    Intent nombreIntent = new Intent(Test.this,ResultadoActivity.class);
                    nombreIntent.putExtra("mayoria",indiceMax+"");
                    nombreIntent.putExtra("id_enc",id_enc+ "");
                    startActivity(nombreIntent);
                    finish();
                }
            }
        });
        opciones[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numPre < preguntas.size()){
                    conteo[2] = conteo[2] + 1;
                    Log.i("conteo"+2,conteo[2]+"");
                    PreActual = preguntas.get(numPre);
                    setQuestionView();
                }else{
                    int indiceMax = getMaximo(conteo);
                    Intent nombreIntent = new Intent(Test.this,ResultadoActivity.class);
                    nombreIntent.putExtra("mayoria",indiceMax+"");
                    nombreIntent.putExtra("id_enc",id_enc+ "");
                    startActivity(nombreIntent);
                    finish();
                }
            }
        });
        opciones[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(numPre < preguntas.size()){
                    conteo[3] = conteo[3] + 1;
                    Log.i("conteo"+3,conteo[3]+"");
                    PreActual = preguntas.get(numPre);
                    setQuestionView();
                }else{
                    int indiceMax = getMaximo(conteo);
                    Intent nombreIntent = new Intent(Test.this,ResultadoActivity.class);
                    nombreIntent.putExtra("mayoria",indiceMax+"");
                    nombreIntent.putExtra("id_enc",id_enc+ "");
                    startActivity(nombreIntent);
                    finish();
                }
            }
        });


    }

    private void setQuestionView(){
        pregunta.setText(PreActual.getPregunta());

        List<Respuesta> respuestas = MBD.recuperarRESPUESTAS_DE_PRE(PreActual.getId_pre());
        for(int i=0;i<respuestas.size();i++){
            opciones[i].setText(respuestas.get(i).getRespuesta());
        }
        numPre++;
    }

    private int getMaximo(int[] conteo)
    {
        int maximo = conteo[0];
        int m = 0;
        for(int j=0;j<conteo.length;j++)
        {
            if(conteo[j] > maximo)
            {
                maximo = conteo[j];
                m = j;
            }
        }
        return m;
    }
}