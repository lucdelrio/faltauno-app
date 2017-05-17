package com.app.faltauno.remote;

import com.app.faltauno.services.ApiService;

public class ApiUtils {

    private ApiUtils() {}

    public static final String BASE_URL = "http://10.0.2.2:8080/faltauno-api/";

    public static ApiService getAPIService() {

        return RetrofitClient.getClient(BASE_URL).create(ApiService.class);
    }
}