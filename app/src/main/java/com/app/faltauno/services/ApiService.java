package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.response.MatchDataResponse;

import java.util.Date;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @POST("match")
    Call<MatchDataResponse> postMatch (@Body MatchDataResponse match);

    @GET("match")
    Call<MatchDataResponse> getMatch(@Field("owner_name") String ownerName,
                                     @Field("count_of_players") Integer countOfPlayers,
                                     @Field("time") Date time,
                                     @Field("date") Date date,
                                     @Field("gender") String gender,
                                     @Field("address") String address,
                                     @Field("city") String city);
}
