package com.hoangdocuc.travel.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Component
public class UploadFileImage {

    public String path;

    public String Time() {
        String time = String.valueOf(System.currentTimeMillis());
        return time;
    }

    @Value("${path_config_image}")
    private String pathConfigImage;

    public String uploadImageFile(MultipartFile fileImage){
        File dir = new File(pathConfigImage);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        path =  Time() + "_" + fileImage.getOriginalFilename();
        Path pathImage = Paths.get(pathConfigImage + path);
        try {
            Files.copy(fileImage.getInputStream(), pathImage, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception ex) {
            System.out.println("Error :::: lỗi lưu ảnh "+ex.getMessage());
        }
        return pathImage.toString();
    }


}
