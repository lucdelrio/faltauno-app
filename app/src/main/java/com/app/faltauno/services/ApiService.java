package com.app.faltauno.services;

/**
 * Created by lucas on 14/05/17.
 */
import com.app.faltauno.data.MatchData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {

    @POST("/match")
    @FormUrlEncoded
    Call<MatchData> postMatch(@Field("match_id") int matchId,
                                    @Field("owner_name") String ownerName,
                                    @Field("count_of_players") int countOfPlayers,
                                    @Field("time") String time,
                                    @Field("date") String date,
                                    @Field("gender") String gender,
                                    @Field("address") String address,
                                    @Field("city") String city);

    @POST("/match")
    @FormUrlEncoded
    Call<MatchData> getMatch(@Field("owner_name") String ownerName,
                                    @Field("count_of_players") String countOfPlayers,
                                    @Field("time") String time,
                                    @Field("date") String date,
                                    @Field("gender") String gender,
                                    @Field("address") String address,
                                    @Field("city") String city);
}
/*public class ApiService {

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8080/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(buildGson()))
            .build();

    private static Gson buildGson() {
        GsonBuilder builder = new GsonBuilder();
        builder.registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
            public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                return new Date(json.getAsJsonPrimitive().getAsLong());
            }
        });

        return builder.create();
    }
}
*/









/*public interface APIService {

    @POST("/matchData")
    @FormUrlEncoded
    Call<MatchDataResponse> postMatch(@Field("matchId") String matchId,
                              @Field("ownerName") String ownerName,
                              @Field("countOfPlayers") String countOfPlayers,
                              @Field("schedule") String schedule,
                              @Field("date") String date,
                              @Field("gender") String gender,
                              @Field("address") String address,
                              @Field("city") String city);

    @GET("/{id}/matchData")
    Call<MatchDataResponse> getMatch(@Query("matchId") long matchId,
                             @Query("ownerName") String ownerName,
                             @Query("countOfPlayers") Integer countOfPlayers,
                             @Query("schedule") String schedule,
                             @Query("date") String date,
                             @Query("gender") String gender,
                             @Query("address") String address,
                             @Query("city") String city);
}*/