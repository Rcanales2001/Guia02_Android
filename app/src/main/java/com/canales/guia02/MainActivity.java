package com.canales.guia02;


import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.canales.guia02.clase.Persona;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<Persona> lstPersonas = new ArrayList<>();
    private ListView lsvPersona;
    private Button btnAgregarPersona, btnMostrarPersonas,btnAcerca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAgregarPersona = findViewById(R.id.btnIrAgregar);

        btnMostrarPersonas = findViewById(R.id.btnMostrarLista);

        btnAcerca = findViewById(R.id.btnAcerca);

        btnAgregarPersona.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AgregarPersonaActivity.class));
        });

        btnMostrarPersonas.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, MostrarPersonaActivity.class));

        });
        btnAcerca.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                // Crear un Intent para ir a la otra actividad
                Intent intent = new Intent(MainActivity.this, AcercaDeActivity.class);
                startActivity(intent);
            }
        });

        /*rellenarLista();

         */
    }
    private void rellenarLista(){
        lstPersonas.add(new Persona(lstPersonas.size() + 1, "Juan", "Perez", 18, "juan@gmail.com"));
    }
    @Override
    protected void onStart() {
        super.onStart();
       // Toast.makeText(this, "Estgoy en el OnStart",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Toast.makeText(this, "Estgoy en el OnResume",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onPause() {
        super.onPause();
        // Toast.makeText(this, "Estgoy en el OnPause",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Toast.makeText(this, "Estgoy en el oOnDestroy",Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        // Toast.makeText(this, "Estgoy en el OnRestart",Toast.LENGTH_SHORT).show();
    }
}