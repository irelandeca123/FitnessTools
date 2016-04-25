package com.gnirt69.FitnessTools;

/**
 * Created by Stoyan Rizov
 */
public class User {

    private String day;
    private String bench;
    private String squats;

    public User() {
        // empty default constructor, necessary for Firebase to be able to deserialize blog posts
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getDay() {
        return day;
    }

    public void setBench(String bench) {
        this.bench = bench;
    }

    public String getBench() {
        return bench;
    }

    public void setSquats(String squats) {
        this.squats = squats;
    }

    public String getSquats() {
        return squats;
    }



}

