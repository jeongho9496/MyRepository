package com.example.administrator.myapplication;

import android.graphics.Bitmap;

/**
 * Created by kimjeongho on 2016-11-14.
 */

public class Bistro {
    private Bitmap image;
    private Bitmap imageLarge;

    private String imageFileName;
    private String imageLargeFileName;

    private String title;
    private String price;
    private String content;

    public Bistro(){}

    public Bistro(Bitmap image, Bitmap imageLarge ,String title, String price, String content) {
        this.image = image;
        this.imageLarge = imageLarge;
        this.title = title;
        this.price = price;
        this.content = content;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public Bitmap getImageLarge() {
        return imageLarge;
    }

    public void setImageLarge(Bitmap imageLarge) {
        this.imageLarge = imageLarge;
    }

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
