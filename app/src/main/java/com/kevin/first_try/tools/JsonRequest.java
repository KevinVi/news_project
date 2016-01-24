package com.kevin.first_try.tools;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.text.format.Formatter;
import android.util.Log;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by leolebogoss on 24/01/2016.
 */

public class JsonRequest extends AsyncTask<Object, Void,Boolean> {
    private final Context mContext;
    public JsonRequest (Context ctx){
        mContext=ctx;
    }
    @Override
    protected Boolean doInBackground(Object... params) {
        final String data = (String) params[0];

        WifiManager wm = (WifiManager) mContext.getSystemService(Context.WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());
        URL url = null;
        try {
            url = new URL("https://ajax.googleapis.com/ajax/services/search/news?" + "v=1.0&q=" + data + "&userip=" + ip);
            HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            InputStream in = null;
            try {
                in = conn.getInputStream();
                StringBuffer sb = new StringBuffer();

                int buffer;
                while ((buffer = in.read()) != -1) {
                    sb.append((char) buffer);
                }

                Log.i("JsonRequest", sb.toString());

                JSONObject json = new JSONObject(sb.toString());



                return true;
            }catch (Exception ex){
                return false;

            }

        } catch (Exception e) {
            e.printStackTrace();

        }


        return false;
    }
}
