package com.app.faltauno.rest;

public class RestClient {
    private static final String BASE_URL = "http://localhost:8080/faltauno-api";
    private static API REST_CLIENT;

    static {
        setupRestClient();
    }

    private RestClient(){}

    public static API getApiService(){ return REST_CLIENT; }

    private static void setupRestClient(){
        Gson gson = new GsonBuilder().create();
        RequestInterceptor requestInterceptor = new RequestInterceptor() {
            @Override
            public void intercept(RequestFacade request) {
                request.addHeader("Content-Type", "application/json");
            }
        };
        RestAdapter.Builder builder = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setRequestInterceptor(requestInterceptor)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL);

        RestAdapter restAdapter = builder.build();
        REST_CLIENT = restAdapter.create(API.class);
    }
}