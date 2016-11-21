package com.example.blueskii.myapplication;

import java.util.List;

public class StoreEvent {
    private int bminor;
    private int sid;
    private String sname;
    private List<String> events;

    public int getBminor() {
        return bminor;
    }

    public void setBminor(int bminor) {
        this.bminor = bminor;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public List<String> getEvents() {
        return events;
    }

    public void setEvents(List<String> events) {
        this.events = events;
    }
}


