package com.hoangdocuc.travel.dto;

public class PlaceDTO extends BaseDTO {

    private String name;
    private String image;
    private String title;
    private String content;
    private String fileword;
    private Integer views;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFileword() {
        return fileword;
    }

    public void setFileword(String fileword) {
        this.fileword = fileword;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }
}
