package com.example.db_misnegocios;

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

    private DatabaseReference MyDB;
    private Button registrar, listar;
    private EditText padre, hijo_uno, hijo_dos, hijo_tres, val_uno, val_dos, val_tres;
    private String mi_padre, mi_hijo_uno, mi_hijo_dos, mi_hijo_tres;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registrar = findViewById(R.id.Bt_reg);
        listar = findViewById(R.id.Bt_listar);
        padre = findViewById(R.id.Et_nodo_uno);
        hijo_uno = findViewById(R.id.Et_nodo_uno_uno);
        hijo_dos = findViewById(R.id.Et_nodo_uno_dos);
        hijo_tres = findViewById(R.id.Et_nodo_uno_tres);
        val_uno = findViewById(R.id.Et_val_uno);
        val_dos = findViewById(R.id.Et_val_dos);
        val_tres = findViewById(R.id.Et_val_tres);


    }

    public void Registrar(View view){

        mi_padre = padre.getText().toString();
        mi_hijo_uno = hijo_uno.getText().toString();
        mi_hijo_dos = hijo_dos.getText().toString();
        mi_hijo_tres = hijo_tres.getText().toString();

        String mi_val_uno = val_uno.getText().toString();
        String mi_val_dos = val_dos.getText().toString();
        String mi_val_tres = val_tres.getText().toString();

        MyDB = FirebaseDatabase.getInstance().getReference();
        MyDB.child(mi_padre).child(mi_hijo_uno).setValue(mi_val_uno);
        MyDB.child(mi_padre).child(mi_hijo_dos).setValue(mi_val_dos);
        MyDB.child(mi_padre).child(mi_hijo_tres).setValue(mi_val_tres);

        Toast.makeText(this, "Datos registrados con éxito", Toast.LENGTH_SHORT).show();
    }

    public void Listar(View view){
        mi_padre = padre.getText().toString().trim();
        /*mi_hijo_uno = hijo_uno.getText().toString();
        mi_hijo_dos = hijo_dos.getText().toString();
        mi_hijo_tres = hijo_tres.getText().toString();*/
        MyDB = FirebaseDatabase.getInstance().getReference();
        MyDB.child(mi_padre).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String my_data_uno = snapshot.child("Física Uno").getValue().toString();
                    String my_data_dos = snapshot.child("Física Dos").getValue().toString();
                    String my_data_tres = snapshot.child("Física Tres").getValue().toString();
                    val_uno.setText(my_data_uno);
                    val_dos.setText(my_data_dos);
                    val_tres.setText(my_data_tres);

                }else{
                    Toast.makeText(MainActivity.this, "Data doesn't exist", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
            }
        });

    }

}