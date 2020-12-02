package com.hoangdocuc.travel.controller.web;

import com.hoangdocuc.travel.dto.PlaceDTO;
import com.hoangdocuc.travel.service.IPlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller(value = "HomeControllerOfWeb")
public class HomeController {

    @Autowired
    private IPlaceService iPlaceService;

    @GetMapping(value = {"/home","/"})
    public String index(Model model){
        return "web/index";
    }
    @GetMapping("/about")
    public String about(Model model){
        return "web/about";
    }
    @GetMapping("/blog")
    public String blog(Model model){
        return "web/blog";
    }
    @GetMapping("/contact")
    public String contact(Model model){
        return "web/contact";
    }
    @GetMapping("/post-details")
    public String postdetails(Model model){
        return "web/post-details";
    }

}
