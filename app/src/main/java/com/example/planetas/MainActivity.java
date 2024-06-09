package com.example.planetas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Spinner spinner;
    ImageView planetas;
    TextView descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        planetas = findViewById(R.id.planetas);
        descripcion = findViewById(R.id.descripcion);

        final String[] planetasNombres = getResources().getStringArray(R.array.planetas_nombres);
        final String[] planetasDescripciones = getResources().getStringArray(R.array.planetas_descripciones);
        final int[] planetasImagenes = {
                R.drawable.mercurio,
                R.drawable.venus,
                R.drawable.tierra,
                R.drawable.marte,
                R.drawable.jupiter,
                R.drawable.saturno,
                R.drawable.urano,
                R.drawable.neptuno
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, planetasNombres);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                planetas.setImageResource(planetasImagenes[position]);
                descripcion.setText(planetasDescripciones[position]);
                Toast.makeText(MainActivity.this, "Seleccionaste: " + planetasNombres[position], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // No se necesita ninguna acción aquí
            }
        });
    }
}
