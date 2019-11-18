package com.example.examen_lancho;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Alta extends AppCompatActivity {

    private CheckBox checkArte, checkCiencia, checkOtros;
    private EditText inputNombre, inputApellidos, inputOtros;
    private RadioGroup grupo;
    private TextView lblAmigosNuevos;

    private static int amigosNuevos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alta);

        lblAmigosNuevos = findViewById(R.id.lblAmigosNuevos);
        checkArte = findViewById(R.id.checkArte);
        checkCiencia = findViewById(R.id.checkCiencia);
        inputNombre = findViewById(R.id.inputNombre);
        inputApellidos = findViewById(R.id.inputApellidos);
        grupo = findViewById(R.id.grupo);
        inputOtros = findViewById(R.id.inputOtros);
        checkOtros = findViewById(R.id.checkOtros);
        checkOtros.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(checkOtros.isChecked()){
                    inputOtros.setVisibility(View.VISIBLE);
                }else{
                    inputOtros.setVisibility(View.INVISIBLE);
                }

            }
        });
    }

    public void cancelar(View v){
        finish();
    }

    public void alta(View v){

        String[] museos = {(checkArte.isChecked()?checkArte.getText().toString():""),
                           (checkCiencia.isChecked()?checkCiencia.getText().toString():""),
                           (checkOtros.isChecked()?inputOtros.getText().toString():"")};
        RadioButton radioChecked;
        radioChecked = findViewById(grupo.getCheckedRadioButtonId());
        Intent intent = new Intent(this, Verificacion.class);
        intent.putExtra("nombre", inputNombre.getText().toString());
        intent.putExtra("apellidos", inputApellidos.getText().toString());
        intent.putExtra("sexo", (radioChecked!=null?radioChecked.getText().toString():"Sin definir"));
        intent.putExtra("museos", museos);
        startActivityForResult(intent,1234);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1234 && resultCode == RESULT_OK){
            if(data.getBooleanExtra("resultado", true)){
                amigosNuevos++;
                inputNombre.setText("");
                inputApellidos.setText("");
                grupo.clearCheck();
                checkArte.setChecked(false);
                checkCiencia.setChecked(false);
                checkOtros.setChecked(false);
                inputOtros.setText("");
                inputOtros.setVisibility(View.INVISIBLE);
                lblAmigosNuevos.setText(lblAmigosNuevos.getText().toString().replace("X", amigosNuevos+""));
                lblAmigosNuevos.setVisibility(View.VISIBLE);
            }else{
                lblAmigosNuevos.setVisibility(View.INVISIBLE);
            }
        }

    }

}
