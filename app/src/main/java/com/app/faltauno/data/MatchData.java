package com.app.faltauno.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchData {

    @SerializedName("match_id")
    @Expose
    private Integer matchId;

    @SerializedName("owner_name")
    private String ownerName;

    @SerializedName("count_of_players")
    private String countOfPlayers;

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

    public void setMatchId(Integer id){
        this.matchId = id;
    }

    public Integer getMatchId(){
        return matchId;
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

    @Override
    public String toString() {
        return "MatchData{" +
                "matchId='" + matchId + '\'' +
                ", ownerName='" + ownerName + '\'' +
                ", countOfPlayers=" + countOfPlayers +
                ", time=" + time +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", city=" + city +
                '}';
    }

}
