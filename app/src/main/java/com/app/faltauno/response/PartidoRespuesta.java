package com.app.faltauno.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas on 05/06/17.
 */

public class PartidoRespuesta {

    @SerializedName("match_id")
    private Long idPartido;

    @SerializedName("nombreOrganizador")
    private String nombreOrganizador;

    @SerializedName("email")
    private String email;

    @SerializedName("tamanioDeCancha")
    private Integer tamanioDeCancha;

    @SerializedName("hora")
    private String hora;

    @SerializedName("fecha")
    private String fecha;

    @SerializedName("genero")
    private String genero;

    @SerializedName("direccion")
    private String direccion;

    @SerializedName("ciudad")
    private String ciudad;

    @SerializedName("cupo")
    private String cupo;

    @SerializedName("nivel")
    private String nivel;

    @SerializedName("categoria")
    private String categoria;

    public long getIdPartido(){
        return idPartido;
    }

    public void setIdPartido(long id){
        this.idPartido = id;
    }

    public void setNombreOrganizador(String nombreOrganizador){
        this.nombreOrganizador = nombreOrganizador;
    }

    public String getNombreOrganizador(){
        return nombreOrganizador;
    }

    public void setTamanioDeCancha(Integer tamanioDeCancha){
        this.tamanioDeCancha = tamanioDeCancha;
    }

    public Integer getTamanioDeCancha() {
        return tamanioDeCancha;
    }

    public void setHora(String hora){
        this.hora = hora;
    }

    public String getHora(){
        return hora;
    }

    public void setFecha(String fecha){
        this.fecha = fecha;
    }

    public String getFecha(){
        return fecha;
    }

    public void setGenero(String genero){
        this.genero = genero;
    }

    public String getGenero(){
        return genero;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getNivel(){
        return nivel;
    }

    public void setCupo(String cupo) {
        this.cupo = cupo;
    }

    public String getCupo(){
        return cupo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria(){
        return categoria;
    }
}
