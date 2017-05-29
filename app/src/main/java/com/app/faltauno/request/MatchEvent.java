package com.app.faltauno.request;

import com.app.faltauno.response.MatchData;

/**
 * Created by lucas on 18/05/17.
 */
public class MatchEvent {
    private MatchData serverResponse;

    public MatchEvent(MatchData serverResponse) {
        this.serverResponse = serverResponse;
    }

    public MatchData getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(MatchData serverResponse) {
        this.serverResponse = serverResponse;
    }
}