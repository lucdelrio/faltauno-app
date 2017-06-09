package com.app.faltauno.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.app.faltauno.R;

/**
 * Created by Rodrigo on 08/06/2017.
 */

public class MostrarPartido extends AppCompatActivity {

    TextView organizador;
    TextView direccion;
    TextView ciudad;
    TextView fecha;
    TextView hora;
    TextView genero;
    TextView cupo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_crear_partido);

        organizador = (TextView) findViewById(R.id.out_put_organizador_seleccionado);
        direccion = (TextView) findViewById(R.id.out_put_direccion_seleccionado);
        ciudad = (TextView) findViewById(R.id.out_put_ciudad_seleccionado);
        fecha = (TextView) findViewById(R.id.out_put_fecha_seleccionado);
        hora = (TextView) findViewById(R.id.out_put_hora_seleccionado);
        genero = (TextView) findViewById(R.id.out_put_genero_seleccionado);
        cupo = (TextView) findViewById(R.id.out_put_cupo_seleccionado);
    }

    public void onMostrarPartidoPostularseButtonClick(View view) {

    }

}
