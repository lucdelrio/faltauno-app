package com.app.faltauno.entity;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by lucas on 15/05/17.
 */

public class Match {

    private long matchId;
    private String ownerName;
    private Integer countOfPlayers;
    private Date time;
    private Date date;
    private String gender;
    private String address;
    private String city;

    public Match(long matchId, String ownerName, Integer countOfPlayers, Date time, Date date, String gender, String address, String city) {
        this.setMatchId(matchId);
        this.setOwnerName(ownerName);
        this.setCountOfPlayers(countOfPlayers);
        this.setTime(time);
        this.setDate(date);
        this.setGender(gender);
        this.setAddress(address);
        this.setCity(city);
    }

    public void setMatchId(long matchId){
        this.matchId = matchId;
    }

    public long getMatchId(){
        return this.matchId;
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

    public void setTime(Date time){
        this.time = time;
    }

    public Date getTime(){
        return time;
    }

    public void setDate(Date date){
        this.date = date;
    }

    public Date getDate(){
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
