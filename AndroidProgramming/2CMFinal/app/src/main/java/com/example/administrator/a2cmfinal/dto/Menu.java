package com.example.administrator.a2cmfinal.dto;

import android.graphics.Bitmap;

import java.io.Serializable;

/**
 * Created by kimjeongho on 2016-11-27.
 */

public class Menu  {
    private int mid;
    private String mgroup;
    private String mname;
    private String hot_ice;
    private int mprice;
    private String mcontents;
    private String msavedfile;
    private String sid;
    private Bitmap image;
    /*private String syrup;
    private String size;
    private String shot;
    private int sizePrice;
    private int syrupPrice;
    private int shotPrice;*/

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

    /*public String getSyrup() {
        return syrup;
    }

    public void setSyrup(String syrup) {
        this.syrup = syrup;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getShot() {
        return shot;
    }

    public void setShot(String shot) {
        this.shot = shot;
    }

    public int getSizePrice() {
        return sizePrice;
    }

    public void setSizePrice(int sizePrice) {
        this.sizePrice = sizePrice;
    }

    public int getSyrupPrice() {
        return syrupPrice;
    }

    public void setSyrupPrice(int syrupPrice) {
        this.syrupPrice = syrupPrice;
    }

    public int getShotPrice() {
        return shotPrice;
    }

    public void setShotPrice(int shotPrice) {
        this.shotPrice = shotPrice;
    }*/
}
