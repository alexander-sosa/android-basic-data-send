package com.example.linearlayout2pases;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView tvData;
    EditText etItem, etNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvData = findViewById(R.id.tvDataA2);
        etItem = findViewById(R.id.etItemA2);
        etNombre = findViewById(R.id.etNombreA2);

        // para recibir los datos tambien usamos un Bundle
        getSources();
    }

    private void getSources(){
        Bundle bolsa = getIntent().getExtras();
        int item = bolsa.getInt("item");
        String nombre = bolsa.getString("nombre");
        tvData.setText(item + "\n" + nombre);
    }

    public void ocRetornarA1(View view){
        Bundle bolsa = new Bundle();
        bolsa.putInt("itemA2", Integer.parseInt(etItem.getText().toString()));
        bolsa.putString("nombreA2", etNombre.getText().toString());

        //Intent retornar = new Intent(this, MainActivity.class);
        //retornar.putExtras(bolsa);
        Intent retornar = new Intent();
        retornar.putExtras(bolsa);
        setResult(MainActivity.RESULT_OK, retornar);
        finish();

        // startActivity(retornar); // este crea nuevos activities sin cerrar los anteriores.
    }
}