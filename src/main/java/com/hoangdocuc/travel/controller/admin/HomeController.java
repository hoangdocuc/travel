package com.hoangdocuc.travel.controller.admin;
import com.hoangdocuc.travel.utils.WebUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.security.Principal;

@Controller(value = "HomeControllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {

    @GetMapping(value = {"","/","home"})
    public String home(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "admin/index";
    }

}
