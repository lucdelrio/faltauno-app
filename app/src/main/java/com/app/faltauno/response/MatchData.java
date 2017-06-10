package com.app.faltauno.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MatchData implements Serializable {

    @SerializedName("match_id")
    private Integer matchId;

    @SerializedName("ownerName")
    private String ownerName;

    @SerializedName("countOfPlayers")
    private Integer countOfPlayers;

    @SerializedName("time")
    private String time;

    @SerializedName("date")
    private String date;

    @SerializedName("gender")
    private String gender;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

    @SerializedName("cupo")
    private String cupo;

    @SerializedName("nivel")
    private String nivel;

    @SerializedName("categoria")
    private String categoria;

    public MatchData(String ownerName, Integer countOfPlayers, String time, String date, String gender,
                     String address, String city, String cupo, String category, String level) {
        this.setOwnerName(ownerName);
        this.setCountOfPlayers(countOfPlayers);
        this.setTime(time);
        this.setDate(date);
        this.setGender(gender);
        this.setAddress(address);
        this.setCity(city);
        this.setCupo(cupo);
        this.setCategory(category);
        this.setLevel(level);
    }

    public long getMatchId(){
        return matchId;
    }

    public void setOwnerName(String owner){
        this.ownerName = owner;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setCountOfPlayers(Integer count){
        this.countOfPlayers = count;
    }

    public Integer getCountOfPlayers() {
        return countOfPlayers;
    }

    public void setTime(String time){
        this.time = time;
    }

    public String getTime(){
        return time;
    }

    public void setDate(String date){
        this.date = date;
    }

    public String getDate(){
        return date;
    }

    public void setGender(String gender){
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getAddress(){
        return address;
    }

    public void setCupo(String cupo){
        this.cupo = cupo;
    }

    public String getCupo() {return cupo;}

    public void setCity(String city){
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCategory(String category){
        this.categoria = category;
    }

    public String getCategory() {
        return categoria;
    }

    public void setLevel(String level){
        this.nivel = level;
    }

    public String getLevel() {
        return nivel;
    }

}
