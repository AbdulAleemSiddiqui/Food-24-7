package com.asad.sid.aifoodordering;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.asad.sid.aifoodordering.Classes.DBHelper;
import com.asad.sid.aifoodordering.Classes.OrderAdapter;
import com.asad.sid.aifoodordering.Classes.common;
import com.asad.sid.aifoodordering.Classes.orderDetails;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class OrderFragment extends Fragment {


    public OrderFragment() {
        // Required empty public constructor
    }
    List<orderDetails> order = new ArrayList<>();
    OrderAdapter adapter;
    DBHelper db;
    private ListView listView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);

        db = new DBHelper(getContext());
        listView = (ListView) view.findViewById(R.id.listOrder);

        order = new ArrayList<orderDetails>();
        order =  db.getAllOrders(common.currentUser.getPhone());
        adapter = new OrderAdapter (getContext(), order);
        listView.setAdapter(adapter);

        return view;
    }

}
