package com.mycompany.myweb.dto;

/**
 * Created by Administrator on 2016-11-11.
 */

public class Light {
    private String image;
    private String imageLarge;
    private String title;
    private String content;

    public Light(){}

	public Light(String image, String imageLarge, String title, String content) {
		this.image = image;
		this.imageLarge = imageLarge;
		this.title = title;
		this.content = content;
	}



	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getImageLarge() {
		return imageLarge;
	}

	public void setImageLarge(String imageLarge) {
		this.imageLarge = imageLarge;
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
