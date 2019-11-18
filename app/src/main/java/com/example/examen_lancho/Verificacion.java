package com.example.examen_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Verificacion extends AppCompatActivity {

    private TextView lblNombreValor, lblApellidosValor, lblSexoValor, lblMuesosValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verificacion);

        lblNombreValor = findViewById(R.id.lblNombreValor);
        lblApellidosValor = findViewById(R.id.lblApellidosValor);
        lblSexoValor = findViewById(R.id.lblSexoValor);
        lblMuesosValor = findViewById(R.id.lblMuseosValor);

        Bundle extras = getIntent().getExtras();
        String nombre = extras.getString("nombre");
        String apellidos = extras.getString("apellidos");
        String sexo = extras.getString("sexo");
        String[] museos = extras.getStringArray("museos");

        lblNombreValor.setText(nombre);
        lblApellidosValor.setText(apellidos);
        lblSexoValor.setText(sexo);

        String lblMuseos = "";
        for(String str : museos){
            if(!str.equals("")){
                lblMuseos += str.toUpperCase()+", ";
            }
        }

        if(lblMuseos.length() > 2)
            lblMuseos = lblMuseos.substring(0, lblMuseos.length()-2);
        lblMuesosValor.setText(lblMuseos);

    }


    public void aceptar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado",true);
        setResult(RESULT_OK, intent);
        finish();
    }

    public void rechazar(View v){
        Intent intent = new Intent();
        intent.putExtra("resultado",false);
        setResult(RESULT_OK, intent);
        finish();
    }


}
