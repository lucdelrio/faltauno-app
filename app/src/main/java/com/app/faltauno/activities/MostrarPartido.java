package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.MatchDataAdapter;
import com.app.faltauno.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rodrigo on 08/06/2017.
 */

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
    TextView cant_jugadores;

    private List<MatchDataAdapter> listaDePartidos;

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
        cant_jugadores = (TextView) findViewById(R.id.out_put_cant_jugadores_seleccionado);

        getMatch();
    }

    public void onMostrarPartidoPostularseButtonClick(View view) {

    }

    private void getMatch(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<MatchDataAdapter>> call = service.getListMatches();

        call.enqueue(new Callback<List<MatchDataAdapter>>() {
            @Override
            public void onFailure(Call<List<MatchDataAdapter>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

            }

            @Override
            public void onResponse(Call<List<MatchDataAdapter>> call, Response<List<MatchDataAdapter>> response) {

                listaDePartidos = response.body();

                if(listaDePartidos.size()>0) {
                    mostrarDatosPartido(idPartido);
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    private void mostrarDatosPartido(int id) {

        organizador.setText(listaDePartidos.get(id).getOwnerName());
        this.direccion.setText(listaDePartidos.get(id).getAddress());
        this.ciudad.setText(listaDePartidos.get(id).getCity());
        this.fecha.setText(listaDePartidos.get(id).getDate());
        this.hora.setText(listaDePartidos.get(id).getTime());
        this.genero.setText(listaDePartidos.get(id).getGender());
        this.cupo.setText(listaDePartidos.get(id).getQuota());
        this.nivel.setText(listaDePartidos.get(id).getLevel());
        this.categoria.setText(listaDePartidos.get(id).getCategory());
        this.cant_jugadores.setText(listaDePartidos.get(id).getCountOfPlayers().toString());
    }

}
