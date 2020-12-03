package com.hoangdocuc.travel.utils;

import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Component
public class ReadFileAPOI {
    public String path;

    @Value("${path_config_word}")
    private String pathConfigWord;

    public String Time() {
        String time = String.valueOf(System.currentTimeMillis());
        return time;
    }

    public String uploadImageWord(MultipartFile fileWord){
        File dir = new File(pathConfigWord);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        path =  Time() + "_" + fileWord.getOriginalFilename();
        Path pathWord = Paths.get(pathConfigWord + path);
        try {
            Files.copy(fileWord.getInputStream(), pathWord, StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception ex) {
            System.out.println("Error :::: lỗi lưu ảnh "+ex.getMessage());
        }
        return pathWord.toString();
    }

    public String readWord(String pathFileWord) {
        String content = null;
        try {
            FileInputStream fis = new FileInputStream(pathFileWord);
            XWPFDocument document = new XWPFDocument(OPCPackage.open(fis));
            List<XWPFParagraph> paragraphList = document.getParagraphs();
            System.out.println("==============================");
            System.out.println("Read file using XWPFWordExtractor ");
            XWPFWordExtractor wordExtractor = new XWPFWordExtractor(document);
            content = wordExtractor.getText();
            wordExtractor.close();
            document.close();
            System.out.println("Read file using XWPFWordExtractor success");
        } catch (Exception ex){
            System.out.println("Error ::: lỗi đọc file Word "+ex.getMessage());
        }
        return content;
    }

}
