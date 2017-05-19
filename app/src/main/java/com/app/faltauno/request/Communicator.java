package com.app.faltauno.request;

import android.util.Log;

import com.app.faltauno.response.MatchDataResponse;
import com.app.faltauno.services.ApiService;

import java.util.Date;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Communicator {
    private static final String TAG = "Communicator";
    private static final String SERVER_URL = "http://10.0.2.2:8080/faltauno-api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(SERVER_URL)
                    .build();
        }
        return retrofit;
    }

    public void matchPost(String ownerName, Integer countOfPlayers, Date time, Date date, String gender, String address, String city) {

        ApiService service = getClient(SERVER_URL).create(ApiService.class);

        Call<MatchDataResponse> call = service.postMatch(ownerName, countOfPlayers, time, date, gender, address, city);

        call.enqueue(new Callback<MatchDataResponse>() {
            @Override
            public void onResponse(Call<MatchDataResponse> call, Response<MatchDataResponse> response) {
                BusProvider.getInstance().post(new MatchEvent(response.body()));
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<MatchDataResponse> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }
}