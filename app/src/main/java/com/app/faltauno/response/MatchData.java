package com.app.faltauno.response;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MatchData implements Serializable {

    @SerializedName("match_id")
    private Integer matchId;

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

    public MatchData(String ownerName, String email, Integer countOfPlayers, String time, String date, String gender,
                     String address, String city, String level, String category, String quota) {
        this.setOwnerName(ownerName);
        this.setEmail(email);
        this.setCountOfPlayers(countOfPlayers);
        this.setTime(time);
        this.setDate(date);
        this.setGender(gender);
        this.setAddress(address);
        this.setCity(city);
        this.setCategory(category);
        this.setLevel(level);
        this.setQuota(quota);
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

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory(){
        return category;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity(){
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
}
