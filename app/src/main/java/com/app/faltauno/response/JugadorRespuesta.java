package com.app.faltauno.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by lucas on 19/06/17.
 */

public class JugadorRespuesta implements Serializable {

    @SerializedName("idJugador")
    private Long idJugador;

    @SerializedName("idPartido")
    private Long idPartido;

    @SerializedName("nombreJugador")
    private String nombreJugador;

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
