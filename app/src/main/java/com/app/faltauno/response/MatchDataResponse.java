package com.app.faltauno.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas on 05/06/17.
 */

public class MatchDataResponse {

    @SerializedName("matchId")
    @Expose
    private Long matchId;

    @SerializedName("ownerName")
    @Expose
    private String ownerName;

    @SerializedName("countOfPlayers")
    @Expose
    private Integer countOfPlayers;

    @SerializedName("time")
    @Expose
    private String time;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("gender")
    @Expose
    private String gender;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("city")
    @Expose
    private String city;


    public long getMatchId(){
        return matchId;
    }

    public void setMatchId(long id){
        this.matchId = id;
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

    public void setCity(String city){
        this.city = city;
    }

    public String getCity() {
        return city;
    }
}
