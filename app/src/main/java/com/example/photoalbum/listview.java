package com.example.photoalbum;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

//adapter for listview - gallery
public class listview extends BaseAdapter {
    Context context;
    int animals[];

    LayoutInflater inflter;
    public listview(Context applicationContext, int[] animals) {
        this.context = applicationContext;
        this.animals = animals;
        inflter = (LayoutInflater.from(applicationContext));
    }
    @Override
    public int getCount() {
        return animals.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @SuppressLint({"ViewHolder", "InflateParams"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //inflating the layout
        view = inflter.inflate(R.layout.listview, null);
        ImageView icon = view.findViewById(R.id.icon);
        //setting the image
        icon.setImageResource(animals[i]);
        return view;
    }
}
