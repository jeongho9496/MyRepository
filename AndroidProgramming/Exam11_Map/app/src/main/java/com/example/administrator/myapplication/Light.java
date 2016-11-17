package com.example.administrator.myapplication;

import android.graphics.Bitmap;

/**
 * Created by Administrator on 2016-11-11.
 */

public class Light {
    private Bitmap image;   //bitmap 그림의 객체
    private Bitmap imageLarge;
    private String imageFileName;   //그림파일에 대한 문자 저장
    private String imageLargeFileName;//그림파일에 대한 문자 저장

    private String title;
    private String content;

    public Light(){}

    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    public String getImageLargeFileName() {
        return imageLargeFileName;
    }

    public void setImageLargeFileName(String imageLargeFileName) {
        this.imageLargeFileName = imageLargeFileName;
    }

    public Bitmap getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(Bitmap imageLarge) {
        this.imageLarge = imageLarge;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
