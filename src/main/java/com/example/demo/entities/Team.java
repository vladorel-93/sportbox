package com.example.demo.entities;

/**
 * Created by 1 on 01.06.2018.
 */
public class Team {
    private String name;
    private int currentPosition;
    private String photo;

    public Team() {
    }

    public Team(String name, int currentPosition, String photo) {
        this.name = name;
        this.currentPosition = currentPosition;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
