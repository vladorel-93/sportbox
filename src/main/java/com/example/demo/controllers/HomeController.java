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
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
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
        String name = null;
        if (!file.isEmpty()){
            try{
                byte[] bytes = file.getBytes();
                name = file.getOriginalFilename();
                String rootPath = "C:\\Users\\1\\Desktop\\untitled4\\src\\main\\resources\\static\\images";
                File dir = new File(rootPath);
                File uploadedFile = new File(dir + File.separator + name);
                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);stream.flush();stream.close();
                team.setPhoto(name);
            }
            catch (IOException z){}
        }
        return "success";
    }

    @RequestMapping(value = "newTeam", method = RequestMethod.GET)
    public String addNewTeam(ModelMap modelMap){
        modelMap.put("team", new Team());
        return "new_team";
    }

   /* private String saveImage(MultipartFile file){
        try{
            byte[] bytes = file.getBytes();
            Path path = Paths.get(servletContext.getRealPath("/resources/images/" + file.getOriginalFilename()));
            Files.write(path, bytes);
            return file.getOriginalFilename();
        }
        catch (IOException e){return null;}
    }*/

    @Override
    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;
    }
}
