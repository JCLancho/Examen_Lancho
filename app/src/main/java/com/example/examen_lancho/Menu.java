package com.example.examen_lancho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void alta(View v){
        Intent intent = new Intent(this, Alta.class);
        startActivity(intent);
    }

    public void listarAmigos(View v){
        Toast.makeText(this,"La opción seleccionada no está disponible actualmente",Toast.LENGTH_SHORT).show();
    }

    public void listarMuseos(View v){
        Intent intent = new Intent(this, Museos.class);
        startActivity(intent);
    }

}
