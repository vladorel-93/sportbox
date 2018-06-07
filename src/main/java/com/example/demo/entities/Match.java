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

    private Team HomeTeam;

    private Team AwayTeam;

    @Column
    private LocalDateTime Date_Time;

    public Match(Team homeTeam, Team awayTeam, LocalDateTime date_Time) {
        HomeTeam = homeTeam;
        AwayTeam = awayTeam;
        Date_Time = date_Time;
    }

    public void setHomeTeam(Team homeTeam) {
        HomeTeam = homeTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        AwayTeam = awayTeam;
    }

    public void setDate_Time(LocalDateTime date_Time) {
        Date_Time = date_Time;
    }

    public Team getHomeTeam() {
        return HomeTeam;
    }

    public Team getAwayTeam() {
        return AwayTeam;
    }

    public LocalDateTime getDate_Time() {
        return Date_Time;
    }
}
