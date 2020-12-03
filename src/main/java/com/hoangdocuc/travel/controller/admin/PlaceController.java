package com.hoangdocuc.travel.controller.admin;

import com.hoangdocuc.travel.dto.MessageResponseDTO;
import com.hoangdocuc.travel.dto.PlaceDTO;
import com.hoangdocuc.travel.service.IPlaceService;
import com.hoangdocuc.travel.utils.AppUtils;
import com.hoangdocuc.travel.utils.ReadFileAPOI;
import com.hoangdocuc.travel.utils.UploadFileImage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

@Controller(value = "PlaceControllerOfAdmin")
@RequestMapping("/admin")
public class PlaceController {

    @Autowired
    private IPlaceService iPlaceService;

    @Autowired
    private MessageResponseDTO messageResponseDTO;

    @Autowired
    private UploadFileImage uploadFileImage;

    @Autowired
    private ReadFileAPOI readFileAPOI;

    @Value("${path_config_examplefile}")
    private String path_config_examplefile;

    //go to template createPlace
    @GetMapping(value = {"/place/createPlace"})
    public String createPlace(){
        return "admin/PlaceCreate";
    }

    //create a news
    @PostMapping(value = {"/place/createPlace"})
    public String createPlaceNew(Model model, @RequestParam HashMap<String, String> reqParams,
                                 @RequestParam("place_image") MultipartFile image,
                                 @RequestParam("place_word") MultipartFile word){

        //Get Param
        String place_name = reqParams.get("place_name");
        String place_title = reqParams.get("place_title");
        String place_content = reqParams.get("place_content");
        String place_image = null;
        String place_word = null;

        //Read file word if exist
        if(!word.getOriginalFilename().equalsIgnoreCase("")){
            place_word = readFileAPOI.uploadImageWord(word);
            place_content = readFileAPOI.readWord(place_word);
        }
        if(!image.getOriginalFilename().equalsIgnoreCase("")) {
            place_image = uploadFileImage.uploadImageFile(image);
        }

        //Push from Params
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setName(place_name);
        placeDTO.setTitle(place_title);
        placeDTO.setContent(place_content);
        placeDTO.setFileword(place_word);
        placeDTO.setImage(place_image);
        placeDTO.setViews(0);

        //save
        iPlaceService.save(placeDTO);

        //message
        messageResponseDTO.insertMessage(model,"Thêm thành công", AppUtils.successCode);
        return "admin/PlaceCreate";
    }

    //go to template updatePlace
    @GetMapping(value = {"/place/updatePlace/{id}"})
    public String updatePlace(Model model, @PathVariable("id")Long id){
        PlaceDTO placeDTO = iPlaceService.findById(id);
        model.addAttribute("placeObject",placeDTO);
        return "admin/PlaceUpdate";
    }

    //update a news
    @PostMapping(value = {"/place/updatePlace"})
    public String updatePlaceNew(Model model, @RequestParam HashMap<String, String> reqParams,
                                 @RequestParam("place_image") MultipartFile image,
                                 @RequestParam("place_word") MultipartFile word){

        //Get Param
        String place_id = reqParams.get("place_id");
        String place_name = reqParams.get("place_name");
        String place_title = reqParams.get("place_title");
        String place_content = reqParams.get("place_content");
        String place_image = null;
        String place_word = null;

        //Read file word if exist
        if(!word.getOriginalFilename().equalsIgnoreCase("")){
            place_word = readFileAPOI.uploadImageWord(word);
            place_content = readFileAPOI.readWord(place_word);
        }
        if(!image.getOriginalFilename().equalsIgnoreCase("")) {
            place_image = uploadFileImage.uploadImageFile(image);
        }

        //Push from Params
        PlaceDTO placeDTO = new PlaceDTO();
        placeDTO.setId(Long.parseLong(place_id));
        placeDTO.setName(place_name);
        placeDTO.setTitle(place_title);
        placeDTO.setContent(place_content);
        placeDTO.setFileword(place_word);
        placeDTO.setImage(place_image);
        placeDTO.setViews(0);

        //save
        iPlaceService.save(placeDTO);

        //message
        messageResponseDTO.insertMessage(model,"Thêm thành công", AppUtils.successCode);
        return "admin/PlaceCreate";
    }

    //downdload file example
    @GetMapping("/place/downloadFile")
    public ResponseEntity<Object> downloadFile() throws IOException {
        String filename = path_config_examplefile;
        File file = new File(filename);
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
        HttpHeaders headers = new HttpHeaders();

        headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");

        ResponseEntity<Object>
                responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(
                MediaType.parseMediaType("application/txt")).body(resource);

        return responseEntity;
    }



}
