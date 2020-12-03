package com.hoangdocuc.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class PlaceEntity extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "fileword")
    private String fileword;

    @Column(name = "name")
    private String name;

    @Column(name = "views")
    private Integer views;

    @Column(name = "image")
    private String image;

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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
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
}
