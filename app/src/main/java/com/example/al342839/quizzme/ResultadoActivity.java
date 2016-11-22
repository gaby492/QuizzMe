package com.example.al342839.quizzme;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

public class ResultadoActivity extends AppCompatActivity {
    TextView pruebaTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        usarToolbar();

        pruebaTextView = (TextView)findViewById(R.id.pruebaTextView);
        Intent i = getIntent();
        int id_enc = Integer.parseInt(i.getStringExtra("id_enc"));
        int mayoria = Integer.parseInt(i.getStringExtra("mayoria")) + 1;
        pruebaTextView.setText("ID_ENC:" + id_enc + "   mayoria: "+ mayoria);

    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
