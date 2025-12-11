package com.carmen.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import android.content.SharedPreferences;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public class InformacionPeliculas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //intent para que cambie de activity desde la primaria
        Intent intentInformacion  = getIntent();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_informacion_peliculas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Informacion del array para el rv
        ArrayList<Pelicula> peliculas = (ArrayList<Pelicula>) getIntent().getSerializableExtra("peliculas");


        SharedPreferences prefs = getSharedPreferences("peliculas_prefs", MODE_PRIVATE);
        Set<String> favSet = prefs.getStringSet("favoritas_set", new HashSet<>());

        //declarar el rv
        RecyclerView rvinformacion = findViewById(R.id.rvinformacion);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 1);
        rvinformacion.setLayoutManager(gridLayoutManager);
        AdaptadorInformacion adaptadorInformacion = new AdaptadorInformacion(peliculas, favSet);
        rvinformacion.setAdapter(adaptadorInformacion);

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu, getTheme()));
        actionbar.setTitle("Peliculas");
        getWindow().setNavigationBarColor(getColor(R.color.rosa));

        //boton de volver, la funcion de este boton esta mas abajo en onOptionsItemSelected
        actionbar.setDisplayHomeAsUpEnabled(true);

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