package com.example.tareamenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Artista MJackson = new Artista("Titulo: Thriller \nAutor: Michael Jackson \nDisco: Thriller \nAño: 1982","https://es.wikipedia.org/wiki/Michael_Jackson%27s_Thriller");
    Artista Quenn = new Artista("Titulo: Bohemian Rhapsody \nAutor: Queen \nDisco: A Night at the Opera \nAño: 1975","https://es.wikipedia.org/wiki/Bohemian_Rhapsody");
    Artista Acdc = new Artista("Titulo: Money talks \nAutor: Acdc \nDisco: The Razors Edge \nAño: 1990","https://es.wikipedia.org/wiki/Moneytalks");
    Artista Elvis = new Artista("Titulo: For the good times \nAutor: Elvys Presley \nDisco: As Recorded at Madison Square Garden \nAño: 1972","https://en.wikipedia.org/wiki/For_the_Good_Times_(song)");
    String descripcionArtista;
    String webArtista;
    WebView wv;

    ImageView michaelJacksonimagen;
    ImageView queenimagen;
    ImageView acdcimagen;
    ImageView elvisimagen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        michaelJacksonimagen = findViewById(R.id.michaelJackson);
        queenimagen = findViewById(R.id.Queen);
        acdcimagen = findViewById(R.id.ACDC);
        elvisimagen = findViewById(R.id.Elvis);
        wv = findViewById(R.id.idWeb);

        registerForContextMenu(queenimagen);
        registerForContextMenu(elvisimagen);
        registerForContextMenu(acdcimagen);
        registerForContextMenu(michaelJacksonimagen);

        michaelJacksonimagen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                descripcionArtista = MJackson.GetDescripcion();
                webArtista = MJackson.GetWeb();
                return false;
            }
        });

        queenimagen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                descripcionArtista = Quenn.GetDescripcion();
                webArtista = Quenn.GetWeb();
                return false;
            }
        });

        elvisimagen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                descripcionArtista = Elvis.GetDescripcion();
                webArtista = Elvis.GetWeb();
                return false;
            }
        });

        acdcimagen.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                descripcionArtista = Acdc.GetDescripcion();
                webArtista = Acdc.GetWeb();
                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu (ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_contextual,menu);
    }

    @Override
    public boolean onContextItemSelected (MenuItem menuItem){
        menuItem.getTitle();
        switch (menuItem.getItemId()){
            case R.id.idInformacion:
                Toast.makeText(this,descripcionArtista,Toast.LENGTH_SHORT).show();
                break;
            case R.id.idWeb:
                Intent intent = new Intent(getApplicationContext(),VistaWeb.class);
                intent.putExtra("direccionWeb",webArtista);
                startActivity(intent);
                break;

        }

        return true;
    }
}