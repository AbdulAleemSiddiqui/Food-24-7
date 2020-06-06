package com.asad.sid.aifoodordering.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.asad.sid.aifoodordering.R;
import java.util.List;

public class CartAdapter extends ArrayAdapter<cartDetails> {

    private List<cartDetails> listData; //new ArrayList<>();
    private final Context context;
    LayoutInflater layoutinflator;

    public CartAdapter(Context context, List<cartDetails> listData) {
        super(context, R.layout.cart_layout, listData);
        this.context = context;
        this.listData = listData;
        this.layoutinflator = LayoutInflater.from(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view =  layoutinflator.inflate(R.layout.cart_layout,null,true);
        TextView fname = (TextView) view.findViewById(R.id.cart_item_name);
        TextView fprice = (TextView) view.findViewById(R.id.cart_item_Price);
        cartDetails cart = listData.get(i);
        fname.setText(cart.getTxtCartQuantity() + " " + cart.getTxtCartName());
        fprice.setText("Amount: " + cart.getTextCartPrice() + " Rs.");
        return view;
    }
}

