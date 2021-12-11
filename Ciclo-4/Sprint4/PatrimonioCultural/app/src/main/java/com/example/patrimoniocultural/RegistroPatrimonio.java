package com.example.patrimoniocultural;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistroPatrimonio extends AppCompatActivity {

    private EditText NomPatrimonio;
    private EditText palabrasClave;
    private EditText etiqueta;
    private EditText ubicacion;
    private EditText tipoPatrimonio;
    private Button registrarPatrimonio;
    private String nombre, palabras, etiq, ubic, tipPat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_patrimonio);

        NomPatrimonio = findViewById(R.id.idNameLugar);
        palabrasClave = findViewById(R.id.idPalabras);
        etiqueta = findViewById(R.id.idEtiqueta);
        ubicacion = findViewById(R.id.idUbicacion);
        tipoPatrimonio = findViewById(R.id.idTipoPatrimonio);
        registrarPatrimonio = findViewById(R.id.btnRegistrar);
        ValidacionCampos validar = new ValidacionCampos();
        DataProcess data = new DataProcess();
        Map mapa = new Map();
        etiqueta.setEnabled(false);


        registrarPatrimonio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = NomPatrimonio.getText().toString();
                palabras = palabrasClave.getText().toString();
                //etiq = etiqueta.getText().toString();
                ubic = ubicacion.getText().toString();
                tipPat = tipoPatrimonio.getText().toString();
                etiq = data.generadorEtiqueta(nombre, tipPat);

                if (etiq.contains("campos")) {
                    Toast.makeText(RegistroPatrimonio.this, etiq, Toast.LENGTH_SHORT).show();
                    etiq = "";
                } else {
                    //etiqueta.setEnabled(true);
                    etiqueta.setText(etiq);
                    etiq = etiqueta.getText().toString();
                }

                if (!mapa.coordenadasLimites(ubic)){
                    Toast.makeText(RegistroPatrimonio.this, "Valores no permitidos",
                            Toast.LENGTH_SHORT).show();
                }

                if (!validar.formRegistros(nombre, tipPat, palabras, etiq, ubic)) {
                    Toast.makeText(RegistroPatrimonio.this, "Los campos no deben estar vacíos", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistroPatrimonio.this, "PATRIMONIO REGISTRADO", Toast.LENGTH_SHORT).show();
                }

                int cant = data.contadorKeyWord(palabras);
                String coordenadas = mapa.convertirUbicacion(ubic);
            }
        });
    }
}