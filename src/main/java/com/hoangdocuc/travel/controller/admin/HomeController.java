package com.hoangdocuc.travel.controller.admin;

import com.hoangdocuc.travel.dto.PlaceDTO;
import com.hoangdocuc.travel.dto.MessageResponseDTO;
import com.hoangdocuc.travel.service.IPlaceService;
import com.hoangdocuc.travel.utils.AppUtils;
import com.hoangdocuc.travel.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.HashMap;

@Controller(value = "HomeControllerOfAdmin")
@RequestMapping("/admin")
public class HomeController {

    @Autowired
    private IPlaceService iPlaceService;

    @Autowired
    private MessageResponseDTO messageResponseDTO;

    @GetMapping(value = {"","/","home"})
    public String home(Model model, Principal principal){
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        String userInfo = WebUtils.toString(loginedUser);
        model.addAttribute("userInfo", userInfo);
        return "admin/index";
    }

    //go to template createPlace
    @GetMapping(value = {"/place/createPlace"})
    public String createPlace(){
        return "admin/PlaceCreate";
    }

    //create a news
    @PostMapping(value = {"/place/createPlace"})
    public String createPlaceNew(Model model, @RequestParam HashMap<String, String> reqParams,
                                 @RequestParam("place_image") MultipartFile image,
                                 RedirectAttributes redirectAttributes){

        //Get Param
        String place_name = reqParams.get("place_name");
        String place_title = reqParams.get("place_title");
        String place_content = reqParams.get("place_content");
        String place_image = image.getOriginalFilename();

        //Push from Params
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setName(place_name);
        placeDTO.setTitle(place_title);
        placeDTO.setContent(place_content);
        placeDTO.setImage(place_image);
        placeDTO.setViews(0);

        //save
        iPlaceService.save(placeDTO);

        //message
        messageResponseDTO.insertMessage(model,"Thêm thành công",AppUtils.successCode);
        return "admin/PlaceCreate";
    }


}
