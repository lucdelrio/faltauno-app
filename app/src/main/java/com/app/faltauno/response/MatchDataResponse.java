package com.app.faltauno.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchDataResponse{

    @SerializedName("match_id")
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

    public Integer getMatchId(){
        return matchId;
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
