package com.example.demo.util;

import com.example.demo.entities.Match;
import com.example.demo.entities.Team;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by 1 on 07.06.2018.
 */
@Component
public class HtmlParser {

    private String url = "";

    public HtmlParser() {
    }

    public List<Match> getMatches() {
        Document document;
        List<Match> matches = new ArrayList<>();
        try {
            document = Jsoup.connect(url).get();
            Element onlyFootball = document.getElementById("sport_1");
            Elements spans = onlyFootball.getElementsByTag("span");
            matches = convertSpanToMatches(spans);
            String fake ="";
        } catch (IOException z) {
        }
        return matches;
    }

    private List<Match> convertSpanToMatches(Elements elements){
        List<Match> matches = new ArrayList<>();
        List<String> teams = new ArrayList<>();
        for (Element element : elements){
            if (!element.html().matches("\\d.+") && !element.html().matches("Футбол") && !element.html().matches("") && element.html().length() > 2)
                teams.add(element.html());
        }
        String d = "";
        for (int i= 0; i < teams.size(); i+= 2)
        {
            String date = url.substring(url.length() - 10);
            matches.add(new Match(teams.get(i), teams.get(i++), LocalDate.parse(date).toEpochDay()));
        }
        return matches;
    }

    public void setUrl(String url) {
        this.url = "https://news.sportbox.ru/stats/" + url;
    }
}