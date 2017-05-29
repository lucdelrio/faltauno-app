package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.MatchData;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {

    @POST("match")
    Call<MatchData> postMatch (@Body MatchData match);

    @GET("match")
    Call<MatchData> getMatch(@Query("owner_name") String ownerName,
                             @Query("count_of_players") Integer countOfPlayers,
                             @Query("time") String time,
                             @Query("date") String date,
                             @Query("gender") String gender,
                             @Query("address") String address,
                             @Query("city") String city);

}
