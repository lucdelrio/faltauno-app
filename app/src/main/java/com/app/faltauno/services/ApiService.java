package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.Jugador;
import com.app.faltauno.response.JugadorRespuesta;
import com.app.faltauno.response.Partido;
import com.app.faltauno.response.PartidoRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ApiService {

    @POST("matches")
    Call <Void> postPartido(@Body Partido partido);

    @GET("matches")
    Call <List<PartidoRespuesta>> getListaDePartidos();

    @POST("matches/update")
    Call <Void> putPartido(@Body PartidoRespuesta partido);

    @POST("players")
    Call <Void> postJugador(@Body Jugador jugador);

    @GET("players")
    Call <List<JugadorRespuesta>> getListaDeJugadores();

    @GET("matches/male")
    Call <List<PartidoRespuesta>> getPartidosMasculino();

    @GET("matches/female")
    Call <List<PartidoRespuesta>> getPartidosFemenino();

    @GET("matches/mix")
    Call <List<PartidoRespuesta>> getPartidosMixto();
}
