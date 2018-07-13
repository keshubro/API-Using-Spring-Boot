package com.edel.event.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jitheshrajan on 4/19/18.
 */
@Document(collection = "JHotels")
public class JHotel {

    @Id
    private String id;
    private String name;
    @Indexed(direction = IndexDirection.ASCENDING)
    private int pricePerNight;
    private Location location;
    private List<Comments> comments;

    protected JHotel() {
        this.comments = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPricePerNight() {
        return pricePerNight;
    }

    public Location getLocation() {
        return location;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public JHotel(String name, int pricePerNight, Location location, List<Comments> comments) {
        this.name = name;
        this.pricePerNight = pricePerNight;
        this.location = location;
        this.comments = comments;
    }


}
