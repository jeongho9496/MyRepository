package com.example.administrator.myapplication;

/**
 * Created by kimjeongho on 2016-11-14.
 */

public class Bistro {
    private int image;
    private int imageLarge;
    private String title;
    private String price;
    private String content;

    public Bistro(){}

    public Bistro(int image, int imageLarge ,String title, String price, String content) {
        this.image = image;
        this.imageLarge = imageLarge;
        this.title = title;
        this.price = price;
        this.content = content;
    }

    public int getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(int imageLarge) {
        this.imageLarge = imageLarge;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
