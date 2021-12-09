package com.example.persistencia850;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText palabra;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palabra = findViewById(R.id.idPalabra);
        guardar = findViewById(R.id.idGuardar);
        SharedPreferences pref = getSharedPreferences("datoss", Context.MODE_PRIVATE);
        palabra.setText(pref.getString("mi_clave", ""));
    }

    public void guardar(View view) {
        SharedPreferences pref = getSharedPreferences("datoss", Context.MODE_PRIVATE);
        SharedPreferences.Editor objEditor = pref.edit();
        objEditor.putString("mi_clave", palabra.getText().toString());
        objEditor.commit();
        finish();
    }
}