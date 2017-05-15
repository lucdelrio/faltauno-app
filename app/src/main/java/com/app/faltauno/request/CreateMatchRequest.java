package com.app.faltauno.request;

public class CreateMatchRequest {

    private String ownerName;
    private String countOfPlayers;
    private String time;
    private String date;
    private String gender;
    private String address;
    private String city;

    public CreateMatchRequest(String ownerName, String countOfPlayers, String time, String date, String gender, String address, String city) {
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

    public String getCountOfPlayers() {
        return countOfPlayers;
    }

    public String getTime(){
        return time;
    }

    public String getDate(){
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
