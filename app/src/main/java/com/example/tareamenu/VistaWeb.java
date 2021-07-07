package com.example.tareamenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

public class VistaWeb extends AppCompatActivity {

    WebView wv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vista_web);

        wv = findViewById(R.id.Webartista);

        Bundle bundle = getIntent().getExtras();
        String direccion = bundle.getString("direccionWeb");
        wv.loadUrl(direccion);

        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
}