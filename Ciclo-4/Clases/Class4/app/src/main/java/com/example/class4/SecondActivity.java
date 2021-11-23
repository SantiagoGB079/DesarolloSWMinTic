package com.example.class4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView suma;
    private TextView producto;
    private TextView cociente;
    private EditText numero_x;
    private EditText numero_y;
    private Button sumar;
    private Button regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        suma = findViewById(R.id.txtSuma);
        producto = findViewById(R.id.txtprod);
        cociente = findViewById(R.id.txtCoc);
        numero_x = findViewById(R.id.xnum);
        numero_y = findViewById(R.id.ynum);
        sumar = findViewById(R.id.suma);
        regresar = findViewById(R.id.idreturn);

        Operaciones operaciones = new Operaciones();

        Toast.makeText(this, "Bienvenido "+MainActivity.name, Toast.LENGTH_SHORT).show();

        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double x, y;

                if (numero_x.getText().toString().isEmpty() || numero_y.getText().toString().isEmpty()) {
                   x=0;
                   y=0;
                }else{
                    x = Double.parseDouble(numero_x.getText().toString());
                    y = Double.parseDouble(numero_y.getText().toString());
                }

                suma.setText(String.valueOf(operaciones.sumar(x, y)));
                producto.setText(String.valueOf(operaciones.multiplicar(x, y)));
                cociente.setText(String.format("%.2f", operaciones.dividir(x, y)));
                numero_x.setText("0");
                numero_y.setText("0");

            }
        });

        regresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                regresarActivity();
            }
        });
    }

    public void regresarActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}