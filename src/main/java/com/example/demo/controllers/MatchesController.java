package com.example.demo.controllers;

import com.example.demo.entities.Match;
import com.example.demo.parser.HtmlParser;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 07.06.2018.
 */
@Controller
@RequestMapping(value = "/")
public class MatchesController {

    @Autowired
    TeamRepository repository;

    @Autowired
    HtmlParser parser;

    @RequestMapping(value = "show_upcoming_games", method = RequestMethod.GET)
    public String showGames(HttpSession session)
    {
        List<Match> matches = parser.getMatches();
        session.setAttribute("matches", matches);
        return "upcoming games";
    }

    @RequestMapping(value = "bets", method = RequestMethod.POST)
    public String saveBets(Object[] bets)
    {
        return "";
    }
}
