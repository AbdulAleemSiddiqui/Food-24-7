package com.asad.sid.aifoodordering.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.asad.sid.aifoodordering.R;

public class foodAdapter extends BaseAdapter{
    private final Context context;
    LayoutInflater layoutinflator;
    int[] sno;
    String[] foodname;
    int[] price;

    public foodAdapter(Context context, int[] sno, String[] foodname, int[] price) {
        this.context = context;
        this.sno = sno;
        this.foodname = foodname;
        this.price = price;
        this.layoutinflator = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return foodname.length;
    }

    @Override
    public Object getItem(int i) {
        return foodname[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view =  layoutinflator.inflate(R.layout.food_item,null,false);
        TextView snotv = (TextView) view.findViewById(R.id.sno);
        TextView nametv = (TextView) view.findViewById(R.id.foodname);
        TextView pricetv = (TextView) view.findViewById(R.id.foodprice);
        nametv.setText(foodname[i]);
        pricetv.setText(Integer.toString(price[i]));
        snotv.setText(Integer.toString(sno[i]));

        return view;
    }
}
