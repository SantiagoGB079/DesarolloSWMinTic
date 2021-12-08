package com.example.ejerciciosclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private Button button;
    private int cont = 0;
    private String msj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        button = findViewById(R.id.idButtonOpt);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cont++;
                if (cont == 7) {
                    msj = "esooo desarrollador";
                    Toast.makeText(SecondActivity.this, msj, Toast.LENGTH_SHORT).show();
                }
                if (cont == 9) {
                    msj = "Con un toque mas podrás iniciar";
                    Toast.makeText(SecondActivity.this, msj, Toast.LENGTH_SHORT).show();
                }
                if (cont == 10) {
                    initSecondActivity();
                }
            }
        });
    }

    public void initSecondActivity() {
        Intent intent = new Intent(this, ActivityExercise1.class);
        startActivity(intent);
    }
}