package com.app.faltauno.request;

import android.util.Log;

import com.app.faltauno.response.MatchData;
import com.app.faltauno.services.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Communicator {
    private static final String TAG = "Communicator";
    private static final String SERVER_URL = "http://192.168.100.107:8080/faltauno-api/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        //Here a logging interceptor is created
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        //The logging interceptor will be added to the http client
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        //The Retrofit builder will have the client attached, in order to get connection logs
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(SERVER_URL)
                    .client(httpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public void matchPost(String ownerName, String email, Integer countOfPlayers, String time, String date, String gender, String address,
                          String city, String level, String category, String quota)  {

        ApiService service = getClient().create(ApiService.class);
        MatchData match = new MatchData(ownerName, email, countOfPlayers, time, date, gender, address, city, level, category, quota);
        Call<Void> call = service.postMatch(match);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                Log.e(TAG, "Success");
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                // handle execution failures like no internet connectivity
                BusProvider.getInstance().post(new ErrorEvent(-2, t.getMessage()));
            }
        });
    }

}