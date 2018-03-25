package com.collekarry.hackthon;

/**
 * Created by Chell on 24-03-2018.
 */

public class Store {

    String id;
    String councilName;
    String eventName;
    String rate;
    String dsrip;
    String status;

    public Store(){

    }

    public Store(String id, String councilName, String eventName,String rate , String dsrip , String status) {
        this.id = id;
        this.councilName = councilName;
        this.eventName = eventName;
        this.rate = rate;
        this.dsrip = dsrip;
        this.status = status;
    }


    public String getId() {
        return id;
    }

    public String getCouncilName() {
        return councilName;
    }

    public String getEventName() {
        return eventName;
    }

    public String getRate() {
        return rate;
    }

    public String getDsrip() {
        return dsrip;
    }

    public String getStatus() {
        return status;
    }
}

