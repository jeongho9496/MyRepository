package com.example.administrator.a2cmfinal.dto;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016-11-21.
 */

public class Sphoto {
    private int spic_id;			//sphoto id(시퀀스)
    private String spic_savedfile;	//매장 사진 세이브 파일
    private Bitmap sphoto;
    private String sid;				//매장 아이디(시퀀스)

    public Bitmap getSphoto() {
        return sphoto;
    }

    public void setSphoto(Bitmap sphoto) {
        this.sphoto = sphoto;
    }

    public int getSpic_id() {
        return spic_id;
    }

    public void setSpic_id(int spic_id) {
        this.spic_id = spic_id;
    }

    public String getSpic_savedfile() {
        return spic_savedfile;
    }

    public void setSpic_savedfile(String spic_savedfile) {
        this.spic_savedfile = spic_savedfile;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }
}
