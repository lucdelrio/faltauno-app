package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.MatchData;
import com.app.faltauno.response.MatchDataResponse;
import com.app.faltauno.response.MatchResults;

import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiService {

    @POST("match")
    Call <Void> postMatch (@Body MatchData match);

    @GET("match")
    Call <MatchResults> getMatch();

}
