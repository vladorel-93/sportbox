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
    private String data;

    @Column
    private String result;

    public Match(String homeTeam, String awayTeam, String date_Time){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;;
        this.data = date_Time;
    }

    public Match(String homeTeam, String awayTeam, String bet, String date_Time) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.bet = bet;
        data = date_Time;
    }

    public Match(){}

    public void setId(int id) {
        this.id = id;
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


    public void setResult(String result) {
        this.result = result;
    }

    public int getId() {
        return id;
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

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public String getResult() {
        return result;
    }
}