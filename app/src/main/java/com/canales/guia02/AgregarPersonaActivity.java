package com.canales.guia02;

import androidx.appcompat.app.AppCompatActivity;
import static com.canales.guia02.MainActivity.lstPersonas;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.canales.guia02.clase.Persona;

public class AgregarPersonaActivity extends AppCompatActivity {
    EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    Button btnProcesar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_persona);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        edtCorreo = findViewById(R.id.edtCorreo);
        btnProcesar = findViewById(R.id.btnProcesar);

        btnProcesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lstPersonas.add(new Persona(lstPersonas.size() + 1, edtNombre.getText().toString(),
                        edtApellido.getText().toString(), Integer.parseInt(edtEdad.getText().toString()),
                        edtCorreo.getText().toString()));

                Toast.makeText(AgregarPersonaActivity.this, "Inserción exitosa", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}