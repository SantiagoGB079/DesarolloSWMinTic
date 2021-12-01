package com.example.activitybd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText txtCodigo, txtDesc, txtPrecio;
    private Button btnAgregar, btnEliminar, btnEditar, btnBuscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCodigo = findViewById(R.id.txtCodigo);
        txtDesc = findViewById(R.id.txtDesc);
        txtPrecio = findViewById(R.id.textPrecio);
        btnAgregar = findViewById(R.id.btnAgregar);
        btnBuscar = findViewById(R.id.btnAgregar);
        btnEditar = findViewById(R.id.btnEditar);
        btnEliminar = findViewById(R.id.btnEliminar);
    }

    //Metodo registrar para ingresar la informacion
    public void registrar(View view) {
        MyDataBase myDataBase = new MyDataBase(this, "MyStore", null, 1);
        SQLiteDatabase BD = myDataBase.getWritableDatabase();//abrir la BD en modo escritura y lectura

        String miCodigo = txtCodigo.getText().toString();
        String miDescripcion = txtDesc.getText().toString();
        String miPrecio = txtPrecio.getText().toString();
        System.out.println("codigo"+miCodigo+"\ndescripcion "+miDescripcion+"\nprecio "+miPrecio);

        if (!(miCodigo.isEmpty() || miDescripcion.isEmpty() || miPrecio.isEmpty())) {
            ContentValues reg = new ContentValues();
            reg.put("codigo", miCodigo);
            reg.put("descripcion", miDescripcion);
            reg.put("precio", miPrecio);

            BD.insert("articulos", null, reg);
            BD.close();
            txtCodigo.setText("");
            txtDesc.setText("");
            txtPrecio.setText("");

            Toast.makeText(this, "REGISTRO EXITOSO", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "Datos no validos", Toast.LENGTH_SHORT).show();
        }

    }

    public void buscar(View view) {

        MyDataBase myDataBase = new MyDataBase(this, "MyStore", null, 1);
        SQLiteDatabase BD = myDataBase.getWritableDatabase();//abrir la BD en modo escritura y lectura

        String miCodigo = txtCodigo.getText().toString();

        if (!miCodigo.isEmpty()) {
            Cursor fila = BD.rawQuery("select descripcion, precio from articulos " +
                    "where codigo=" + miCodigo, null);

            if (fila.moveToFirst()) {
                txtDesc.setText(fila.getString(0));
                txtPrecio.setText(fila.getString(1));
                BD.close();
                Toast.makeText(this, "BUSQUEDA EXITOSO", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "El campo está vacío", Toast.LENGTH_SHORT).show();
        }
    }

    public void editar(View view) {

        MyDataBase myDataBase = new MyDataBase(this, "MyStore", null, 1);
        SQLiteDatabase BD = myDataBase.getWritableDatabase();//abrir la BD en modo escritura y lectura

        String miCodigo = txtCodigo.getText().toString();
        String miDescripcion = txtDesc.getText().toString();
        String miPrecio = txtPrecio.getText().toString();

        if (!miCodigo.isEmpty() || miDescripcion.isEmpty() || miPrecio.isEmpty()) {
            ContentValues reg = new ContentValues();
            reg.put("codigo", miCodigo);
            reg.put("descripcion", miDescripcion);
            reg.put("precio", miPrecio);

            int cantidad = BD.update("articulos", reg, "codigo= " + miCodigo, null);

            BD.close();

            if (cantidad == 1) {
                txtCodigo.setText("");
                txtDesc.setText("");
                txtPrecio.setText("");
                Toast.makeText(this, "Actualización exitosa", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "articulo no existe", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Los campos estan vacios", Toast.LENGTH_SHORT).show();
        }
    }

    public void eliminar(View view) {
        MyDataBase myDataBase = new MyDataBase(this, "MyStore", null, 1);
        SQLiteDatabase BD = myDataBase.getWritableDatabase();//abrir la BD en modo escritura y lectura

        String miCodigo = txtCodigo.getText().toString();

        if (!miCodigo.isEmpty()) {

            int cantidad = BD.delete("articulos", "codigo= " + miCodigo, null);
            BD.close();
            txtCodigo.setText("");
            txtDesc.setText("");
            txtPrecio.setText("");

            if (cantidad == 1) {
                Toast.makeText(this, "Articulo eliminado exitosamente", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "El articulo no existe", Toast.LENGTH_SHORT).show();
            }

        } else {
            Toast.makeText(this, "El campo está vacío", Toast.LENGTH_SHORT).show();
        }
    }
}