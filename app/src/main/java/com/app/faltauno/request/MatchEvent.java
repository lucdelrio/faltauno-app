package com.app.faltauno.request;

import com.app.faltauno.response.MatchDataAdapter;

/**
 * Created by lucas on 18/05/17.
 */
public class MatchEvent {
    private MatchDataAdapter matchDataAdapter;

    public MatchEvent(MatchDataAdapter serverResponse) {
        this.matchDataAdapter = serverResponse;
    }

    public MatchDataAdapter getServerResponse() {
        return matchDataAdapter;
    }

    public void setServerResponse(MatchDataAdapter matchDataAdapter) {
        this.matchDataAdapter = matchDataAdapter;
    }
}