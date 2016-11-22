package com.example.administrator.a2cmbeacontest;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016-11-21.
 */

public class StoreEvent {
    private int bmajor;
    private Date estartperiod;
    private Date elastperiod;
    private List<String> etitle;
    private String econtents;
    private String esavedfile;
    private String emimetype;
    private String sid;
    private int mid;

    public int getBmajor() {
        return bmajor;
    }

    public void setBmajor(int bmajor) {
        this.bmajor = bmajor;
    }

    public Date getEstartperiod() {
        return estartperiod;
    }

    public void setEstartperiod(Date estartperiod) {
        this.estartperiod = estartperiod;
    }

    public Date getElastperiod() {
        return elastperiod;
    }

    public void setElastperiod(Date elastperiod) {
        this.elastperiod = elastperiod;
    }

    public List<String> getEtitle() {
        return etitle;
    }

    public void setEtitle(List<String> etitle) {
        this.etitle = etitle;
    }

    public String getEcontents() {
        return econtents;
    }

    public void setEcontents(String econtents) {
        this.econtents = econtents;
    }

    public String getEsavedfile() {
        return esavedfile;
    }

    public void setEsavedfile(String esavedfile) {
        this.esavedfile = esavedfile;
    }

    public String getEmimetype() {
        return emimetype;
    }

    public void setEmimetype(String emimetype) {
        this.emimetype = emimetype;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }
}
