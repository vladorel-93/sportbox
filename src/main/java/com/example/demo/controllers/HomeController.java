package com.example.demo.controllers;

import com.example.demo.entities.Team;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 31.05.2018.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController implements ServletContextAware{

    private ServletContext servletContext;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
        /*List<Team> teams = new ArrayList<>();
        teams.add(new Team("Arsenal", 5, "Arsenal.jpg"));
        teams.add(new Team("Leicester", 9, "Leicester.png"));
        teams.add(new Team("Manchester United", 2, "Manki.jpg"));
        teams.add(new Team("Tottenham", 4, "tot.png"));
        teams.add(new Team("Chelsea", 10, "Chelsea.jpg"));
        teams.add(new Team("Liverpool", 3, "Liverpool.jpg"));
        */
        //map.put("team", new Team());
        return "index";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(@ModelAttribute("team") Team team, @RequestParam(value = "file")MultipartFile file, ModelMap modelMap){
        String fileName = saveImage(file);
        team.setPhoto(fileName);
        modelMap.put("team", team);
        return "success";
    }

    @RequestMapping(value = "newTeam", method = RequestMethod.GET)
    public String addNewTeam(ModelMap modelMap){
        modelMap.put("team", new Team());
        return "new_team";
    }

    private String saveImage(MultipartFile file){
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/resources/images/" + file.getOriginalFilename()));
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        catch (IOException e){return null;}
    }

    @Override
    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;
    }
}
