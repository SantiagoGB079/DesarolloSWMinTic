package com.example.mishilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView salida;
    private Button pulsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        salida = findViewById(R.id.idTexto);
        pulsar = findViewById(R.id.btnPulsar);

        new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i <= 20; i++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final String cadena_uno = "Primer texto";
                    salida.post(new Runnable() {
                        @Override
                        public void run() {
                            salida.setBackgroundColor(getResources().getColor(R.color.purple_500));
                            salida.setTextColor(getResources().getColor(R.color.black));
                            salida.setTextSize(36);
                            salida.setText(cadena_uno);
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    final String cadena_dos = "Segundo texto";
                    salida.post(new Runnable() {
                        @Override
                        public void run() {
                            salida.setBackgroundColor(getResources().getColor(R.color.purple_500));
                            salida.setTextColor(getResources().getColor(R.color.black));
                            salida.setTextSize(36);
                            salida.setText(cadena_dos);
                        }
                    });
                }
            }
        }).start();

        OtroHilo otroHilo = new OtroHilo();

        pulsar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                otroHilo.start();
            }
        });

    }

    public class OtroHilo extends Thread {
        @Override
        public void run() {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i <= 20; i++) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        final String cadena_uno = "Tercer texto";
                        salida.post(new Runnable() {
                            @Override
                            public void run() {
                                salida.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                salida.setTextColor(getResources().getColor(R.color.black));
                                salida.setTextSize(36);
                                salida.setText(cadena_uno);
                            }
                        });
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        final String cadena_dos = "Cuarto texto";
                        salida.post(new Runnable() {
                            @Override
                            public void run() {
                                salida.setBackgroundColor(getResources().getColor(R.color.purple_500));
                                salida.setTextColor(getResources().getColor(R.color.black));
                                salida.setTextSize(36);
                                salida.setText(cadena_dos);
                            }
                        });
                    }
                }
            }).start();
        }
    }
}