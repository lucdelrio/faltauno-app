package com.app.faltauno.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.MatchDataResponse;
import com.app.faltauno.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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
    private List<MatchDataResponse> listaDePartidos;

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

    private void getMatch(){
        ApiService service = Communicator.getClient().create(ApiService.class);

        Call<List<MatchDataResponse>> call = service.getListMatches();

        call.enqueue(new Callback<List<MatchDataResponse>>() {
            @Override
            public void onFailure(Call<List<MatchDataResponse>> call, Throwable t) {
                Log.d("APIPlug", "Error Occured: " + t.getMessage());

            }

            @Override
            public void onResponse(Call<List<MatchDataResponse>> call, Response<List<MatchDataResponse>> response) {
                Log.d("APIPlug", "Successfully response fetched" );

                listaDePartidos = response.body();

                if(listaDePartidos.size()>0) {
                    mostrarDatosPartido(1);
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    private void mostrarDatosPartido(Integer id) {
        Log.d("APIPlug", "Mostrar Datos del Partido");
        this.organizador.setText(listaDePartidos.get(id).getOwnerName());
        this.direccion.setText(listaDePartidos.get(id).getAddress());
        this.ciudad.setText(listaDePartidos.get(id).getCity());
        this.fecha.setText(listaDePartidos.get(id).getDate());
        this.hora.setText(listaDePartidos.get(id).getTime());
        this.genero.setText(listaDePartidos.get(id).getGender());
        this.cupo.setText(listaDePartidos.get(id).getCupo());
    }

}
