package com.app.faltauno.request;

import com.app.faltauno.response.MatchData;
import com.app.faltauno.response.MatchDataResponse;

/**
 * Created by lucas on 18/05/17.
 */
public class MatchEvent {
    private MatchDataResponse matchDataResponse;

    public MatchEvent(MatchDataResponse serverResponse) {
        this.matchDataResponse = serverResponse;
    }

    public MatchDataResponse getServerResponse() {
        return matchDataResponse;
    }

    public void setServerResponse(MatchDataResponse matchDataResponse) {
        this.matchDataResponse = matchDataResponse;
    }
}