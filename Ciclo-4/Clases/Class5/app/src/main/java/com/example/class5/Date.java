package com.example.class5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Date extends AppCompatActivity {

    private TextView anio, mes, dia, hora, minuto, monitoreo, txtCalculoEdad;
    private Button calcular;
    Context myContext = this;
    private String[] dataPer = new String[3];
    private int[] date = new int[4];
    private int aaaa, mm, dd, hor, min, anios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);

        anio = findViewById(R.id.tvAnio2);
        mes = findViewById(R.id.tvMes2);
        dia = findViewById(R.id.tvDia2);
        minuto = findViewById(R.id.tvMin2);
        hora = findViewById(R.id.tvHora2);
        monitoreo = findViewById(R.id.idMonitoreo);
        txtCalculoEdad = findViewById(R.id.idEdad);
        calcular = findViewById(R.id.btnCalcular);

        receive();
        monitoreo.setText(dataPer[0]+" "+dataPer[1]+" - "+dataPer[2]+" - "+dataPer[3]);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(myContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        anio.setText(new StringBuilder().append(year));
                        mes.setText(new StringBuilder().append(month+1));
                        dia.setText(new StringBuilder().append(dayOfMonth));
                        aaaa=year;
                        mm = month;
                        dd = dayOfMonth;
                        Toast.makeText(Date.this, "Esta es la fecha anio "+aaaa,Toast.LENGTH_LONG).show();
                        txtCalculoEdad.setText(new StringBuilder().append(date[2]-aaaa));
                    }
                }, aaaa, mm, dd);
                datePickerDialog.show();

                TimePickerDialog timePickerDialog = new TimePickerDialog(myContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        hora.setText(new StringBuilder().append(hourOfDay));
                        minuto.setText(new StringBuilder().append(minute));
                    }
                }, hor, min,true);
                timePickerDialog.show();

            }

        });
    }

    public void receive(){
        Bundle bundle = getIntent().getExtras();
        dataPer = bundle.getStringArray("dataPer");
        date = bundle.getIntArray("date");

    }
}