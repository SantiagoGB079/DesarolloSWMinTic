package com.example.class4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nombre;
    private TextView mi_nombre;
    private Button enviar;
    private Button borrar;
    public static String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.idName);
        mi_nombre = findViewById(R.id.idText);
        enviar = findViewById(R.id.btn_Send);
        borrar = findViewById(R.id.button2);
        enviar.setText("ENVIAR");
        borrar.setText("BORRAR");
        borrar.setEnabled(false);

        //nos muestra un msj al inicio de la actividad
        Toast.makeText(this, "inicio de actividad", Toast.LENGTH_SHORT).show();

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = nombre.getText().toString();
                borrar.setEnabled(true);
                borrar.setText("Iniciar");
            }
        });

        borrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initActivity();

            }
        });

    }

    public void initActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}