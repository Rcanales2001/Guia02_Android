package com.canales.guia02;

import static com.canales.guia02.MainActivity.lstPersonas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.canales.guia02.clase.Persona;


public class MostrarPersonaActivity extends AppCompatActivity {
    private ListView lsvPersonas;
    private ArrayAdapter<Persona> arrayAdapter;
    private static final int EDITAR_PERSONA_REQUEST = 1; // Código de solicitud para la edición

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_persona);

        lsvPersonas = findViewById(R.id.lsvPersona);

        arrayAdapter = new ArrayAdapter<>
                (this, android.R.layout.simple_list_item_1, lstPersonas);

        lsvPersonas.setAdapter(arrayAdapter);

        // Configurar clic en un elemento de la lista para editar persona
        lsvPersonas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtén la persona seleccionada
                Persona personaParaEditar = lstPersonas.get(position);

                // Crea un intent para abrir la actividad de edición
                Intent intent = new Intent(MostrarPersonaActivity.this, EditarPersonaActivity.class);

                // Pasa los datos de la persona a la actividad de edición
                intent.putExtra("personaParaEditar", personaParaEditar);

                // Inicia la actividad de edición y espera un resultado
                startActivityForResult(intent, EDITAR_PERSONA_REQUEST);
            }
        });
        // Configurar clic largo en un elemento de la lista para eliminar persona
        lsvPersonas.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtén la persona seleccionada para eliminar
                final Persona personaParaEliminar = lstPersonas.get(position);

                // Crea un cuadro de diálogo de confirmación para eliminar
                AlertDialog.Builder builder = new AlertDialog.Builder(MostrarPersonaActivity.this);
                builder.setTitle("Eliminar Persona");
                builder.setMessage("¿Estás seguro de que quieres eliminar a esta persona?");

                // Agrega un botón para confirmar la eliminación
                builder.setPositiveButton("Eliminar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Elimina la persona de la lista
                        lstPersonas.remove(personaParaEliminar);
                        // Notifica al adaptador que los datos han cambiado
                        arrayAdapter.notifyDataSetChanged();
                    }
                });

                // Agrega un botón para cancelar la eliminación
                builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Cierra el cuadro de diálogo sin hacer nada
                        dialog.dismiss();
                    }
                });

                // Muestra el cuadro de diálogo
                builder.create().show();

                return true; // Indica que el evento ha sido manejado
            }
        });
    }


    // Método para manejar el resultado de la edición
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EDITAR_PERSONA_REQUEST && resultCode == RESULT_OK && data != null) {
            // Obtén la persona editada de los extras
            Persona personaEditada = data.getParcelableExtra("personaEditada");

            if (personaEditada != null) {
                // Encuentra la posición de la persona original en la lista y actualiza sus datos
                for (int i = 0; i < lstPersonas.size(); i++) {
                    if (lstPersonas.get(i).getIdPersona() == personaEditada.getIdPersona()) {
                        lstPersonas.set(i, personaEditada);
                        break;
                    }
                }

                // Notifica al adaptador que los datos han cambiado
                arrayAdapter.notifyDataSetChanged();
            }
        }
    }
}