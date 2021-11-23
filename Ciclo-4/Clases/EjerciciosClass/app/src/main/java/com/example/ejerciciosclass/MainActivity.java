package com.example.ejerciciosclass;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.idButton1);
        button2 = findViewById(R.id.idButto2);
        button3 = findViewById(R.id.idButton3);
        button4 = findViewById(R.id.idbutton4);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initExcerciseOne();
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initExcercise2();
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initExcercise3();
            }
        });
    }

    public void initExcerciseOne() {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }

    public void initExcercise2() {
        Intent intent = new Intent(this, ActivityExcercise2.class);
        startActivity(intent);
    }

    public void initExcercise3() {
        Intent intent = new Intent(this, ActivityExcercise3.class);
        intent.putExtra("balotas", 1);
        startActivity(intent);
    }


}

