package com.example.demo.repository;

import com.example.demo.entities.Team;

import java.util.List;

/**
 * Created by 1 on 04.06.2018.
 */
public interface TeamRepository {
    void addTeam(Team team);
    List<Team> getTeams();
}
