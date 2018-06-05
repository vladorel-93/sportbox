package com.example.demo.entities;

import javax.persistence.*;

/**
 * Created by 1 on 01.06.2018.
 */
@Entity
@Table(name = "teams")
public class Team {

    @Column
    private String name;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String photo;

    public Team() {
    }

    public Team(String name, int currentPosition, String photo) {
        this.name = name;
        this.id = currentPosition;
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
