package com.carmen.peliculas;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Set;
import java.util.HashSet;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class PeliculasFavoritas extends AppCompatActivity {
    ArrayList<Pelicula> peliculas;
    ArrayList<Pelicula> favoritasArray;

    private static final String PREFS_NAME = "peliculas_prefs";
    private static final String KEY_FAV_SET = "favoritas_set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_peliculas_favoritas);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        peliculas = (ArrayList<Pelicula>) getIntent().getSerializableExtra("peliculas");
        favoritasArray = (ArrayList<Pelicula>) getIntent().getSerializableExtra("favoritasArray");

        if (favoritasArray == null) {
            favoritasArray = new ArrayList<>();
        }

        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> favSet = prefs.getStringSet(KEY_FAV_SET, new HashSet<>());

        ArrayList<String> titulos = new ArrayList<>();
        for (Pelicula peli : peliculas) {
            titulos.add(peli.getTitulo() + "\n" + peli.getDirector());
        }

        ListView lv = findViewById(R.id.lv);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_checked, titulos);
        lv.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        lv.setAdapter(adapter);

        favoritasArray.clear();
        for (int i = 0; i < peliculas.size(); i++) {
            Pelicula p = peliculas.get(i);
            String key = keyFor(p);
            if (favSet.contains(key)) {
                lv.setItemChecked(i, true);
                favoritasArray.add(p);
            } else {
                lv.setItemChecked(i, false);
            }
        }

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu, getTheme()));
        actionbar.setTitle("Peliculas");
        getWindow().setNavigationBarColor(getColor(R.color.rosa));
        actionbar.setDisplayHomeAsUpEnabled(true);
    }

    private String keyFor(Pelicula p) {
        String titulo = p.getTitulo() == null ? "" : p.getTitulo().trim();
        String director = p.getDirector() == null ? "" : p.getDirector().trim();
        return titulo + "|" + director;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        ListView lv = findViewById(R.id.lv);
        if (id == android.R.id.home) {
            getOnBackPressedDispatcher().onBackPressed();
            return true;
        } else if (id == R.id.mguardar) {
            favoritasArray.clear();
            Set<String> newFavSet = new HashSet<>();

            for (int i = 0; i < peliculas.size(); i++) {
                if (lv.isItemChecked(i)) {
                    favoritasArray.add(peliculas.get(i));
                    newFavSet.add(keyFor(peliculas.get(i)));
                }
            }

            SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            editor.putStringSet(KEY_FAV_SET, new HashSet<>(newFavSet));
            editor.apply();

            Toast.makeText(this, "Favoritas actualizadas", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent();
            intent.putExtra("favoritasArray", favoritasArray);
            setResult(Activity.RESULT_OK, intent);
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.secundario, menu);
        return true;
    }
}