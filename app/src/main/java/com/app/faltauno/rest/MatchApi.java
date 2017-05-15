package com.app.faltauno.rest;

import com.app.faltauno.model.Match;

public interface MatchApi {

    // TODO: Cambiar host por "10.0.0.2" para Genymotion.
    // TODO: Cambiar host por "10.0.0.3" para AVD.
    // TODO: Cambiar host por IP de tu PC para dispositivo real.
    public static final String BASE_URL = "http://10.0.0.2/blog/api.saludmock.com/v1";

    @GET("match")
    Call<Match> login(@Body LoginBody loginBody);

}