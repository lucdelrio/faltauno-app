package com.app.faltauno.request;

import com.app.faltauno.response.MatchDataResponse;

/**
 * Created by lucas on 18/05/17.
 */
public class MatchEvent {
    private MatchDataResponse serverResponse;

    public MatchEvent(MatchDataResponse serverResponse) {
        this.serverResponse = serverResponse;
    }

    public MatchDataResponse getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(MatchDataResponse serverResponse) {
        this.serverResponse = serverResponse;
    }
}