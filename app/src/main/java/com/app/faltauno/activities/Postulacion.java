package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.Jugador;

/**
 * Created by Rodrigo on 18/06/2017.
 */

public class Postulacion extends AppCompatActivity {

    private Communicator communicator;
    EditText nombrePostulante;
    View v;

    private Long idPartido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postulacion);

        this.communicator = new Communicator();

        Intent intent = getIntent();
        Bundle index = intent.getExtras();

        this.idPartido =  Long.parseLong(index.get("idPartido").toString());

        nombrePostulante = (EditText) findViewById(R.id.input_nombre_ingresado);

        //Quita boton back de Action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        //getSupportActionBar().setDisplayShowHomeEnabled(false);
    }

    public void onAceptarNombrePostulacionButtonClick(View view) {

        String nombrePostulanteAPartido = nombrePostulante.getText().toString();

        if (TextUtils.isEmpty(nombrePostulanteAPartido)) {
            toastErrorNombreVacio(view);
        }else{
            Jugador jugadorPostulado = new Jugador(this.idPartido, nombrePostulanteAPartido);
            crearPostulacion(jugadorPostulado);
        }

    }

    private void crearPostulacion(Jugador jugadorPostulado){

        communicator.postJugador(jugadorPostulado, this);
    }

    public void actualizar(){

        Intent intentMainActivity = new Intent(Postulacion.this, MainActivity.class);
        startActivity(intentMainActivity);

    }

    public void toastErrorNombreVacio(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Debe ingresar un nombre para poder postularse", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

    public void toastNoPasoActivity(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "No se paso la activity", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

}