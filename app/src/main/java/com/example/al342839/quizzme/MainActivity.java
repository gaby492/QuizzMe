package com.example.al342839.quizzme;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_index, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.acerca) {
            Intent intent = new Intent(this, Acerca.class);
            this.startActivity(intent);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void ingresarDatosBD(MiBaseDeDatos MDB)
    {
        MDB.borrarCATEGORIAS();
        MDB.insertarCATEGORIA(1,"Personajes", R.drawable.personaje);
        MDB.insertarCATEGORIA(2,"YouTube", R.drawable.youtubers);
        MDB.insertarCATEGORIA(3,"Amor", R.drawable.love);
        MDB.insertarCATEGORIA(4,"Cantantes", R.drawable.cantantes);
        MDB.insertarCATEGORIA(5,"Comida", R.drawable.comida);
        MDB.insertarCATEGORIA(6,"Personalidad", R.drawable.personalidad);
        MDB.insertarCATEGORIA(7,"Salud", R.drawable.salud);

        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarENCUESTAS();
        MDB.insertarENCUESTA(1, "¿Qué Princesa de Disney eres?", 1);
        MDB.insertarENCUESTA(2, "¿Qué Youtuber eres?", 2);
        MDB.insertarENCUESTA(3, "¿Le gustas a alguien en secreto?", 3);
        MDB.insertarENCUESTA(4, "¿Qué cantante seria tu mejor amiga?", 4);
        MDB.insertarENCUESTA(5, "¿Qué bebida de Starbucks eres?", 5);
        MDB.insertarENCUESTA(6, "¿Qué emocion eres?", 6);
        MDB.insertarENCUESTA(7, "¿Cuál es tu tipo de cuerpo?", 7);
        MDB.insertarENCUESTA(8, "¿Cuál es tu deporte ideal?", 7);
        MDB.insertarENCUESTA(9, "¿Qué canal de You Tube crearías?", 2);
        MDB.insertarENCUESTA(10, "¿Qué villano eres?", 1);

        ////// Para notepad
        MDB.insertarENCUESTA(11, "¿Cuál es tu chico ideal?", 3);
        MDB.insertarENCUESTA(12, "¿Con qué actor te casarías?", 4 );
        MDB.insertarENCUESTA(13, "¿Qué fruta define tu personalidad?", 5);
        MDB.insertarENCUESTA(14, "¿Eres un buen líder?", 6);
        MDB.insertarENCUESTA(15, "¿Qué superhéroe eres?", 1);
        MDB.insertarENCUESTA(16, "¿A qué evento relacionado con YT irás?" , 2);


        /////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarPREGUNTAS();
        MDB.insertarPREGUNTA(1, "¿Dónde preferirías vivir?", 1);
        MDB.insertarPREGUNTA(2, "¿Cómo es tu personalidad?", 1);
        MDB.insertarPREGUNTA(3, "¿Cuál es tu mejor habilidad?", 1);
        MDB.insertarPREGUNTA(4, "¿Qué color usas mas al vestir?", 1);
        MDB.insertarPREGUNTA(5, "¿Qué mascota prefieres?", 1);
        MDB.insertarPREGUNTA(6, "¿Cómo prefieres pasar tu tiempo libre?", 1);
        MDB.insertarPREGUNTA(7, "¿Qué lugar te gusta mas?", 1);

        MDB.insertarPREGUNTA(8, "¿Cómo es tu personalidad?", 2);
        MDB.insertarPREGUNTA(9, "¿Cuál es tu Hobbie?", 2);
        MDB.insertarPREGUNTA(10, "¿Qué edad tienes?", 2);
        MDB.insertarPREGUNTA(11, "Elige una pelicula.", 2);
        MDB.insertarPREGUNTA(12, "¿Qué tipo de videos te gusta ver?", 2);
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

        MDB.insertarPREGUNTA(33, "Te gusta hacer ejercicio en:", 8);
        MDB.insertarPREGUNTA(34, "¿Qué te gusta más?",8);
        MDB.insertarPREGUNTA(35, "¿Cuánto dura tu rutina de ejercicio?", 8);

        MDB.insertarPREGUNTA(36, "¿Cuál es tu canal favorito?", 9);
        MDB.insertarPREGUNTA(37, "¿Cuántas horas dedicas a YouTube?", 9);
        MDB.insertarPREGUNTA(38, "¿A dónde te gustaría viajar?", 9);

        MDB.insertarPREGUNTA(39, "¿Dónde pasas más tiempo?", 10);
        MDB.insertarPREGUNTA(40, "¿Qué serie prefieres?", 10);

        ///////// Para notepad
        MDB.insertarPREGUNTA(41, "¿Cuál es tu color favorito?", 11);
        MDB.insertarPREGUNTA(42, "¿En qué te fijas primero?", 11);
        MDB.insertarPREGUNTA(43, "¿Cuál es tu novela favorita?", 11);

        MDB.insertarPREGUNTA(44, "¿Cuál es tu estación favorita?", 12);
        MDB.insertarPREGUNTA(45, "¿Cuál es tu serie favorita?", 12);
        MDB.insertarPREGUNTA(46, "Tu materia favorita es...", 12 );

        MDB.insertarPREGUNTA(47, "Tu color favorito es...", 13);
        MDB.insertarPREGUNTA(48, "Tu sabor favorito es...", 13);
        MDB.insertarPREGUNTA(49, "La compra de tus sueños es...", 13);

        MDB.insertarPREGUNTA(50, "¿Cuántas amigas tienes?", 14);
        MDB.insertarPREGUNTA(51, "¿Cuántas veces fuiste jefa de grupo?", 14);

        MDB.insertarPREGUNTA(52, "Si pudieras tener un superpoder sería...", 15);
        MDB.insertarPREGUNTA(53, "¿Cuál es tu color favorito?", 15);
        MDB.insertarPREGUNTA(54, "Tu serie favorita es...", 15);

        MDB.insertarPREGUNTA(55, "Mueres por visitar...", 16);
        MDB.insertarPREGUNTA(56, "¿Qué género musical prefieres?", 16);
        MDB.insertarPREGUNTA(57, "Marca de maquillaje favorita: ", 16);



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
        MDB.insertarRESPUESTA(44, "Harry Potter", 11);

        MDB.insertarRESPUESTA(45, "Tutoriales", 12);
        MDB.insertarRESPUESTA(46, "Hauls", 12);
        MDB.insertarRESPUESTA(47, "Blogs", 12);
        MDB.insertarRESPUESTA(48, "Videouegos", 12);

        MDB.insertarRESPUESTA(49, "Volar", 13);
        MDB.insertarRESPUESTA(50, "Leer Mentes", 13);
        MDB.insertarRESPUESTA(51, "Teletransportación", 13);
        MDB.insertarRESPUESTA(52, "Invisivilidad", 13);

        MDB.insertarRESPUESTA(53, "Si", 14);
        MDB.insertarRESPUESTA(54, "No", 14);
        MDB.insertarRESPUESTA(55, "Más o menos", 14);
        MDB.insertarRESPUESTA(56, "Ya casi", 14);

        MDB.insertarRESPUESTA(57, "Si", 15);
        MDB.insertarRESPUESTA(58, "No", 15);
        MDB.insertarRESPUESTA(59, "A veces", 15);
        MDB.insertarRESPUESTA(60, "No lo sé", 15);

        MDB.insertarRESPUESTA(61, "Si", 16);
        MDB.insertarRESPUESTA(62, "No", 16);
        MDB.insertarRESPUESTA(63, "A veces", 16);
        MDB.insertarRESPUESTA(64, "No lo sé", 16);

        MDB.insertarRESPUESTA(65, "Si", 17);
        MDB.insertarRESPUESTA(66, "No", 17);
        MDB.insertarRESPUESTA(67, "Todo el tiempo", 17);
        MDB.insertarRESPUESTA(68, "A veces", 17);

        MDB.insertarRESPUESTA(69, "Emo", 18);
        MDB.insertarRESPUESTA(70, "Cómodo", 18);
        MDB.insertarRESPUESTA(71, "Cute y Girly", 18);
        MDB.insertarRESPUESTA(72, "Nerd", 18);

        MDB.insertarRESPUESTA(73, "Listo", 19);
        MDB.insertarRESPUESTA(74, "Loco", 19);
        MDB.insertarRESPUESTA(75, "Aburrido", 19);
        MDB.insertarRESPUESTA(76, "Divertido", 19);

        MDB.insertarRESPUESTA(77, "Navidad", 20);
        MDB.insertarRESPUESTA(78, "San Valentín", 20);
        MDB.insertarRESPUESTA(79, "Halloween", 20);
        MDB.insertarRESPUESTA(80, "Pascua", 20);

        MDB.insertarRESPUESTA(81, "Amablemente", 21);
        MDB.insertarRESPUESTA(82, "Rudo", 21);
        MDB.insertarRESPUESTA(83, "Raro", 21);
        MDB.insertarRESPUESTA(84, "Mal", 21);

        MDB.insertarRESPUESTA(69, "Rosa", 22);
        MDB.insertarRESPUESTA(70, "Negro", 22);
        MDB.insertarRESPUESTA(71, "Azul", 22);
        MDB.insertarRESPUESTA(72, "Amarillo", 22);

        MDB.insertarRESPUESTA(73, "Té", 23);
        MDB.insertarRESPUESTA(74, "Frappe", 23);
        MDB.insertarRESPUESTA(75, "Café", 23);
        MDB.insertarRESPUESTA(76, "Jugo", 23);

        MDB.insertarRESPUESTA(77, "Si", 24);
        MDB.insertarRESPUESTA(78, "No", 24);
        MDB.insertarRESPUESTA(79, "Más o menos", 24);
        MDB.insertarRESPUESTA(80, "Que asco", 24);

        MDB.insertarRESPUESTA(69, "Salir con amigos", 25);
        MDB.insertarRESPUESTA(70, "Comer", 25);
        MDB.insertarRESPUESTA(71, "Estar solo", 25);
        MDB.insertarRESPUESTA(72, "Bailar", 25);

        MDB.insertarRESPUESTA(73, "TODO", 26);
        MDB.insertarRESPUESTA(74, "Ser Feliz", 26);
        MDB.insertarRESPUESTA(75, "NADA!", 26);
        MDB.insertarRESPUESTA(76, "La comida, UGH", 26);

        MDB.insertarRESPUESTA(77, "De Horror", 27);
        MDB.insertarRESPUESTA(78, "De Romance", 27);
        MDB.insertarRESPUESTA(79, "De Comedia", 27);
        MDB.insertarRESPUESTA(80, "De Tristeza", 27);

        MDB.insertarRESPUESTA(77, "Enojo", 28);
        MDB.insertarRESPUESTA(78, "Alegria", 28);
        MDB.insertarRESPUESTA(79, "Tristeza", 28);
        MDB.insertarRESPUESTA(80, "Miedo", 28);

        MDB.insertarRESPUESTA(69, "Anchos", 29);
        MDB.insertarRESPUESTA(70, "Angostos", 29);
        MDB.insertarRESPUESTA(71, "Normales", 29);
        MDB.insertarRESPUESTA(72, "Caidos", 29);

        MDB.insertarRESPUESTA(73, "Estar delgado", 30);
        MDB.insertarRESPUESTA(74, "Tiene grasa extra", 30);
        MDB.insertarRESPUESTA(75, "Estar musculoso", 30);
        MDB.insertarRESPUESTA(76, "Estar aguado", 30);

        MDB.insertarRESPUESTA(77, "Redonda", 31);
        MDB.insertarRESPUESTA(78, "Alta", 31);
        MDB.insertarRESPUESTA(79, "Delgada", 31);
        MDB.insertarRESPUESTA(80, "Flaca", 31);

        MDB.insertarRESPUESTA(77, "Engordo rápido", 32);
        MDB.insertarRESPUESTA(78, "Pierdo peso rápido", 32);
        MDB.insertarRESPUESTA(79, "Me mantengo delgada", 32);
        MDB.insertarRESPUESTA(80, "Batallo para engordar", 32);

        MDB.insertarRESPUESTA(81, "El gimnasio", 33);
        MDB.insertarRESPUESTA(82, "En el patio", 33);
        MDB.insertarRESPUESTA(83, "En la playa", 33);
        MDB.insertarRESPUESTA(84, "En el bosque", 33);

        MDB.insertarRESPUESTA(85, "Caminar en el parque", 34);
        MDB.insertarRESPUESTA(86, "Nadar en la playa", 34);
        MDB.insertarRESPUESTA(87, "Pasear al perro", 34);
        MDB.insertarRESPUESTA(88,  "Ir al gimnasio", 34);

        MDB.insertarRESPUESTA(89, "10 minutos", 35);
        MDB.insertarRESPUESTA(90, "15 minutos", 35);
        MDB.insertarRESPUESTA(91, "20 minutos", 35);
        MDB.insertarRESPUESTA(92, "30 minutos", 35);

        MDB.insertarRESPUESTA(93, "Yuya", 36);
        MDB.insertarRESPUESTA(94, "MarisolPink", 36 );
        MDB.insertarRESPUESTA(95, "Zoella", 36);
        MDB.insertarRESPUESTA(96, "PewDiePie", 36);

        MDB.insertarRESPUESTA(97, "Media hora", 37);
        MDB.insertarRESPUESTA(98, "1 hora", 37);
        MDB.insertarRESPUESTA(99, "Más de 2 hrs", 37);
        MDB.insertarRESPUESTA(100, "Todo el día", 37);

        MDB.insertarRESPUESTA(101, "México", 38);
        MDB.insertarRESPUESTA(102, "USA", 38);
        MDB.insertarRESPUESTA(103, "Inglaterra", 38);
        MDB.insertarRESPUESTA(104, "Japón", 38);

        MDB.insertarRESPUESTA(105, "En la biblioteca", 39);
        MDB.insertarRESPUESTA(106, "En tu cuarto", 39);
        MDB.insertarRESPUESTA(107, "En el parque", 39);
        MDB.insertarRESPUESTA(108, "En la playa", 39);

        MDB.insertarRESPUESTA(109, "Scream Queens", 40);
        MDB.insertarRESPUESTA(110, "Flash", 40);
        MDB.insertarRESPUESTA(111, "Friends", 40);
        MDB.insertarRESPUESTA(112, "Game of Thrones", 40);

        ///// Para notepad
        MDB.insertarRESPUESTA(113, "Rojo", 41);
        MDB.insertarRESPUESTA(114, "Azul", 41);
        MDB.insertarRESPUESTA(115, "Verde", 41);
        MDB.insertarRESPUESTA(116, "Rosa", 41);

        MDB.insertarRESPUESTA(117, "Altura", 42);
        MDB.insertarRESPUESTA(118, "IQ", 42);
        MDB.insertarRESPUESTA(119, "Ojos", 42);
        MDB.insertarRESPUESTA(120, "Outfit", 42);

        MDB.insertarRESPUESTA(121, "Los miserables", 43);
        MDB.insertarRESPUESTA(122, "Orgullo y prejuicio", 43);
        MDB.insertarRESPUESTA(123, "Romeo y Julieta", 43);
        MDB.insertarRESPUESTA(124, "Crepúsculo", 43);

        MDB.insertarRESPUESTA(125, "Primavera", 44);
        MDB.insertarRESPUESTA(126, "Verano", 44);
        MDB.insertarRESPUESTA(127, "Otoño", 44);
        MDB.insertarRESPUESTA(128, "Invierno", 44);

        MDB.insertarRESPUESTA(129, "Smallville", 45);
        MDB.insertarRESPUESTA(130, "Grey's Anathomy", 45);
        MDB.insertarRESPUESTA(131, "The Big Bang Theory", 45);
        MDB.insertarRESPUESTA(132, "ICarly", 45);

        MDB.insertarRESPUESTA(133, "Español", 46);
        MDB.insertarRESPUESTA(134, "Matemáticas", 46);
        MDB.insertarRESPUESTA(135, "Química", 46);
        MDB.insertarRESPUESTA(136, "Computación", 46);

        MDB.insertarRESPUESTA(137, "Verde", 47);
        MDB.insertarRESPUESTA(138, "Azul", 47);
        MDB.insertarRESPUESTA(139, "Rojo", 47);
        MDB.insertarRESPUESTA(140, "Anaranjado", 47);

        MDB.insertarRESPUESTA(141, "Dulce", 48);
        MDB.insertarRESPUESTA(142, "Salado", 48);
        MDB.insertarRESPUESTA(143, "Picosito", 48);
        MDB.insertarRESPUESTA(144, "Agridulce", 48);

        MDB.insertarRESPUESTA(145, "Un reloj", 49);
        MDB.insertarRESPUESTA(146, "Una casa", 49);
        MDB.insertarRESPUESTA(147, "Un auto", 49);
        MDB.insertarRESPUESTA(148, "La PS4", 49);

        MDB.insertarRESPUESTA(149, "ninguna", 50);
        MDB.insertarRESPUESTA(150, "1", 50);
        MDB.insertarRESPUESTA(151, "2 ó 3", 50);
        MDB.insertarRESPUESTA(152, "4 o más", 50);

        MDB.insertarRESPUESTA(153, "ninguna", 51);
        MDB.insertarRESPUESTA(154, "1 vez", 51);
        MDB.insertarRESPUESTA(155, "2 veces", 51);
        MDB.insertarRESPUESTA(156, "3 o más", 51);

        MDB.insertarRESPUESTA(157, "Volar", 52);
        MDB.insertarRESPUESTA(158, "Súper velocidad", 52);
        MDB.insertarRESPUESTA(159, "Telepatía", 52);
        MDB.insertarRESPUESTA(160, "Súper fuerza", 52);

        MDB.insertarRESPUESTA(161, "Rojo", 53);
        MDB.insertarRESPUESTA(162, "Azul", 53);
        MDB.insertarRESPUESTA(163, "Verde", 53);
        MDB.insertarRESPUESTA(164, "Negro", 53);

        MDB.insertarRESPUESTA(165, "Scream Queens", 54);
        MDB.insertarRESPUESTA(166, "Flash", 54);
        MDB.insertarRESPUESTA(167, "The Big Bang Theory", 54);
        MDB.insertarRESPUESTA(168, "Game of Thrones", 54);

        MDB.insertarRESPUESTA(169, "Los Angeles", 55);
        MDB.insertarRESPUESTA(170, "Londres", 55);
        MDB.insertarRESPUESTA(171, "Nueva York", 55);
        MDB.insertarRESPUESTA(172, "México", 55);

        MDB.insertarRESPUESTA(173, "Rock", 56);
        MDB.insertarRESPUESTA(174, "Dubstep", 56);
        MDB.insertarRESPUESTA(175, "Pop", 56);
        MDB.insertarRESPUESTA(176, "Ninguno", 56);

        MDB.insertarRESPUESTA(177, "NYX", 57);
        MDB.insertarRESPUESTA(178, "Too Faced", 57);
        MDB.insertarRESPUESTA(179, "Ninguna", 57);
        MDB.insertarRESPUESTA(180, "Maybelline", 57);



        //////////////////////////////////////////////////////////////////////////////////////////////
        MDB.borrarRESULTADOS();
        MDB.insertarRESULTADO(1,"Ariel","Eres linda, agradable y con un gran talento.", 1, R.drawable.ariel);
        MDB.insertarRESULTADO(2,"Cenicienta","Eres trabajadora, amable y hermosa.", 1, R.drawable.cenicienta);
        MDB.insertarRESULTADO(3,"Bella","Eres inteligente, hermosa y culta.", 1, R.drawable.bellabestia);
        MDB.insertarRESULTADO(4,"Aurora","Eres curiosa, lista, dormilona y muy hermosa.", 1, R.drawable.aurora);

        MDB.insertarRESULTADO(1,"Wismichu","Dicen que soy un troll pero yo solo busco reírme de la vida. Mi canal, mis normas. Espero divertirte con mis locuras.", 2, R.drawable.wismichu);
        MDB.insertarRESULTADO(2,"Yuya","Hola guapuritas!! Siempre hay que sonreirle a la vida, les mando muchos besitos chiquitos chiquitos y muchas letritas de amor!!", 2, R.drawable.yuya);
        MDB.insertarRESULTADO(3,"Rubius","PUES BIEN. Mi canal es de Gayplays de Minecr... Wait. No. Mi canal es de Gayplays en general, pero nunca juego a nada predefinido.", 2, R.drawable.rubius);
        MDB.insertarRESULTADO(4,"Remlife","Me gusta subir tutoriales de maquillaje de asesoramiento de moda para proyectos de DIY! Youtube es mi gran pasión!", 2, R.drawable.remlife);

        MDB.insertarRESULTADO(1,"Si, a tu vecino","Te espia sin que te des cuenta y te observa todo el tiempo. CUIDADO.", 3, R.drawable.vecino);
        MDB.insertarRESULTADO(2,"Si, al chico que te gusta","Seguramente ya lo sabías, para que te haces -.-", 3, R.drawable.pareja);
        MDB.insertarRESULTADO(3,"No, a nadie :(","Seguramente no falta mucho para que le gustes a alguien. Don't worry!", 3, R.drawable.alone);
        MDB.insertarRESULTADO(4,"Talvez","Necesito más respuestas para estar seguro de que le gustes a alguien.", 3, R.drawable.talvez);

        MDB.insertarRESULTADO(1,"Taylor Swift","Eres linda y muy enamoradisa, seguramente se caerían super bien!", 4, R.drawable.taylor);
        MDB.insertarRESULTADO(2,"Selena Gómez","Te encanta la fiesta y la diversion, serían imparables juntas.", 4, R.drawable.selena);
        MDB.insertarRESULTADO(3,"Ariana Grande","Eres una diva, lista y talentosa, seguramente tendrían alguna serie juntas.", 4, R.drawable.ariana);
        MDB.insertarRESULTADO(4,"Sia","Eres misteriosa y caes en depresión con facilidad. Hasta se cortarían las venas juntas.", 4, R.drawable.sia);

        MDB.insertarRESULTADO(1,"Espresso Americano","Eres única y destacas por tu sencillez, tu persoanlidad lo es todo.", 5, R.drawable.espressoamericano);
        MDB.insertarRESULTADO(2,"Green Tea Frappuccino","Sin duda te gusta trabajar duro para conseguir lo que quieres. No te gusta conformarte.", 5, R.drawable.greenteafrapp);
        MDB.insertarRESULTADO(3,"Caramel Frappuccino","Eres simpática, divertida y te gusta jugar, pero necesitas empezar a concentrarte en tu futuro .", 5, R.drawable.caramelfrappuccino);
        MDB.insertarRESULTADO(4,"Caramel Macciato","Te encuentras en una etapa donde existe balance en cada aspecto de tu vida. Sigue por ese camino y disfruta al máximo.", 5, R.drawable.caramelmacciato);

        MDB.insertarRESULTADO(1,"Felicidad","Sabes valorar lo que tienes y encontrar la alegría en los pequeños detalles", 6, R.drawable.felicidad);
        MDB.insertarRESULTADO(2,"Tristeza","Vives en el pasado y no te das cuenta del mundo maravilloso que te rodea. Sal a dar un paseo y refresca tu mente", 6, R.drawable.tristeza);
        MDB.insertarRESULTADO(3,"Ira","Te dejas llevar por tus emociones fácilmente. Deja de discutir por todo!!!", 6, R.drawable.ira);
        MDB.insertarRESULTADO(4,"Miedo","Te preocupas demasiado por todo y no estás dispuesta a conocer nada nuevo. Sal de tu zona de confort!!!.", 6, R.drawable.miedo);

        MDB.insertarRESULTADO(1,"Cuerpo de diamante","Tu cuerpo tiende a acumular grasa fácilmente. Necesitas cuidar mucho tu alimentación e ir al gym", 7, R.drawable.diamante);
        MDB.insertarRESULTADO(2,"Cuerpo recto","No tienes muchas curvas pero nunca tendrás que preocuparte por la obesidad LOL.", 7, R.drawable.cuerporecto);
        MDB.insertarRESULTADO(3,"Cuerpo de pera","Tienes una cintura muy fina, pero  también almacenas un poco de grasa en tus piernas, por eso es fácil que bajes de peso, pero es difícil que llegues a tu peso ideal.", 7, R.drawable.cuerpopera);
        MDB.insertarRESULTADO(4,"Cuerpo esbelto","Eres el balance perfecto entre las curvas y la delgadez. Tienes el cuerpo perfecto. Felicidades.", 7, R.drawable.cuerpoesbelto);

        MDB.insertarRESULTADO(1,"Baloncesto","Eres muy inquieta y competitiva. Además sientes una gran pasión por el deporte", 8, R.drawable.baloncesto);
        MDB.insertarRESULTADO(2,"Natación","Definitivamente te encantan los deportes demandantes y estar en contacto con el agua", 8, R.drawable.natacion);
        MDB.insertarRESULTADO(3,"Tennis","Te encanta estar en movimiento. Amas los deporte y el glamour", 8, R.drawable.tennis);
        MDB.insertarRESULTADO(4,"Rugby","Te encanta la adrenalina. No puedes estar quieta nni un segundo, definitivamente debes optar por un deporte rudo, argg", 8, R.drawable.rugby);

        MDB.insertarRESULTADO(1,"DIY's", "Eres súper creativa. Tu imaginación no tiene límites", 9, R.drawable.diy);
        MDB.insertarRESULTADO(2,"Cocina", "Te encanta pasar el día en la cocina. Eres feliz mientras tengas los ingredientes para hornear tus pasteles", 9, R.drawable.cocina);
        MDB.insertarRESULTADO(3,"Moda", "Sientes una gran pasión por la moda y los colores. Siempre estás relucente, además eres súper responsable y comprometida en todo lo que te propones.", 9, R.drawable.fashion);
        MDB.insertarRESULTADO(4,"Gameplays", "Eres indestructible cuando se trata de videojuegos!!, definitivamente el mundo necesita conocer tus estrategias!", 9, R.drawable.gameplays);

        MDB.insertarRESULTADO(1,"Voldemort", "Siempre quieres ser el centro de atención. Tu grupo de amigos te valora mucho", 10, R.drawable.voldemort);
        MDB.insertarRESULTADO(2,"Joker", "Eres original y talentosa. Qué bueno que los demás se dan cuenta y quieren estar contigo", 10, R.drawable.joker);
        MDB.insertarRESULTADO(3,"Maléfica", "A veces dices comentarios sarcásticos y muy hirientes, CIELOS, deberías cuidar más lo que dices", 10, R.drawable.malefica);
        MDB.insertarRESULTADO(4,"Cruella Deville", "Algunas veces no te das cuenta... pero puedes llegar a ser un poco mandona :(", 10, R.drawable.cruella);

        ///////Para notepad
        MDB.insertarRESULTADO(1,"Chico Tierno", "Sin duda te encantan los chicos con un buen físico y que además sean súper detallistas", 11, R.drawable.chicoalto);
        MDB.insertarRESULTADO(2,"Chico Intelecual", "Tu chico ideal debe ser súper inteligente, como tú! Siempre tendrían tema de conversación y nunca se aburrirían! Genial!", 11, R.drawable.chicointelectual);
        MDB.insertarRESULTADO(3,"Chico Romántico", "Eres súper fanática del romanticismo, por eso tu chico ideal debe pensar todos los días cómo conquistarte <3",11, R.drawable.chicoromantico);
        MDB.insertarRESULTADO(4,"Chico Hipster", "Como salido de una cuenta de Tumblr! Tu chico ideal sería súper buena onda y siempre  vestiría súper moderno! ", 11, R.drawable.chicohipster);

        MDB.insertarRESULTADO(1,"Josh Peck", "Eres un alma joven y fresca, sin duda quedarías perfecta con alguien que ama reír ", 12, R.drawable.josh);
        MDB.insertarRESULTADO(2, "Ashton Kutcher", "Eres madura y conservadora. Tu lugar favorito es tu hogar. Sin duda harías una excelente pareja con Ashton", 12, R.drawable.ashton);
        MDB.insertarRESULTADO(3,"Nat Wolff", " Te quedaste en la etapa de la High School. Tu vida es toda una aventura! Nat es para ti!", 12, R.drawable.nat);
        MDB.insertarRESULTADO(4,"Jesse Eisenberg", "La tecnología es súper importante para ti, además eres súper jovial como Jesse. Se verían bien juntos", 12, R.drawable.jesse);

        MDB.insertarRESULTADO(1,"Una pera", "Siempre luces radiante. Te encanta la naturaleza y estar en armonía con el mundo que te rodea", 13, R.drawable.pera);
        MDB.insertarRESULTADO(2,"Una mora", "No cabe duda de que tienes altas y bajas, y eso se refleja en tu humor. Aunque siempre intentas dar la mejor versión de ti ", 13, R.drawable.mora);
        MDB.insertarRESULTADO(3,"Una sandía", "Eres súper alegre y optimista. Siempre estás llena de buena vibra", 13, R.drawable.sandia);
        MDB.insertarRESULTADO(4,"Naranja", "Eres simpática y energética. No le temes a nada y enfrentas cualquier obstáculo positivamente!!!", 13, R.drawable.naranja);

        MDB.insertarRESULTADO(1,"0% Líder", "Desafortunadamente no tienes el don del liderazgo, pero no te preocupes, tienes muchas otras cualidades!!", 14, R.drawable.cerolider);
        MDB.insertarRESULTADO(2,"Puedes mejorar", "Al parecer necesitas trabajar mucho más si quieres llegar a ser un buen líder!!!", 14, R.drawable.lider);
        MDB.insertarRESULTADO(3,"Casi una Líder", "Estás a sólo un paso de poder decir que eres una líder. Vas por un buen camino!!", 14, R.drawable.casilider);
        MDB.insertarRESULTADO(4,"Gran Líder", "Puedes sentirte afortunada de saber que a donde quiera que vayas sobresales por tu liderazgo", 14, R.drawable.granlider);

        MDB.insertarRESULTADO(1,"Spiderman", "Te encanta andar libre por el mundo. NO tienes ninguna atadura!!", 15, R.drawable.spiderman);
        MDB.insertarRESULTADO(2,"Flash", "Vives al límite y siempre te falta tiempo. Debes YOLEAR menos!!!", 15, R.drawable.flash);
        MDB.insertarRESULTADO(3,"Linterna Verde", "Eres muy lista y siempre te gusta estar pendiente de los demás, a veces hasta quisieras leer sus mentes!", 15, R.drawable.linterna);
        MDB.insertarRESULTADO(4,"Batman", "Tienes un estilo muy peculiar, puede decirse que eres bastante misteriosa. Además eres súper inteligente", 15, R.drawable.batman);

        MDB.insertarRESULTADO(1,"ULTRA", "Disfrutas viajar con tus amigos mientras escuchas música súper fuerte!", 16, R.drawable.ultra);
        MDB.insertarRESULTADO(2,"BeautyCon", "Sientes una gran pasión por el maquillaje y tuvida gira en torno a la belleza. Nos vemos en LA!!!", 16, R.drawable.beautycon);
        MDB.insertarRESULTADO(3,"Tomorrowland", "Disfrutas los recorridos largos y las aventuras!! No importa dónde sea tu siempre encuentras la diversión!!!", 16, R.drawable.tomorrowland);
        MDB.insertarRESULTADO(4,"Club Media Fest", " Tienes un gran interés por todo lo latino!! El Club Media Fest te estará esperando!!!!", 16, R.drawable.clubmediafest);

    }
}
