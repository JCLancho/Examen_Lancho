package com.example.examen_lancho;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DialogoLogin.OnDialogoConfirmacionListener {

    private ConstraintLayout layout;
    private DialogoLogin dialogoLogin;
    private FragmentManager fragmentManager;
    private final String USUARIO = "usuario1";
    private final String CONTRASENIA = "123456";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        layout = findViewById(R.id.layout);
        fragmentManager = getSupportFragmentManager();

        dialogoLogin = new DialogoLogin();
        dialogoLogin.show(fragmentManager,"Dialogo");




    }


    @Override
    public void onPossitiveButtonClick() {

        String nombre = dialogoLogin.getInputNombre().getText().toString();
        String contrasenia = dialogoLogin.getInputContrasena().getText().toString();

        if(nombre.equals(USUARIO) && contrasenia.equals(CONTRASENIA)){
            layout.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(this,"INCORRECTO",Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNegativeButtonClick() {
        Toast.makeText(this,"Es necesario usuario y contraseña",Toast.LENGTH_LONG).show();

    }

    public void entrar(View v){
        Intent intent = new Intent(this, Menu.class);
        startActivity(intent);
    }

    public void salir(View v){
        finish();
    }




}
