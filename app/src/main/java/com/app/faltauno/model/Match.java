package com.app.faltauno.model;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Date;

/**
 * Created by lucas on 07/05/17.
 */

public class Match {

    private String matchId;
    private String ownerName;
    private int countOfPlayers;
    private int schedule;
    private Date date;
    private String gender;
    private String address;
    private String city;

    public Match(String matchId, String ownerName, int countOfPlayers, int schedule, Date date, String gender, String address, String city){
        this.setMatchId(matchId);
        this.setOwnerName(ownerName);
        this.setCountOfPlayers(countOfPlayers);
        this.setSchedule(schedule);
        this.setDate(date);
        this.setGender(gender);
        this.setAddress(address);
        this.setCity(city);
    }

    public void setMatchId(String matchId){
        this.matchId = matchId;
    }

    public String getMatchId(){
        return this.matchId;
    }

    public void setOwnerName(String owner){
        this.ownerName = owner;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public void setCountOfPlayers(int count){
        this.countOfPlayers = count;
    }

    public int getCountOfPlayers() {
        return countOfPlayers;
    }

    public void setSchedule(int schedule){
        this.schedule = schedule;
    }

    public int getSchedule(){
        return schedule;
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
