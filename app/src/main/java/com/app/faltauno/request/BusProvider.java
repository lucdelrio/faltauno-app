package com.app.faltauno.request;

import com.squareup.otto.Bus;

/**
 * Created by lucas on 18/05/17.
 */


public class BusProvider {

    private static final Bus BUS = new Bus();

    public static Bus getInstance(){
        return BUS;
    }

    public BusProvider(){}
}