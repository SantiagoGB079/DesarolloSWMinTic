package com.example.misnegociosbd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    private DatabaseReference bd;
    private Button registrar, listar;
    private EditText padre, hijoUno, hijoDos, hijoTres, valueUno, valueDos, valueTres;
    String miPadre;
    String miHijoUno;
    String miHijoDos;
    String miHijoTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.btnReg);
        listar = findViewById(R.id.btnListar);
        padre = findViewById(R.id.txtPadre);
        hijoUno = findViewById(R.id.txtModoUnoUno);
        hijoDos = findViewById(R.id.txtModoDos);
        hijoTres = findViewById(R.id.txtModoTres);
        valueUno = findViewById(R.id.txtValueUno);
        valueDos = findViewById(R.id.txtValueDos);
        valueTres = findViewById(R.id.txtValueTres);
        miPadre = padre.getText().toString();
    }

    public void registrar(View view) {

        miPadre = padre.getText().toString();
        miHijoUno = hijoUno.getText().toString();
        miHijoDos = hijoDos.getText().toString();
        miHijoTres = hijoTres.getText().toString();

        String miValueUno = valueUno.getText().toString();
        String miValueDos = valueDos.getText().toString();
        String miValueTres = valueTres.getText().toString();

        bd = FirebaseDatabase.getInstance().getReference();
        bd.child(miPadre).child(miHijoUno).setValue(miValueUno);
        bd.child(miPadre).child(miHijoDos).setValue(miValueDos);
        bd.child(miPadre).child(miHijoTres).setValue(miValueTres);

        Toast.makeText(this, "Datos registrados exitosamente", Toast.LENGTH_SHORT).show();
    }

    public void listar(View view) {

        miPadre = padre.getText().toString();

        bd = FirebaseDatabase.getInstance().getReference();
        bd.child(miPadre).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {
                    // String h_uno = dataSnapshot.getKey();

                    // hijoUno.setText(h_uno);
                    String myDataUno = dataSnapshot.child("Horario").getValue().toString();
                    String myDataDos = dataSnapshot.child("Profesor").getValue().toString();
                    String myDataTres = dataSnapshot.child("Salón").getValue().toString();
                    valueUno.setText(myDataUno);
                    valueDos.setText(myDataDos);
                    valueTres.setText(myDataTres);

                   /* String myDataHijoUno = dataSnapshot.child(miHijoUno).getValue().toString();
                    String myDataHijoDos = dataSnapshot.child(miHijoDos).getValue().toString();
                    String myDataHijoTres = dataSnapshot.child(miHijoTres).getValue().toString();*/


                    /*hijoUno.setText(myDataUno);
                    hijoDos.setText(myDataDos);
                    hijoTres.setText(myDataTres);*/
                } else {
                    Toast.makeText(MainActivity.this, "No existe", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}