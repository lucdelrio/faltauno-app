package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.JugadorRespuesta;
import com.app.faltauno.services.ApiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by lucas on 19/06/17.
 */

public class JugadoresPostulados extends AppCompatActivity {

    private Long idPartido;
    TextView jugadores;

    List<JugadorRespuesta> getJugadorRespuesta;

    RecyclerView recyclerView;

    RecyclerView.LayoutManager recyclerViewlayoutManager;

    RecyclerView.Adapter recyclerViewadapter;

    private List<JugadorRespuesta> listaDeJugadores;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_jugadores);

        getJugadorRespuesta = new ArrayList<>();

        Intent intent = getIntent();
        Bundle index = intent.getExtras();

        this.idPartido =  Long.parseLong(index.get("idPartido").toString());

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        jugadores = (TextView) findViewById(R.id.output_jugadores);

        getJugadores();

        //Quita boton back de Action Bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

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

                if(listaDeJugadores.size()>0) {
                    mostrarJugadores(listaDeJugadores, idPartido);

                }else{
                    Log.d("APIPlug", "No item found");

                }
            }
        });
    }

    private void mostrarJugadores(List<JugadorRespuesta> array, Long id) {

        getJugadorRespuesta.clear();

        for(int i = 0; i<array.size(); i++) {

            if (array.get(i).getIdPartido() == id){
                JugadorRespuesta jugadorRespuesta = new JugadorRespuesta();

                jugadorRespuesta.setNombreJugador(array.get(i).getNombreJugador());
                jugadorRespuesta.setIdJugador(array.get(i).getIdJugador());

                getJugadorRespuesta.add(jugadorRespuesta);
            }
        }

        recyclerViewadapter = new Jugador(getJugadorRespuesta, this);

        recyclerView.setAdapter(recyclerViewadapter);

        if(!(getJugadorRespuesta.size() > 0)){

            mostrarAvisoPartidoVacio();
            mostrarBotonPostularse();
        }

    }

    private void mostrarAvisoPartidoVacio(){
        TextView avisoPartidoVacio = (TextView) findViewById(R.id.label_sin_jugadores);
        avisoPartidoVacio.setVisibility(View.VISIBLE);

    }

    private void mostrarBotonPostularse(){
        RelativeLayout contenedorBotonPostularse = (RelativeLayout) findViewById(R.id.contenedor_boton_postularse);
        contenedorBotonPostularse.setVisibility(View.VISIBLE);

        Button postularseButton = (Button) findViewById(R.id.boton_postularse_a_partido);
        postularseButton.setVisibility(View.VISIBLE);
    }

    public void onMostrarPartidoPostularseButtonClick(View view) {

        Intent postulacionPartido = new Intent(JugadoresPostulados.this, Postulacion.class);
        postulacionPartido.putExtra("idPartido", this.idPartido);
        startActivity(postulacionPartido);
    }

}
