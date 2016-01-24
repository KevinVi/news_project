package com.kevin.first_try.model;

/**
 * Created by kevin on 12/01/2016.
 */
public class Data {
    public String number;
    public String content;

    public Data(String nb, String content) {
        this.content =content;
        this.number = nb;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
