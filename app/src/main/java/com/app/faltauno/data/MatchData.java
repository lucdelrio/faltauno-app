package com.app.faltauno.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class MatchData {

    @SerializedName("owner_name")
    private String ownerName;

    @SerializedName("count_of_players")
    private Integer countOfPlayers;

    @SerializedName("time")
    private Date time;

    @SerializedName("date")
    private Date date;

    @SerializedName("gender")
    private String gender;

    @SerializedName("address")
    private String address;

    @SerializedName("city")
    private String city;

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

    @Override
    public String toString() {
        return "MatchData{" +
                "  owner_name='" + ownerName + '\'' +
                ", count_of_players=" + countOfPlayers +
                ", time=" + time +
                ", date='" + date + '\'' +
                ", gender='" + gender + '\'' +
                ", address=" + address +
                ", city=" + city +
                '}';
    }

}
