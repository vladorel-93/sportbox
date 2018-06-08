package com.example.demo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by 1 on 07.06.2018.
 */
@Entity
@Table(name = "Match")
public class Match {

    @Column
    private int idHomeTeam;

    private String homeTeam;

    @Column
    private int idAwayTeam;

    private String awayTeam;

    @Column
    private LocalDateTime Date_Time;

    public Match(String homeTeam, String awayTeam, LocalDateTime date_Time){
        this.awayTeam = awayTeam; this.homeTeam = homeTeam; Date_Time = date_Time;
    }

    public Match(int idHomeTeam, int idAwayTeam, LocalDateTime date_Time) {
        this.idHomeTeam = idHomeTeam;
        this.idAwayTeam = idAwayTeam;
        Date_Time = date_Time;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setIdHomeTeam(int idHomeTeam) {
        this.idHomeTeam = idHomeTeam;
    }

    public void setIdAwayTeam(int idAwayTeam) {
        this.idAwayTeam = idAwayTeam;
    }

    public void setDate_Time(LocalDateTime date_Time) {
        Date_Time = date_Time;
    }

    public int getIdHomeTeam() {
        return idHomeTeam;
    }

    public int getIdAwayTeam() {
        return idAwayTeam;
    }

    public LocalDateTime getDate_Time() {
        return Date_Time;
    }
}