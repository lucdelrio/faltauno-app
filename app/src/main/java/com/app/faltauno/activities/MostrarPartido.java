package com.app.faltauno.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.JugadorRespuesta;
import com.app.faltauno.response.PartidoRespuesta;
import com.app.faltauno.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MostrarPartido extends AppCompatActivity {

    private Integer idPartido;
    TextView organizador;
    TextView direccion;
    TextView ciudad;
    TextView fecha;
    TextView hora;
    TextView genero;
    TextView cupo;
    TextView nivel;
    TextView categoria;
    TextView tamanioDeCancha;
    private Long idPartidoMostrado;

    private List<PartidoRespuesta> listaDePartidos;
    private List<JugadorRespuesta> listaDeJugadores;
    private int cantidadJugadores = 0;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_mostrar_partido);

        Intent intent = getIntent();
        Bundle index = intent.getExtras();

        this.idPartido =  Integer.parseInt(index.get("index").toString());

        organizador = (TextView) findViewById(R.id.out_put_organizador_seleccionado);
        direccion = (TextView) findViewById(R.id.out_put_direccion_seleccionado);
        ciudad = (TextView) findViewById(R.id.out_put_ciudad_seleccionado);
        fecha = (TextView) findViewById(R.id.out_put_fecha_seleccionado);
        hora = (TextView) findViewById(R.id.out_put_hora_seleccionado);
        genero = (TextView) findViewById(R.id.out_put_genero_seleccionado);
        cupo = (TextView) findViewById(R.id.out_put_cupo_seleccionado);
        nivel = (TextView) findViewById(R.id.out_put_nivel_seleccionado);
        categoria = (TextView) findViewById(R.id.out_put_categoria_seleccionado);
        tamanioDeCancha = (TextView) findViewById(R.id.out_put_tamanio_de_cancha_seleccionado);

        getMatch();
        //getJugadores();
    }

/*
    public void contarJugadores(){
        for(int i = 0; i < listaDeJugadores.size(); i++){
            if(listaDeJugadores.get(i).getIdPartido() == this.idPartido){
               this.cantidadJugadores++;
            }
        }
    }
*/

    public void onMostrarPartidoPostularseButtonClick(View view) {

        Intent postulacionPartido = new Intent(MostrarPartido.this, Postulacion.class);
        postulacionPartido.putExtra("idPartido", this.idPartidoMostrado);
        startActivity(postulacionPartido);
    }

    public void onMostrarJugadoresButtonClick(View view) {

        Intent jugadoresPartido = new Intent(MostrarPartido.this, JugadoresPostulados.class);
        jugadoresPartido.putExtra("idPartido", this.idPartidoMostrado);
        startActivity(jugadoresPartido);
    }


    private void getMatch(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<PartidoRespuesta>> call = service.getListaDePartidos();

        call.enqueue(new Callback<List<PartidoRespuesta>>() {
            @Override
            public void onFailure(Call<List<PartidoRespuesta>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

            }

            @Override
            public void onResponse(Call<List<PartidoRespuesta>> call, Response<List<PartidoRespuesta>> response) {

                listaDePartidos = response.body();

                if(listaDePartidos.size()>0) {
                    mostrarDatosPartido(idPartido);
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

/*
    private void getJugadores(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<JugadorRespuesta>> call = service.getListaDeJugadores();

        call.enqueue(new Callback<List<JugadorRespuesta>>() {
            @Override
            public void onFailure(Call<List<JugadorRespuesta>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());
            }

            @Override
            public void onResponse(Call<List<JugadorRespuesta>> call, Response<List<JugadorRespuesta>> response) {
                listaDeJugadores = response.body();
                contarJugadores();
            }
        });
    }
*/

    private void mostrarDatosPartido(int id) {

        this.idPartidoMostrado = listaDePartidos.get(id).getIdPartido();
        organizador.setText(listaDePartidos.get(id).getNombreOrganizador());
        this.direccion.setText(listaDePartidos.get(id).getDireccion());
        this.ciudad.setText(listaDePartidos.get(id).getCiudad());
        this.fecha.setText(listaDePartidos.get(id).getFecha());
        this.hora.setText(listaDePartidos.get(id).getHora());
        this.genero.setText(listaDePartidos.get(id).getGenero());
        this.cupo.setText(listaDePartidos.get(id).getCupo().toString());
        this.nivel.setText(listaDePartidos.get(id).getNivel());
        this.categoria.setText(listaDePartidos.get(id).getCategoria());
        this.tamanioDeCancha.setText(listaDePartidos.get(id).getTamanioDeCancha().toString());

/*
        if(this.cantidadJugadores == 0){
            ocultarBotonJugadores();
        }
*/

        ocultarBotonPostularse(listaDePartidos.get(id).getCupo());


        if(listaDePartidos.get(id).getCupo().equals(0)){
            this.cupo.setText("COMPLETO");
            this.cupo.setTextColor(this.cupo.getContext().getResources().getColor(R.color.colorAccentGreen));
        }

        if(listaDePartidos.get(id).getCupo().equals(1)){
            String rojo = "#FF0000";
            this.cupo.setTextColor(Color.parseColor(rojo));
        }
    }

    private void ocultarBotonPostularse(Integer cupoPartido){
        Button postularseButton = (Button) findViewById(R.id.boton_postularse_a_partido);
        if(cupoPartido == 0){
            postularseButton.setVisibility(View.INVISIBLE);
        }
    }

/*
    private void ocultarBotonJugadores(){
        Button verJugadoresButton = (Button) findViewById(R.id.boton_ver_jugadores);
        RelativeLayout borde = (RelativeLayout) findViewById(R.id.borde);
        verJugadoresButton.setVisibility(View.INVISIBLE);
        borde.setVisibility(View.INVISIBLE);
    }
*/



}
