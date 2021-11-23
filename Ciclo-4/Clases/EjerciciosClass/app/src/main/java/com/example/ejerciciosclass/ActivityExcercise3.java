package com.example.ejerciciosclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ActivityExcercise3 extends AppCompatActivity {

    private TextView balota1;
    private TextView balota2;
    private TextView balota3;
    private TextView balota4;
    private Button generar;
    private int valor;
    private int balot1;
    private int balot2;
    private int balot3;
    private int balot4;
    Random balota = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise3);

        balota1 = findViewById(R.id.txtBalota1);
        balota2 = findViewById(R.id.txtBalota2);
        balota3 = findViewById(R.id.txtBalota3);
        balota4 = findViewById(R.id.txtBalota4);
        generar = findViewById(R.id.idGenerar);

        Bundle extras = getIntent().getExtras();
        valor = extras.getInt("balotas");

        balota1.setText(String.valueOf(valor));

        generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                balot1 = balota.nextInt(10);
                balot2 = balota.nextInt(10);
                balot3 = balota.nextInt(10);
                balot4 = balota.nextInt(10);

                balota1.setText(String.valueOf(balot1));
                balota2.setText(String.valueOf(balot2));
                balota3.setText(String.valueOf(balot3));
                balota4.setText(String.valueOf(balot4));
            }
        });
    }

}