package com.bbd;

/**
 * Created by bbdnet1523 on 2016/12/09.
 */
public class Cars {

    int rating;
    String URL;
    String Model;
    String Make;

    public Cars(int rating, String URL, String model, String make) {
        this.rating = rating;
        this.URL = URL;
        Model = model;
        Make = make;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }
}
