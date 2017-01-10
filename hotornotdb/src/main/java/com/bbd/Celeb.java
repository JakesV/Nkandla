package com.bbd;

/**
 * Created by bbdnet1523 on 2016/12/09.
 */
public class Celeb {

    int rating;
    String URL;
    String Name;
    String Surname;

    public Celeb(int rating, String URL, String name, String surname) {
        this.rating = rating;
        this.URL = URL;
        Name = name;
        Surname = surname;
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

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }
}
