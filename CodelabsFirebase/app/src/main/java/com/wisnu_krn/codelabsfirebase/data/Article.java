package com.wisnu_krn.codelabsfirebase.data;

/**
 * Created by private on 05/11/2016.
 */

public class Article {
    private String URL;
    private String title;
    private String image;

    public Article(String URL, String title, String image) {
        this.URL = URL;
        this.title = title;
        this.image = image;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
