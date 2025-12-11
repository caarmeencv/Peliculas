package com.carmen.peliculas;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import java.util.Set;
import java.util.HashSet;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pelicula> peliculas = new ArrayList<>();
    ArrayList<Pelicula> favoritasArray = new ArrayList<>();
    GridLayoutManager gridLayoutManager;
    boolean vista = false;
    ActionBar actionbar;
    boolean mostrandoFavoritas = false;

    AdaptadorPelicula adaptadorPelicula;

    private static final String PREFS_NAME = "peliculas_prefs";
    private static final String KEY_FAV_SET = "favoritas_set";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Datos datos = new Datos();
        peliculas = datos.rellenaPeliculas();

        //Recuperar guardados desde PeliculasFavoritas
        cargarFavoritasDesdePrefs();

        //RecyclerView
        RecyclerView rv = findViewById(R.id.rv);
        gridLayoutManager = new GridLayoutManager(this, 1);
        rv.setLayoutManager(gridLayoutManager);

        adaptadorPelicula = new AdaptadorPelicula(peliculas);
        rv.setAdapter(adaptadorPelicula);

        actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu, getTheme()));
        actionbar.setSubtitle(String.valueOf(peliculas.size()));


        // Navigation bar
        getWindow().setNavigationBarColor(getColor(R.color.rosa));

        FloatingActionButton floatingActionButton = findViewById(R.id.fazoom);
        floatingActionButton.setOnClickListener(v -> {
            if (actionbar.isShowing()) {
                actionbar.hide();
            }
            else {
                actionbar.show();
            }
        });
    }

    private ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == RESULT_OK && result.getData() != null) {

                    ArrayList<Pelicula> favoritasRecibidas =
                            (ArrayList<Pelicula>) result.getData().getSerializableExtra("favoritasArray");

                    if (favoritasRecibidas != null) {
                        favoritasArray = favoritasRecibidas;

                        guardarFavoritasEnPrefs();
                    }
                }
            }
    );

    private void cargarFavoritasDesdePrefs() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> favSet = prefs.getStringSet(KEY_FAV_SET, new HashSet<>());

        favoritasArray.clear();

        if (peliculas != null) {
            for (Pelicula p : peliculas) {
                if (p == null) continue;
                String key = keyFor(p);
                if (favSet.contains(key)) favoritasArray.add(p);
            }
        }
    }

    private void guardarFavoritasEnPrefs() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        Set<String> favSet = new HashSet<>();
        for (Pelicula p : favoritasArray) {
            if (p == null) continue;
            favSet.add(keyFor(p));
        }

        editor.putStringSet(KEY_FAV_SET, favSet);
        editor.apply();
    }

    private String keyFor(Pelicula p) {
        String titulo = p.getTitulo() == null ? "" : p.getTitulo().trim();
        String director = p.getDirector() == null ? "" : p.getDirector().trim();
        return titulo + "|" + director;
    }

    private ArrayList<Pelicula> obtenerPeliculasFavoritas() {
        SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        Set<String> favSet = prefs.getStringSet(KEY_FAV_SET, new HashSet<>());

        ArrayList<Pelicula> favoritas = new ArrayList<>();
        for (Pelicula p : peliculas) {
            if (p == null) continue;
            String key = keyFor(p);
            if (favSet.contains(key)) {
                favoritas.add(p);
            }
        }
        return favoritas;
    }

    private ActivityResultLauncher<Intent> nuevaPeliLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if(result.getResultCode() == RESULT_OK && result.getData() != null){
                    Pelicula nuevaPeli = (Pelicula) result.getData().getSerializableExtra("nuevaPelicula");
                    if(nuevaPeli != null){
                        peliculas.add(nuevaPeli);          // Añadimos a la lista
                        adaptadorPelicula.notifyItemInserted(peliculas.size() - 1); // Notificamos al adaptador
                        actionbar.setSubtitle(String.valueOf(peliculas.size()));   // Actualizamos subtítulo
                    }
                }
            }
    );



    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        int id = item.getItemId();

        if (id == R.id.minformacion) {

            Intent intentInformacion = new Intent(MainActivity.this, InformacionPeliculas.class);
            intentInformacion.putExtra("peliculas", peliculas); // 👈 enviamos TODAS las películas
            startActivity(intentInformacion);
            return true;

        } else if(id == R.id.manadir){

            Intent intentNuevaPeli = new Intent(MainActivity.this, NuevaPelicula.class);
            nuevaPeliLauncher.launch(intentNuevaPeli); // Lanzamos con el launcher
            return true;

        } else if (id == R.id.mfavoritos) {

            Intent intentFavoritos = new Intent(this, PeliculasFavoritas.class);
            intentFavoritos.putExtra("peliculas", peliculas);
            intentFavoritos.putExtra("favoritasArray", favoritasArray);
            launcher.launch(intentFavoritos);
            return true;

        } else if(id == R.id.mvista){

            vista = !vista;
            gridLayoutManager.setSpanCount(vista ? 2 : 1);
            gridLayoutManager.requestLayout();

            if(vista) item.setIcon(R.drawable.ic_two);
            else item.setIcon(R.drawable.ic_one);

            return true;
        } else if(id == R.id.mverfav){
            ArrayList<Pelicula> listaAMostrar;

            if (!mostrandoFavoritas) {
                listaAMostrar = obtenerPeliculasFavoritas();
                mostrandoFavoritas = true;
                item.setTitle("Ver todas");
            } else {
                listaAMostrar = peliculas;
                mostrandoFavoritas = false;
                item.setTitle("Ver favoritas");
            }

            adaptadorPelicula = new AdaptadorPelicula(listaAMostrar);
            RecyclerView rv = findViewById(R.id.rv);
            rv.setAdapter(adaptadorPelicula);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
