package com.kevin.first_try.model;

import java.io.Serializable;

import co.uk.rushorm.core.RushObject;

/**
 * Created by kevin on 12/01/2016.
 */
public class Data extends RushObject implements Serializable  {
    public String title;
    public String content;
    public String editor;
    public String date;
    public String img;



    public Data(String title, String content , String editor , String date , String img) {
        this.content =content;
        this.title = title;
        this.editor = editor;
        this.date = date;
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
