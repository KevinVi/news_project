package com.kevin.first_try.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kevin.first_try.R;
import com.kevin.first_try.activity.Detail_activity;
import com.kevin.first_try.model.Data;
import com.kevin.first_try.tools.ImageLoader;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by kevin on 12/01/2016.
 */
public class ListAdapter extends ArrayAdapter<Data> {

    private ArrayList<String> list;


    public ListAdapter(Context context,  ArrayList<Data> items) {
        super(context,0, items);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.list_adapter, null);
        }

        Data p = getItem(position);

        if (p != null) {
            TextView tt1 = (TextView) v.findViewById(R.id.number_list);
            TextView tt2 = (TextView) v.findViewById(R.id.content_list);
            ImageView img = (ImageView) v.findViewById(R.id.image_list);

            if (tt1 != null) {
                tt1.setText(p.title);
            }

            if (tt2 != null) {
                tt2.setText(p.content);
            }
            if(img != null){
                try {
                    new ImageLoader(img).execute(p.img);
                } catch (Exception e){
                    e.printStackTrace();
                }
            }

        }
        final Data mData=p;
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(),Detail_activity.class);
                Bundle args = new Bundle();
                args.putSerializable("mData",mData);
                Log.i("hello---", String.valueOf(args) + " | " + args.getSerializable("mData").toString());
                i.putExtra("mData", args);
                getContext().startActivity(i);
            }
        });

        return v;

    }

    @Override
    public int getCount() {

        return super.getCount();
    }
}

