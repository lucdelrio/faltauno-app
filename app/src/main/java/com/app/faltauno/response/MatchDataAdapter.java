package com.app.faltauno.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas on 05/06/17.
 */

public class MatchDataAdapter {

    private Long matchId;

    private String ownerName;

    private String email;

    private Integer countOfPlayers;

    private String time;

    private String date;

    private String gender;

    private String address;

    private String city;

    private String level;

    private String category;

    private String quota;

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

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevel(){
        return level;
    }

    public void setQuota(String quota) {
        this.quota = quota;
    }

    public String getQuota(){
        return quota;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }
}
