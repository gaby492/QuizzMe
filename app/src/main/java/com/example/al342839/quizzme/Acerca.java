package com.example.al342839.quizzme;

import android.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class Acerca extends AppCompatActivity {

    ImageView imageView;
    TextView acercaTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca);
        usarToolbar();

        imageView = (ImageView) findViewById(R.id.imageView);
        acercaTextView = (TextView) findViewById(R.id.acerca);
        imageView.setImageResource(R.drawable.creadoras);

    }

    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
}
