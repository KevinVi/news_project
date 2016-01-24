package com.kevin.first_try.model;

import co.uk.rushorm.core.RushObject;

/**
 * Created by kevin on 12/01/2016.
 */
public class Data extends RushObject {
    public String number;
    public String content;

    public Data(String nb, String content) {
        this.content =content;
        this.number = nb;
    }
}
