package com.kevin.first_try.tools;

import android.content.Context;
import android.net.wifi.WifiManager;
<<<<<<< HEAD
import android.text.format.Formatter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by kevin on 13/01/2016.
 */
public class JsonRequest {

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    public JSONObject getJSONData(String data, Context ctx) {


        WifiManager wm = (WifiManager) ctx.getSystemService(Context.WIFI_SERVICE);
        String ip = Formatter.formatIpAddress(wm.getConnectionInfo().getIpAddress());

        URL url = null;
        try {
            url = new URL("https://ajax.googleapis.com/ajax/services/search/news?" + "v=1.0&q=" + data + "&userip=" + ip);

            URLConnection connection = url.openConnection();
            String line;
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }

            JSONObject json = new JSONObject(builder.toString());

            return json;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
=======
import android.os.AsyncTask;
import android.text.format.Formatter;
import android.util.Log;

import com.kevin.first_try.model.Data;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by leolebogoss on 24/01/2016.
 */

public class JsonRequest extends AsyncTask<Object, Void,ArrayList<Data>> {
    private final Context mContext;
    private final String CONTENT = "content";
    private final String TITLE = "titleNoFormatting";
    private final String PUBLISHER = "publisher";
    private final String DATE = "publishedDate";
    private final String IMG = "url";
    private final String URL = "unescapedUrl";

    private final String RESPONSE = "responseData";
    private final String DETAIL = "responseDetail";
    private final String STATUS = "responseStatus";
    private final String IMAGE = "image";
    private final String RESULT = "results";

    ArrayList<Data> contents = new ArrayList<>();
    Data content_data = null;

    public JsonRequest (Context ctx){
        mContext=ctx;
    }
    @Override
    protected ArrayList<Data> doInBackground(Object... params) {
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
                JSONObject responseData = json.getJSONObject(RESPONSE);
                JSONArray results = responseData.getJSONArray(RESULT);

                for (int i = 0 ; i< results.length() ; i++){
                    JSONObject contentResult = results.getJSONObject(i);

                    String title = contentResult.getString(TITLE);
                    String content = contentResult.getString(CONTENT);
                    String date = contentResult.getString(DATE);
                    String publisher = contentResult.getString(PUBLISHER);
                    String urlWeb = contentResult.getString(URL);
                    JSONObject img = contentResult.getJSONObject(IMAGE);
                    String image = img.getString(IMG);

                    content_data = new Data(title,content,publisher,date,image,urlWeb);

                    contents.add(content_data);

                }



                return contents;
            }catch (Exception ex){
                ex.printStackTrace();
                return null;

            }

        } catch (Exception e) {
            e.printStackTrace();

>>>>>>> e2c23ee50136ddce0a06a4197b2b6f84d7dbfdee
        }


        return null;
    }
<<<<<<< HEAD
}
=======
}
>>>>>>> e2c23ee50136ddce0a06a4197b2b6f84d7dbfdee
