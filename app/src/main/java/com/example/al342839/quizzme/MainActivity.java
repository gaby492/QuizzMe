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
        MDB.insertarCATEGORIA(2,"YouTubers", R.drawable.youtubers);
        MDB.insertarCATEGORIA(3,"Amor", R.drawable.love);
        MDB.insertarCATEGORIA(4,"Cantantes", R.drawable.cantantes);
        MDB.insertarCATEGORIA(5,"Comida", R.drawable.comida);
        MDB.insertarCATEGORIA(6,"Personalidad", R.drawable.personalidad);
        MDB.insertarCATEGORIA(7,"Salud", R.drawable.salud);
        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarENCUESTAS();
        MDB.insertarENCUESTA(1, "¿Que Princesa de Disney eres?", 1);
        MDB.insertarENCUESTA(2, "¿Que Youtuber eres?", 2);
        MDB.insertarENCUESTA(3, "¿Le gustas a alguien en secreto?", 3);
        MDB.insertarENCUESTA(4, "¿Que cantante seria tu mejor amigo?", 4);
        MDB.insertarENCUESTA(5, "¿Que bebida eres?", 5);
        MDB.insertarENCUESTA(6, "¿Que emocion eres?", 6);
        MDB.insertarENCUESTA(7, "¿Cual es tu tipo de cuerpo?", 7);

        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarPREGUNTAS();
        MDB.insertarPREGUNTA(1, "¿Dónde preferirías vivir?", 1);
        MDB.insertarPREGUNTA(2, "¿Cómo es tu personalidad?", 1);
        MDB.insertarPREGUNTA(3, "¿Cuál es tu mejor habilidad?", 1);
        MDB.insertarPREGUNTA(4, "¿Qué color usas mas al vestir?", 1);
        MDB.insertarPREGUNTA(5, "¿Qué mascota prefieres?", 1);
        MDB.insertarPREGUNTA(6, "¿Cémo prefieres pasar tu tiempo libre?", 1);
        MDB.insertarPREGUNTA(7, "¿Qué lugar te gusta mas?", 1);

        MDB.insertarPREGUNTA(8, "¿Cómo es tu personalidad?", 2);
        MDB.insertarPREGUNTA(9, "¿Cuál es tu Hobbie?", 2);
        MDB.insertarPREGUNTA(10, "¿Qué edad tienes?", 2);
        MDB.insertarPREGUNTA(11, "Elige una pelicula.", 2);
        MDB.insertarPREGUNTA(12, "¿Que tipo de videos te gusta ver?", 2);
        MDB.insertarPREGUNTA(13, "¿Cuál es tu poder favorito?", 2);

        MDB.insertarPREGUNTA(14, "¿Eres soltero(a)?", 3);
        MDB.insertarPREGUNTA(15, "¿Alguien te mira mucho?", 3);
        MDB.insertarPREGUNTA(16, "¿Se te dificulta expresar tus sentimientos?", 3);
        MDB.insertarPREGUNTA(17, "¿Ese alguien te sonríe?", 3);

        MDB.insertarPREGUNTA(18, "¿Cuál es tu estilo?", 4);
        MDB.insertarPREGUNTA(19, "¿Cómo te describen tus amigos?", 4);
        MDB.insertarPREGUNTA(20, "¿Cuál es tu festividad favorita?", 4);
        MDB.insertarPREGUNTA(21, "¿Cómo tratas a los demás?", 4);

        MDB.insertarPREGUNTA(22, "¿Cuál es tu color favorito?", 5);
        MDB.insertarPREGUNTA(23, "Elíge una bebida.", 5);
        MDB.insertarPREGUNTA(24, "¿Te gusta la caffeina?", 5);

        MDB.insertarPREGUNTA(25, "¿Qué te gusta hacer en tu tiempo libre?", 6);
        MDB.insertarPREGUNTA(26, "¿Qué es lo que más te asusta?", 6);
        MDB.insertarPREGUNTA(27, "¿Qué tipo de película es tu favorita?", 6);
        MDB.insertarPREGUNTA(28, "¿Cuál es tu emoción favorita?", 6);

        MDB.insertarPREGUNTA(29, "¿Cómo son tus hombros?", 7);
        MDB.insertarPREGUNTA(30, "Tu cuerpo tiende a", 7);
        MDB.insertarPREGUNTA(31, "Comparado a los demás, ¿Cómo luces?", 7);
        MDB.insertarPREGUNTA(32, "¿Cómo es tu metabolismo?", 7);
        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarRESPUESTAS();
        MDB.insertarRESPUESTA(1, "Casa en la playa", 1);
        MDB.insertarRESPUESTA(2, "Castillo", 1);
        MDB.insertarRESPUESTA(3, "Mansion", 1);
        MDB.insertarRESPUESTA(4, "Casa sencilla", 1);

        MDB.insertarRESPUESTA(5, "Risueña", 2);
        MDB.insertarRESPUESTA(6, "Alegre", 2);
        MDB.insertarRESPUESTA(7, "Trabajadora", 2);
        MDB.insertarRESPUESTA(8, "Perseverante", 2);

        MDB.insertarRESPUESTA(9, "Nadar", 3);
        MDB.insertarRESPUESTA(10, "Cocinar", 3);
        MDB.insertarRESPUESTA(11, "Leer", 3);
        MDB.insertarRESPUESTA(12, "Cocer", 3);

        MDB.insertarRESPUESTA(13, "Verde", 4);
        MDB.insertarRESPUESTA(14, "Azul", 4);
        MDB.insertarRESPUESTA(15, "Amarillo", 4);
        MDB.insertarRESPUESTA(16, "Rosa", 4);

        MDB.insertarRESPUESTA(17, "Pez", 5);
        MDB.insertarRESPUESTA(18, "Raton", 5);
        MDB.insertarRESPUESTA(19, "Perro", 5);
        MDB.insertarRESPUESTA(20, "Ave", 5);

        MDB.insertarRESPUESTA(21, "Cantando", 6);
        MDB.insertarRESPUESTA(22, "Limpiando", 6);
        MDB.insertarRESPUESTA(23, "Escribiendo", 6);
        MDB.insertarRESPUESTA(24, "Caminando", 6);

        MDB.insertarRESPUESTA(25, "La Playa", 7);
        MDB.insertarRESPUESTA(26, "El Parque", 7);
        MDB.insertarRESPUESTA(27, "Las Montañas", 7);
        MDB.insertarRESPUESTA(28, "El bosque", 7);

        MDB.insertarRESPUESTA(29, "Feliz", 8);
        MDB.insertarRESPUESTA(30, "Emocional", 8);
        MDB.insertarRESPUESTA(31, "Timido", 8);
        MDB.insertarRESPUESTA(32, "Malo", 8);

        MDB.insertarRESPUESTA(33, "Leer", 9);
        MDB.insertarRESPUESTA(34, "Youtube", 9);
        MDB.insertarRESPUESTA(35, "Dibujar", 9);
        MDB.insertarRESPUESTA(36, "Bailar", 9);

        MDB.insertarRESPUESTA(37, "1-8", 10);
        MDB.insertarRESPUESTA(38, "9-14", 10);
        MDB.insertarRESPUESTA(39, "15-18", 10);
        MDB.insertarRESPUESTA(40, "19-adelante", 10);

        MDB.insertarRESPUESTA(41, "Mean Girls", 11);
        MDB.insertarRESPUESTA(42, "Crepusculo", 11);
        MDB.insertarRESPUESTA(43, "El Rey León", 11);
        MDB.insertarRESPUESTA(16, "Harry Potter", 11);

        MDB.insertarRESPUESTA(44, "Tutoriales", 12);
        MDB.insertarRESPUESTA(45, "Hauls", 12);
        MDB.insertarRESPUESTA(46, "Blogs", 12);
        MDB.insertarRESPUESTA(47, "Videouegos", 12);

        MDB.insertarRESPUESTA(48, "Volar", 13);
        MDB.insertarRESPUESTA(49, "Leer Mentes", 13);
        MDB.insertarRESPUESTA(50, "Teletransportación", 13);
        MDB.insertarRESPUESTA(51, "Invisivilidad", 13);

        MDB.insertarRESPUESTA(48, "Volar", 14);
        MDB.insertarRESPUESTA(49, "Volar", 15);
        MDB.insertarRESPUESTA(50, "Volar", 16);
        MDB.insertarRESPUESTA(51, "Volar", 17);
        MDB.insertarRESPUESTA(52, "Volar", 18);
        MDB.insertarRESPUESTA(53, "Volar", 19);
        MDB.insertarRESPUESTA(54, "Volar", 20);
        MDB.insertarRESPUESTA(55, "Volar", 21);

        //////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarRESULTADOS();
        MDB.insertarRESULTADO(1,"Ariel","Eres linda, agradable y con un gran talento.", 1, R.drawable.ariel);
        MDB.insertarRESULTADO(2,"Cenicienta","Eres trabajadora, amable y hermosa.", 1, R.drawable.cenicienta);
        MDB.insertarRESULTADO(3,"Bella","Eres inteligente, hermosa y culta.", 1, R.drawable.bellabestia);
        MDB.insertarRESULTADO(4,"Aurora","Eres curiosa, lista, dormilona y muy hermosa.", 1, R.drawable.aurora);

        MDB.insertarRESULTADO(1,"Ariel","Eres linda, agradable y con un gran talento.", 2, R.drawable.ariel);
        MDB.insertarRESULTADO(2,"Cenicienta","Eres trabajadora, amable y hermosa.", 2, R.drawable.cenicienta);
        MDB.insertarRESULTADO(3,"Bella","Eres inteligente, hermosa y culta.", 2, R.drawable.bellabestia);
        MDB.insertarRESULTADO(4,"Aurora","Eres curiosa, lista, dormilona y muy hermosa.", 2, R.drawable.aurora);
    }

}
