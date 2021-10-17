package com.example.linearlayout2pases;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etItem, etNombre;
    TextView tvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etItem = findViewById(R.id.etItem);
        etNombre = findViewById(R.id.etNombre);

        tvData = findViewById(R.id.tvDataA1);

        // recibir(); // estamos recibiendo los datos mediante otro metodo
    }

    public void ocInvocarA2(View view){
        // contenedor de datos
        Bundle bolsa = new Bundle();
        bolsa.putInt("item", Integer.parseInt(etItem.getText().toString())); // (nombre de envio, dato)
        bolsa.putString("nombre", etNombre.getText().toString());

        // creamos un invocador
        Intent invocar = new Intent(this, MainActivity2.class); //(desde, hacia)
        invocar.putExtras(bolsa);

        // enviar
        // startActivity(invocar);
        startActivityForResult(invocar, 2);
    }

    /*
    private void recibir(){
        Bundle bolsa = getIntent().getExtras();
        if(bolsa != null){
            int item = bolsa.getInt("itemA2");
            String nombre = bolsa.getString("nombreA2");
            tvData.setText(item + "\n" + nombre);
        }
    }
    */

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null){
            int item = data.getIntExtra("itemA2", -1);
            String nombre = data.getStringExtra("nombreA2");
            tvData.setText(item + "\n" + nombre);
        }
    }
}