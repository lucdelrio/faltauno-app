package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.Partido;
import com.app.faltauno.response.PartidoRespuesta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("matches")
    Call <Void> postPartido(@Body Partido partido);

    @GET("matches")
    Call <List<PartidoRespuesta>> getListaDePartidos();

}
