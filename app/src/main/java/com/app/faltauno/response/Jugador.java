package com.app.faltauno.response;

/**
 * Created by lucas on 19/06/17.
 */

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

public class Jugador implements Serializable {

    @SerializedName("idJugador")
    private Long idJugador;

    @SerializedName("idPartido")
    private Long idPartido;

    @SerializedName("nombreJugador")
    private String nombreJugador;

    public Jugador(Long idPartido, String nombreJugador) {
        this.setNombreJugador(nombreJugador);
        this.setIdPartido(idPartido);
    }

    public long getIdPartido(){
        return idPartido;
    }

    public void setIdPartido(Long id){
        this.idPartido = id;
    }

    public long getIdJugador(){
        return idJugador;
    }

    public void setIdJugador(Long idJugador){
        this.idJugador = idJugador;
    }

    public void setNombreJugador(String nombreJugador){
        this.nombreJugador = nombreJugador;
    }

    public String getNombreJugador(){
        return nombreJugador;
    }


}
