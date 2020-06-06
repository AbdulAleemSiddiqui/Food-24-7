package com.asad.sid.aifoodordering.Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.asad.sid.aifoodordering.R;
import java.util.List;

public class OrderAdapter extends ArrayAdapter<orderDetails> {

    private List<orderDetails> listData;
    private final Context context;
    LayoutInflater layoutinflator;

    public OrderAdapter(Context context, List<orderDetails> listData) {
        super(context, R.layout.order_layout, listData);
        this.context = context;
        this.listData = listData;
        this.layoutinflator = LayoutInflater.from(context);
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        view =  layoutinflator.inflate(R.layout.order_layout,null,true);
        TextView txtId = (TextView) view.findViewById(R.id.order_id);
        TextView txtFood = (TextView) view.findViewById(R.id.order_Food);
        TextView txtAmount = (TextView) view.findViewById(R.id.order_price);
        TextView txtAddress = (TextView) view.findViewById(R.id.order_address);

        orderDetails order = listData.get(i);
        txtId.setText("Order Id: " + order.getId());
        txtFood.setText("Items: " + order.getFood());
        txtAmount.setText("Amount: " + order.getAmount() + " Rs.");
        txtAddress.setText(order.getAddress());

        return view;
    }
}
