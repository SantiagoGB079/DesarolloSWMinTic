package com.example.patrimoniocultural;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button registrar;
    private Button buscarEtiqueta;
    private Button buscarPatrimonio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.btnRegistro);
        buscarEtiqueta = findViewById(R.id.btnBuscarEtiquetas);
        buscarPatrimonio = findViewById(R.id.btnBuscarPatrimonios);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initRegistrar();
            }
        });

        buscarEtiqueta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initBuscarEtiqueta();
            }
        });

        buscarPatrimonio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initBuscarPatrimonio();
            }
        });
    }

    public void initRegistrar() {
        Intent intent = new Intent(this, RegistroPatrimonio.class);
        startActivity(intent);
    }

    public void initBuscarEtiqueta() {
        Intent intent = new Intent(this, BuscarEtiqueta.class);
        startActivity(intent);
    }

    public void initBuscarPatrimonio(){
        Intent intent = new Intent(this,BuscarPatrimonio.class);
        startActivity(intent);
    }
}