package com.example.class5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    private TextView dia, mes, anio, hora, minuto, segundo,monitor;
    private int miDia, miMes, miMin, miHora, miAnio, miSeg;
    private Button fecha;
    private EditText name,apellido,direccion,telefono;
    private String [] data_per = new String[4];
    private int [] date = new int[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //dia = findViewById(R.id.tvDia);
        mes = findViewById(R.id.tvFechaCom);
        //anio = findViewById(R.id.tvAnio);
        //hora = findViewById(R.id.tvHora);
        minuto = findViewById(R.id.tvHoraCom);
        //segundo = findViewById(R.id.tvSeg);
        fecha = findViewById(R.id.idBtnFecha);
        name = findViewById(R.id.idName);
        apellido = findViewById(R.id.idApellido);
        direccion = findViewById(R.id.idDir);
        telefono = findViewById(R.id.idTel);
        //monitor = findViewById(R.id.idMonitor);

        Calendar c = Calendar.getInstance();
        miDia = c.get(Calendar.DAY_OF_MONTH);
        miMes = c.get(Calendar.MONTH)+1;
        miAnio = c.get(Calendar.YEAR);
        miHora = c.get(Calendar.HOUR_OF_DAY);
        miMin = c.get(Calendar.MINUTE);
        miSeg = c.get(Calendar.SECOND);

        //dia.setText(String.valueOf(miDia));
        mes.setText(String.valueOf(miDia+"/"+miMes+"/"+miAnio));
        //anio.setText(String.valueOf(miAnio));
        //hora.setText(String.valueOf(miHora));
        minuto.setText(String.valueOf(miHora+":"+miMin+":"+miSeg));
        //segundo.setText(String.valueOf(miSeg));

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data_per[0] = name.getText().toString();
                data_per[1] = apellido.getText().toString();
                data_per[2] = telefono.getText().toString();
                data_per[3] = direccion.getText().toString();

                date[0] = miDia;
                date[1] = miMes;
                date[2] = miAnio;
                date[3] = miHora;
                date[4] = miMin;

               // monitor.setText(String.valueOf(date[2]));

                if(name.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"nombre está vacío ", Toast.LENGTH_SHORT).show();
                }else{
                    initActivityDate();
                }
            }
        });
    }

    public void initActivityDate() {

        Intent intent = new Intent(this, Date.class);
        intent.putExtra("dataPer",data_per);
        intent.putExtra("date",date);
        startActivity(intent);
    }
}