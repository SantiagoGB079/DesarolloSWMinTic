package com.example.patrimoniocultural;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarEtiqueta extends AppCompatActivity {

    private EditText txtBuscarEtiqueta;
    private Button btnBuscar, btnCamara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_etiqueta);

        txtBuscarEtiqueta = findViewById(R.id.txtBuscarEtiqueta);
        btnBuscar = findViewById(R.id.btnBusquedaEtiqueta);
        btnCamara = findViewById(R.id.btnCamara);
        ValidacionCampos validar = new ValidacionCampos();

        btnBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String etiqueta = txtBuscarEtiqueta.getText().toString();

                if (!validar.formEtiqueta(etiqueta)) {
                    Toast.makeText(BuscarEtiqueta.this, "Los campos no deben estar vacíos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(BuscarEtiqueta.this, "BUSQUEDA EXITOSA", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}