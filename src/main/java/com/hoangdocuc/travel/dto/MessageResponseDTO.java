package com.hoangdocuc.travel.dto;

import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

@Component
public class MessageResponseDTO {

    public void insertMessage(Model model,String message,Integer code){
        model.addAttribute("code",code);
        model.addAttribute("message",message);
    }

}
