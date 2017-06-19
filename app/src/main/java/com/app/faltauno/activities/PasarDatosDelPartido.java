package com.app.faltauno.activities;

import com.app.faltauno.response.PartidoRespuesta;

import java.util.List;

/**
 * Created by Rodrigo on 19/06/2017.
 */

public class PasarDatosDelPartido {
    private static Long idPartidoSeleccionado;
    private  static List<PartidoRespuesta> listaDePartidos;

    public static void setListaDePartidos(List<PartidoRespuesta> listaDePartidos) {
        PasarDatosDelPartido.listaDePartidos = listaDePartidos;
    }

    public static List<PartidoRespuesta> getListaDePartidos() {
        return listaDePartidos;
    }

    public static void setIdPartido(Long idPartido){
        idPartidoSeleccionado = idPartido;
    }

    public static Long getIdPartido(){
        return idPartidoSeleccionado;
    }
}
