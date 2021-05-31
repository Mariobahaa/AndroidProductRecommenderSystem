package com.example.recomendationsystem.Model.Recomendations;

import android.net.Uri;

public class recomend {
    String tittle;
    String rate;
    String price;
    Uri photo;

    public recomend(String tittle, String rate, String price, String photo) {
        this.tittle = tittle;
        this.rate = rate;
        this.price = price;
        Uri builtUri = Uri.parse(photo)
                .buildUpon()
                .build();
        this.photo = builtUri;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Uri getPhoto() {
        return photo;
    }

    public void setPhoto(Uri photo) {
        this.photo = photo;
    }
}
