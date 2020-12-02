package com.hoangdocuc.travel.entity;

import javax.persistence.*;

@Entity
@Table(name = "place")
public class PlaceEntity extends BaseEntity{

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

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
}
