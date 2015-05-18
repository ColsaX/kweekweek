package com.imp.emag.kweekweek.model;

/**
 * Created by tzury on 18/05/15.
 */
public class OneEvent {
    private String img;
    private String title;
    private String price;
    private String date;
    private String place;
    private String reason;


    public OneEvent(String img, String title, String price, String date, String place, String reason) {
        this.img = img;
        this.title = title;
        this.price = price;
        this.date = date;
        this.place = place;
        this.reason = reason;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
