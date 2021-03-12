package com.example.testapp.adapter;

public class ListItem {
    private String text;
    private int imageId;
    private boolean favorite;

    public void setText(String text) {
        this.text = text;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public String getText() {
        return text;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public boolean isFavorite() {
        return favorite;
    }
}
