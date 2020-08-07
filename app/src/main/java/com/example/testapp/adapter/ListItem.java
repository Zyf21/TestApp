package com.example.testapp.adapter;

public class ListItem {
    private String text;
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

    public boolean isFavorite() {
        return favorite;
    }
}
