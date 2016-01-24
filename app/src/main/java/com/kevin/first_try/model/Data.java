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
<<<<<<< HEAD

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
=======
>>>>>>> bb4d8314078b72b8f7bd4deeba1eb379c1cc6c61
}
