package com.asad.sid.aifoodordering.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.asad.sid.aifoodordering.R;

public class MyAdapter extends BaseAdapter {
    private final Context context;
    LayoutInflater layoutinflator;
    String[] title;
    Integer[] img;

    public MyAdapter(Context context, String[] title, Integer[] img) {
        this.context = context;
        this.layoutinflator = LayoutInflater.from(context);
        this.title = title;
        this.img = img;
    }

    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int i) {
        return title[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        view =  layoutinflator.inflate(R.layout.menu_item,null,false);
        TextView mname = (TextView) view.findViewById(R.id.menu_name);
        ImageView mimg = (ImageView) view.findViewById(R.id.menu_image);
        mname.setText(title[i]);
        mimg.setImageResource(img[i]);
        return view;
    }
}


