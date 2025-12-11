package com.carmen.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class ExtraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //intent para que cambie de activity desde la de informacion
        Intent intentExtra  = getIntent();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_extra);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Datos datos = new Datos();
        ArrayList<Pelicula> peliculas = datos.rellenaPeliculas();

        //actionbar
        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu, getTheme()));
        getWindow().setNavigationBarColor(getColor(R.color.rosa));

        //boton de volver, la funcion de este boton esta mas abajo en onOptionsItemSelected
        actionbar.setDisplayHomeAsUpEnabled(true);

        ImageView ivportadaextra = findViewById(R.id.ivportadaextra);
        ScrollView scrollView = findViewById(R.id.scrollView2);
        TextView tvsinopsis = findViewById(R.id.tvsinopsis);

        //Para poner los datos de la pelicula selecionada en el rvinformacion
        int pos = getIntent().getIntExtra("pos", -1);
        if (pos >= 0 && pos < peliculas.size()) {
            Pelicula pelicula = peliculas.get(pos);
            ivportadaextra.setImageResource(pelicula.getPortada());
            tvsinopsis.setText(pelicula.getSinopsis());
            actionbar.setTitle(pelicula.getTitulo());

            //abrir el idyoutube al pulsar la imagen
            ivportadaextra.setOnClickListener(view -> {
                String url = "https://www.youtube.com/watch?v=" + pelicula.getIdYoutube();
                Intent intentyoutube = new Intent(Intent.ACTION_VIEW);
                intentyoutube.setData(android.net.Uri.parse(url));
                startActivity(intentyoutube);
            });

        }
    }

    //funcion del boton de volver en el actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            getOnBackPressedDispatcher().onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}