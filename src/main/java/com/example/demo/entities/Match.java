package com.example.demo.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by 1 on 07.06.2018.
 */
@Entity
@Table(name = "Matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String homeTeam;

    @Column
    private String awayTeam;

    @Column
    private String bet;

    @Column
    private Long Date_Time;

    public Match(String homeTeam, String awayTeam, String bet, Long date_Time) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.bet = bet;
        Date_Time = date_Time;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public void setDate_Time(Long date_Time) {
        Date_Time = date_Time;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getBet() {
        return bet;
    }

    public Long getDate_Time() {
        return Date_Time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}