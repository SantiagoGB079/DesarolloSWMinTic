package com.example.patrimoniocultural;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuscarPatrimonio extends AppCompatActivity {

    private EditText txtBuscarPatrimonio;
    private Button btnBuscarPatrimonio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar_patrimonio);

        txtBuscarPatrimonio = findViewById(R.id.txtBusquedaPatrimonio);
        btnBuscarPatrimonio = findViewById(R.id.btnBusquedaPatrimonio);
        ValidacionCampos validar = new ValidacionCampos();

        btnBuscarPatrimonio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String patrimonio = txtBuscarPatrimonio.getText().toString();

                if (!validar.formBusqueda(patrimonio)){
                    Toast.makeText(BuscarPatrimonio.this, "Los campos no coinciden", Toast.LENGTH_SHORT).show();
                } else{
                    Toast.makeText(BuscarPatrimonio.this, "BUSQUEDA EXITOSA", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}