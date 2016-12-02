package com.example.administrator.a2cmfinal.dto;

import android.graphics.Bitmap;

/**
 * Created by kimjeongho on 2016-11-27.
 */

public class Menu {
    private int mid;
    private String mgroup;
    private String mname;
    private String hot_ice;
    private int mprice;
    private String mcontents;
    private String msavedfile;
    private String sid;
    private Bitmap image;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getMgroup() {
        return mgroup;
    }

    public void setMgroup(String mgroup) {
        this.mgroup = mgroup;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getHot_ice() {
        return hot_ice;
    }

    public void setHot_ice(String hot_ice) {
        this.hot_ice = hot_ice;
    }

    public int getMprice() {
        return mprice;
    }

    public void setMprice(int mprice) {
        this.mprice = mprice;
    }

    public String getMcontents() {
        return mcontents;
    }

    public void setMcontents(String mcontents) {
        this.mcontents = mcontents;
    }

    public String getMsavedfile() {
        return msavedfile;
    }

    public void setMsavedfile(String msavedfile) {
        this.msavedfile = msavedfile;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
