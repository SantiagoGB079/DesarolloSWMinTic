package com.example.ejerciciosclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class ActivityExercise1 extends AppCompatActivity {

    private Button regresar;
    private Spinner menu;
    private TextView mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise1);

        regresar = findViewById(R.id.idRegresar);
        menu = findViewById(R.id.spinner);
        mensaje = findViewById(R.id.idText);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.menu,
                android.R.layout.simple_spinner_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initSecondActivity();
            }
        });
    }

    public void initSecondActivity() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}