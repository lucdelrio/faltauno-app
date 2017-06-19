package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.response.PartidoRespuesta;

import java.util.List;

/**
 * Created by Rodrigo on 18/06/2017.
 */

public class Postulacion extends AppCompatActivity {

    EditText nombrePostulante;
    private List<PartidoRespuesta> listaDePartidos;
    Integer cupo;
    Long idPartidoSeleccionado;
    String cupoAString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.postulacion);

        nombrePostulante = (EditText) findViewById(R.id.input_nombre_ingresado);
        this.idPartidoSeleccionado = PasarDatosDelPartido.getIdPartido();
        this.listaDePartidos = PasarDatosDelPartido.getListaDePartidos();
        //this.idPartidoSeleccionado =  Integer.parseInt(PasarDatosDelPartido.getIdPartido().toString());
        //obtenerListaDePartidos();
    }

    public void onAceptarNombrePostulacionButtonClick(View view) {
        String nombrePostulanteAPartido = nombrePostulante.getText().toString();

        if (TextUtils.isEmpty(nombrePostulanteAPartido)) {
            toastErrorNombreVacio(view);
        }else{
            descontarCupo(view);
        }

    }

    public void descontarCupo(View v){
        /*
        int i = 0;

        while(listaDePartidos.get(i).getIdPartido() != this.idPartidoSeleccionado){
            i++;
        }
        */
        for(int i = 0; i < listaDePartidos.size(); i++) {
            if(listaDePartidos.get(i).getIdPartido() == this.idPartidoSeleccionado) {
                if (listaDePartidos.get(i).getCupo() > 0) {
                    int nuemeroARestar = 1;
                    this.cupo = listaDePartidos.get(i).getCupo() - nuemeroARestar;
                    this.cupoAString = cupo.toString();
                    mostrarCupo(v);
                } else {
                    toastCupoEsCero(v);
                }
            }
        }
    }

    public void obtenerListaDePartidos() {
        Intent startingIntent = getIntent();
        if (startingIntent != null) {
            Bundle b = startingIntent.getBundleExtra("android.intent.extra.INTENT");
            this.listaDePartidos = (List<PartidoRespuesta>) getIntent().getSerializableExtra("lista_partidos");
        }
    }

    public void toastErrorNombreVacio(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Debe ingresar un nombre para poder postularse", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

    public void toastCupoEsCero(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Lo sentimos pero no hay mas cupo para este partido", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

    public void mostrarCupo(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), this.cupoAString, Toast.LENGTH_SHORT);
        formErrorToast.show();
    }
}