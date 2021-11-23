package com.example.project3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView nombre;
    private EditText miNombre;
    private Button add;
    private Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=findViewById(R.id.tvName);
        miNombre =  findViewById(R.id.idName);
        add = findViewById(R.id.btn1);
        send = findViewById(R.id.btn2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre.setText("Santiago Gómez");
                send.setText("OK");
                miNombre.setText("Probando");
            }
        });
    }
}