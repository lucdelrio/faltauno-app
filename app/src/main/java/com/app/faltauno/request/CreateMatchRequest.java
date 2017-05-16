package com.app.faltauno.request;

import java.util.Date;

public class CreateMatchRequest {

    private String ownerName;
    private Integer countOfPlayers;
    private Date time;
    private Date date;
    private String gender;
    private String address;
    private String city;

    public CreateMatchRequest(String ownerName, Integer countOfPlayers, Date time, Date date, String gender, String address, String city) {
        this.ownerName = ownerName;
        this.countOfPlayers = countOfPlayers;
        this.time = time;
        this.date = date;
        this.gender = gender;
        this.address = address;
        this.city = city;
    }

    public String getOwnerName(){
        return ownerName;
    }

    public Integer getCountOfPlayers() {
        return countOfPlayers;
    }

    public Date getTime(){
        return time;
    }

    public Date getDate(){
        return date;
    }

    public String getGender(){
        return gender;
    }

    public String getAddress(){
        return address;
    }

    public String getCity() {
        return city;
    }
}
