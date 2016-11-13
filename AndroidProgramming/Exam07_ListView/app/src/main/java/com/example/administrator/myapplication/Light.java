package com.example.administrator.myapplication;

/**
 * Created by Administrator on 2016-11-11.
 */

public class Light {
    private int Image;
    private String title;
    private String content;

    public void Light(){}

    public Light(int image, String title, String content) {
        this.Image = image;
        this.title = title;
        this.content = content;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
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
