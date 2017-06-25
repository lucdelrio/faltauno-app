package com.app.faltauno.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.faltauno.R;
import com.app.faltauno.request.Communicator;
import com.app.faltauno.response.Jugador;
import com.app.faltauno.response.JugadorRespuesta;
import com.app.faltauno.response.Partido;
import com.app.faltauno.response.PartidoRespuesta;
import com.app.faltauno.services.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class Postulacion extends AppCompatActivity {

    private Communicator communicator;
    private List<PartidoRespuesta> listaDePartidos;
    private Partido partidoADescontar;
    private Long idPartido;

    EditText nombrePostulante;
    View v;
    private List<JugadorRespuesta> listaDeJugadores;

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
        getJugadores();
    }

    public void onAceptarNombrePostulacionButtonClick(View view) {

        String nombrePostulanteAPartido = nombrePostulante.getText().toString();

        if (TextUtils.isEmpty(nombrePostulanteAPartido)) {
            toastErrorNombreVacio(view);
        }else if(validarNombre(nombrePostulanteAPartido, view)){
            toastJugadorRepetido(view);
        }else{
            Jugador jugadorPostulado = new Jugador(this.idPartido, nombrePostulanteAPartido);

            descontarCupo();

            crearPostulacion(jugadorPostulado);
        }

    }

    private boolean validarNombre(String nombreJugador, View view){
        boolean nombreRepetido = false;
        for(int i = 0; i < listaDeJugadores.size(); i++) {
            if (nombreJugador.equals(listaDeJugadores.get(i).getNombreJugador().toString()) && listaDeJugadores.get(i).getIdPartido() == idPartido) {
                nombreRepetido = true;
            }
        }
        return nombreRepetido;
    }

    private void descontarCupo(){
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

                    for(int i = 0; i < listaDePartidos.size(); i++){
                        if(listaDePartidos.get(i).getIdPartido() == idPartido){

                            descontarCupoEnPartido(listaDePartidos.get(i));
                        }
                    }
                }else{
                    Log.d("APIPlug", "No item found");
                }
            }
        });
    }

    private boolean descontarCupoEnPartido(PartidoRespuesta partido){

        boolean descuentoExitoso = false;

        PartidoRespuesta partidoCupoDescontado = partido;
        Integer cupoPartido = partidoCupoDescontado.getCupo();

        if (cupoPartido-1 >=  0){
            descuentoExitoso = true;
            partidoCupoDescontado.setCupo(cupoPartido-1);
            communicator.putPartido(partidoCupoDescontado, this);
        }else{
            descuentoExitoso = false;
        }
        return descuentoExitoso;
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
            }
        });
    }

    public void notificarActualizacionDePartido(){

        Intent jugadoresPostulados = new Intent(Postulacion.this, JugadoresPostulados.class);
        jugadoresPostulados.putExtra("idPartido", this.idPartido);
        startActivity(jugadoresPostulados);

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

    public void toastJugadorRepetido(View view){
        Toast formErrorToast = Toast.makeText(getApplicationContext(), "Ya existe ese nombre de jugador, por favor elija otro", Toast.LENGTH_SHORT);
        formErrorToast.show();
    }

}