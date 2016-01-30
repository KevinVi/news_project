package com.kevin.first_try.tools;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

/**
 * Created by leolebogoss on 30/01/2016.
 */
public class ImageLoader extends AsyncTask<Object,Void,Bitmap>{
    @Override
    protected Bitmap doInBackground(Object... params) {
        String url = (String) params[0];
        try {
            InputStream in = new URL(url).openStream();
            return BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            // log error
        }
        return null;
    }

}
