package com.app.faltauno.response;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class MatchDataResponse{

    @SerializedName("match_id")
    private Integer matchId;

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

    public long getMatchId(){
        return matchId;
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
