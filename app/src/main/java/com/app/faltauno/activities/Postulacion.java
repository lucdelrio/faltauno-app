package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.faltauno.R;

/**
 * Created by Rodrigo on 18/06/2017.
 */

public class Postulacion extends AppCompatActivity {

    EditText nombrePostulante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postulacion);

        nombrePostulante = (EditText) findViewById(R.id.input_nombre_ingresado);
    }

    public void onAceptarNombrePostulacionButtonClick(View view) {
        String nombrePostulanteAPartido = nombrePostulante.getText().toString();

        if (TextUtils.isEmpty(nombrePostulanteAPartido)) {
            toastErrorNombreVacio(view);
        }else{

        }

    }

    public void toastErrorNombreVacio(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Debe ingresar un nombre para poder postularse", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

}