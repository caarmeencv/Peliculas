package com.carmen.peliculas;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Date;

public class NuevaPelicula extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //intent para que cambie de activity desde la primaria
        Intent intentNuevaPeli  = getIntent();

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_nueva_pelicula);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionbar = getSupportActionBar();
        actionbar.setBackgroundDrawable(getResources().getDrawable(R.drawable.fondomenu, getTheme()));
        actionbar.setTitle(R.string.nuevapeli);
        getWindow().setNavigationBarColor(getColor(R.color.rosa));

        //boton de volver, la funcion de este boton esta mas abajo en onOptionsItemSelected
        actionbar.setDisplayHomeAsUpEnabled(true);

    }

    private void guardarPelicula() {
        // Obtener referencias de los campos
        EditText etTitulo = findViewById(R.id.etTitulo);
        EditText etDirector = findViewById(R.id.etDirector);
        EditText etDuracion = findViewById(R.id.etDuracion);
        Spinner spSala = findViewById(R.id.spSala);
        RadioGroup rgClasi = findViewById(R.id.radioGroup);
        CalendarView calendarView = findViewById(R.id.calendarView);

        String titulo = etTitulo.getText().toString().trim();
        String director = etDirector.getText().toString().trim();
        int duracion = 0;
        try {
            duracion = Integer.parseInt(etDuracion.getText().toString().trim());
        } catch (NumberFormatException e) {

        }
        String sala = spSala.getSelectedItem().toString();

        // Obtener clasificación
        int clasiId = rgClasi.getCheckedRadioButtonId();
        int clasiDrawable = 0;
        if (clasiId == R.id.rbG) {
            clasiDrawable = R.drawable.g;
        } else if (clasiId == R.id.rbPG) {
            clasiDrawable = R.drawable.pg;
        } else if (clasiId == R.id.rbPG13) {
            clasiDrawable = R.drawable.pg13;
        } else if (clasiId == R.id.rbR) {
            clasiDrawable = R.drawable.r;
        } else if (clasiId == R.id.rbNC17) {
            clasiDrawable = R.drawable.nc17;
        }

        // Fecha de estreno
        long fechaMillis = calendarView.getDate();

        // Crear objeto Pelicula (añade el constructor que acepte estos datos)
        Date fecha = new Date(fechaMillis);
        Pelicula nuevaPeli = new Pelicula(titulo, director, duracion, fecha, sala, clasiDrawable, R.drawable.sincara);
        nuevaPeli.setSinopsis("Sin sinopsis");

        // Preparar Intent de resultado
        Intent intent = new Intent();
        intent.putExtra("nuevaPelicula", nuevaPeli);
        setResult(RESULT_OK, intent);

        // Cerrar activity
        finish();
    }

    //funcion del boton de volver en el actionbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if (item.getItemId() == android.R.id.home){
            getOnBackPressedDispatcher().onBackPressed();
        } else if (id == R.id.mguardar){
            guardarPelicula();
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