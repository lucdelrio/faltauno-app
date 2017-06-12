package com.app.faltauno.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by lucas on 05/06/17.
 */

public class MatchDataAdapter {

    @SerializedName("match_id")
    private Long matchId;

    @SerializedName("ownerName")
    private String ownerName;

    @SerializedName("email")
    private String email;

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

    @SerializedName("quota")
    private String quota;

    @SerializedName("level")
    private String level;

    @SerializedName("category")
    private String category;

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
