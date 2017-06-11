package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.MatchData;
import com.app.faltauno.response.MatchDataAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("matches")
    Call <Void> postMatch (@Body MatchData match);

    @GET("matches")
    Call <List<MatchDataAdapter>> getMatches();

}
