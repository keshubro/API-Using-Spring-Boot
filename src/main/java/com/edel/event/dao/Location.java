package com.edel.event.dao;

/**
 * Created by jitheshrajan on 4/19/18.
 */
public class Location {

    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Location(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public Location() {
    }
}
