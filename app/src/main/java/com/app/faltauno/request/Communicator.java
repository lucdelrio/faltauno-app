package com.app.faltauno.request;

import android.widget.Toast;

import com.app.faltauno.activities.CrearPartido;
import com.app.faltauno.activities.Postulacion;
import com.app.faltauno.response.Jugador;
import com.app.faltauno.response.Partido;

import com.app.faltauno.services.ApiService;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class Communicator {

    //private static final String SERVER_URL = "http://192.168.100.107:8080/faltauno-api/";
    //private static final String SERVER_URL = "http://192.168.43.117:8080/faltauno-api/";
    private static final String SERVER_URL = "http://192.168.1.10:8080/faltauno-api/";

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

    public void postPartido(Partido datosDePartido, final CrearPartido activity)  {

        ApiService service = getClient().create(ApiService.class);
        Partido partido = new Partido(datosDePartido.getNombreOrganizador(), datosDePartido.getEmail(),
                                        datosDePartido.getTamanioDeCancha(), datosDePartido.getHora(),
                                        datosDePartido.getFecha(), datosDePartido.getGenero(), datosDePartido.getDireccion(),
                                        datosDePartido.getCiudad(), datosDePartido.getNivel(),
                                        datosDePartido.getCategoria(), datosDePartido.getCupo());

        Call<Void> call = service.postPartido(partido);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                activity.notificarListaDePartidos();

                Toast toastPartidoCreado = Toast.makeText(activity.getApplicationContext(), "Partido creado exitosamente", Toast.LENGTH_LONG);
                toastPartidoCreado.show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast toastErrorDeConexion = Toast.makeText(activity.getApplicationContext(), "Error de Conexión", Toast.LENGTH_LONG);
                toastErrorDeConexion.show();
            }
        });
    }

    public void postJugador(Jugador jugadorPostulado, final Postulacion activity)  {

        ApiService service = getClient().create(ApiService.class);
        Jugador jugador = new Jugador(jugadorPostulado.getIdPartido(), jugadorPostulado.getNombreJugador());

        Call<Void> call = service.postJugador(jugador);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                activity.actualizar();

                Toast toastPartidoCreado = Toast.makeText(activity.getApplicationContext(), "Postulación exitosa", Toast.LENGTH_LONG);
                toastPartidoCreado.show();

            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {

                Toast toastErrorDeConexion = Toast.makeText(activity.getApplicationContext(), "Error de Conexión", Toast.LENGTH_LONG);
                toastErrorDeConexion.show();
            }
        });
    }

}