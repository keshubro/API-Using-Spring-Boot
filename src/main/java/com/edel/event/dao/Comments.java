package com.edel.event.dao;

/**
 * Created by jitheshrajan on 4/19/18.
 */
public class Comments {

    public Comments() {
    }

    private String text;
    private long time;

    public Comments(String text, long time) {
        this.text = text;
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
