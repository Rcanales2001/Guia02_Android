package com.canales.guia02;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.canales.guia02.clase.Persona;



public class EditarPersonaActivity extends AppCompatActivity {
    private EditText edtNombre, edtApellido, edtEdad, edtCorreo;
    private Button btnGuardar;
    private Persona personaAEditar; // Persona a editar

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_persona);

        edtNombre = findViewById(R.id.edtNombre);
        edtApellido = findViewById(R.id.edtApellido);
        edtEdad = findViewById(R.id.edtEdad);
        edtCorreo = findViewById(R.id.edtCorreo);
        btnGuardar = findViewById(R.id.btnGuardar);

        // Obtén la persona a editar de los extras del intent
        personaAEditar = getIntent().getParcelableExtra("personaParaEditar");

        if (personaAEditar != null) {
            // Carga los datos de la persona seleccionada para editar en los campos de edición
            edtNombre.setText(personaAEditar.getNombrePersona()); // Cambiado a getNombrePersona()
            edtApellido.setText(personaAEditar.getApellidoPersona()); // Cambiado a getApellidoPersona()
            edtEdad.setText(String.valueOf(personaAEditar.getEdadPersona())); // Cambiado a getEdadPersona()
            edtCorreo.setText(personaAEditar.getCorreoPersona()); // Cambiado a getCorreoPersona()
        }

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda los cambios en la persona
                if (personaAEditar != null) {
                    personaAEditar.setNombrePersona(edtNombre.getText().toString());
                    personaAEditar.setApellidoPersona(edtApellido.getText().toString());
                    personaAEditar.setEdadPersona(Integer.parseInt(edtEdad.getText().toString()));
                    personaAEditar.setCorreoPersona(edtCorreo.getText().toString());

                    // Notifica que se han guardado los cambios (puedes usar un Toast)
                    Toast.makeText(EditarPersonaActivity.this, "Cambios guardados", Toast.LENGTH_SHORT).show();

                    // Puedes enviar la persona editada de vuelta a la actividad anterior si es necesario

                    // Aquí, puedes enviar la persona editada de vuelta a MostrarPersonaActivity si es necesario
                    Intent intent = new Intent();
                    intent.putExtra("personaEditada", personaAEditar);
                    setResult(RESULT_OK, intent);

                    finish(); // Cierra la actividad de edición
                }
            }
        });
    }
}