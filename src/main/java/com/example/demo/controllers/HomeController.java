package com.example.demo.controllers;

import com.example.demo.entities.Team;
import com.example.demo.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * Created by 1 on 31.05.2018.
 */
@Controller
@RequestMapping(value = "/")
public class HomeController implements ServletContextAware{

    private ServletContext servletContext;

    @Autowired
    private TeamRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public String index(ModelMap map){
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
                team.setPhoto(rootPath + File.separator + name);
            }
            catch (IOException z){}
        }
        repository.save(team);
        return "success";
    }

    @RequestMapping(value = "newTeam", method = RequestMethod.GET)
    public String addNewTeam(ModelMap modelMap){
        modelMap.put("team", new Team());
        return "new_team";
    }

    @Override
    public void setServletContext(ServletContext servletContext){
        this.servletContext = servletContext;
    }
}
