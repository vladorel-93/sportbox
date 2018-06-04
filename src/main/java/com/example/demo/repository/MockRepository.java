package com.example.demo.repository;

import com.example.demo.entities.Team;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 04.06.2018.
 */
@Repository
public class MockRepository implements TeamRepository{
    private List<Team> teams = new ArrayList<>();

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public List<Team> getTeams() {
        return teams;
    }
}
