package com.app.faltauno.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas on 15/05/17.
 */

public class Match {

    private Integer matchId;
    private String ownerName;
    private String countOfPlayers;
    private String time;
    private String date;
    private String gender;
    private String address;
    private String city;

    public Match(Integer matchId, String ownerName, String countOfPlayers, String time, String date, String gender, String address, String city) {
        this.setMatchId(matchId);
        this.setOwnerName(ownerName);
        this.setCountOfPlayers(countOfPlayers);
        this.setTime(time);
        this.setDate(date);
        this.setGender(gender);
        this.setAddress(address);
        this.setCity(city);
    }

    public void setMatchId(Integer matchId){
        this.matchId = matchId;
    }

    public int getMatchId(){
        return this.matchId;
    }

    public void setOwnerName(String owner){
        this.ownerName = owner;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setCountOfPlayers(String count){
        this.countOfPlayers = count;
    }

    public String getCountOfPlayers() {
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
