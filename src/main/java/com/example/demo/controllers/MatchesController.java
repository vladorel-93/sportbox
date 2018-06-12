package com.example.demo.controllers;

import com.example.demo.entities.Match;
import com.example.demo.util.HtmlParser;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
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
    public String showGames(HttpSession session, @RequestParam(value = "calendar")String date)
    {
        parser.setUrl(date);
        List<Match> matches = parser.getMatches();
        session.setAttribute("matches", matches);
        return "upcoming games";
    }

    @RequestMapping(value = "bets/{home}/{away}/{result}", method = RequestMethod.POST)
    public String personalBets(@RequestParam("home") String home,
                               @RequestParam("away")String away, @RequestParam("result")String result, ModelMap map){
        map.addAttribute("result", result);
        map.addAttribute("home", home);
        map.addAttribute("away", away);
        return "Personal bets";
    }
}
