package com.example.ejerciciosclass;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityExcercise2 extends AppCompatActivity {

    private Button num1;
    private Button num2;
    private Button num3;
    private Button num4;
    private Button num5;
    private Button num6;
    private Button num7;
    private Button num8;
    private Button num9;
    private Button num0;
    private Button buttonIngesar;
    private TextView clave;
    private String pass = "0000";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excercise2);

        num1 = findViewById(R.id.button1);
        num2 = findViewById(R.id.button2);
        num3 = findViewById(R.id.button3);
        num4 = findViewById(R.id.idbutton4);
        num5 = findViewById(R.id.button5);
        num6 = findViewById(R.id.idbutton6);
        num7 = findViewById(R.id.idbutton7);
        num8 = findViewById(R.id.button8);
        num9 = findViewById(R.id.button9);
        num0 = findViewById(R.id.button0);
        buttonIngesar = findViewById(R.id.button12);
        clave = findViewById(R.id.idClave);
        clave.setText("");

        num0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "0");
                }
            }
        });
        num1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "1");
                }
            }
        });
        num2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "2");
                }
            }
        });
        num3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "3");
                }
            }
        });

        num5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "5");
                }
            }
        });
        num6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "6");
                }
            }
        });
        num7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "7");
                }
            }
        });
        num8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "8");
                }
            }
        });
        num9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "9");
                }
            }
        });

        num4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validatepsslength(clave.getText().toString())) {
                    clave.setText(clave.getText().toString() + "4");
                }
            }
        });
        buttonIngesar.setOnClickListener(new View.OnClickListener() {
            int cont = 0;

            @Override
            public void onClick(View v) {
                if (!validatePss(clave.getText().toString())) {
                    Toast.makeText(ActivityExcercise2.this, "Password incorrecto", Toast.LENGTH_LONG).show();
                    cont++;
                    if(cont==3){
                        blockingkeyWord();
                    }
                } else {
                    Toast.makeText(ActivityExcercise2.this, "Muy bieeeen", Toast.LENGTH_LONG).show();
                    cont=0;
                }
                clave.setText("");
            }
        });
    }

    public boolean validatepsslength(String pss) {

        return pss.length() > 3 ? true : false;
    }

    public boolean validatePss(String pss) {
        return pss.equals(pass) ? true : false;
    }

    public void blockingkeyWord(){
        num0.setEnabled(false);
        num1.setEnabled(false);
        num2.setEnabled(false);
        num3.setEnabled(false);
        num4.setEnabled(false);
        num5.setEnabled(false);
        num6.setEnabled(false);
        num7.setEnabled(false);
        num8.setEnabled(false);
        num9.setEnabled(false);
    }
}