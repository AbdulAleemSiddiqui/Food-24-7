package com.asad.sid.aifoodordering.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.asad.sid.aifoodordering.R;
import java.util.List;

public class foodDetailsAdapter extends ArrayAdapter<foodDetails> {
    private final Context context;
    LayoutInflater layoutinflator;
    List<foodDetails> foodList;

    public foodDetailsAdapter(Context context, List<foodDetails> foodList) {
        super(context, R.layout.food_item, foodList);
        this.context = context;
        this.layoutinflator = LayoutInflater.from(context);
        this.foodList = foodList;
    }



    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view =  layoutinflator.inflate(R.layout.food_item,null,true);
        TextView fsno = (TextView) view.findViewById(R.id.sno);
        TextView fname = (TextView) view.findViewById(R.id.foodname);
        TextView fprice = (TextView) view.findViewById(R.id.foodprice);
        foodDetails food = foodList.get(i);
        fsno.setText(food.getSno());
        fname.setText(food.getFoodname());
        fprice.setText(food.getFoodprice());
        return view;
    }
}
