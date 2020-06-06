package com.asad.sid.aifoodordering;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.asad.sid.aifoodordering.Classes.MyAdapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment {


    public MenuFragment() {
        // Required empty public constructor
    }
    String[] arraymenu =  {"Fast Food", "BBQ", "Pizza", "Chinese", "Karahi"};
    Integer [] arrayimg = {R.drawable.fastfood, R.drawable.bbq, R.drawable.pizza, R.drawable.chinese, R.drawable.karahi};
    MyAdapter adapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        ListView listView = (ListView) view.findViewById(R.id.listview);
        adapter = new MyAdapter(getActivity(),arraymenu,arrayimg);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

                if (arraymenu[i] == "Fast Food")
                {
                    android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new FastFoodFragment());
                    ft.commit();
                }
                else if (arraymenu[i] == "BBQ")
                {
                    android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new BBQFragment());
                    ft.commit();
                }
                else if (arraymenu[i] == "Pizza")
                {
                    android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new PizzaFragment());
                    ft.commit();
                }
                else if (arraymenu[i] == "Karahi")
                {
                    android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new KarahiFragment());
                    ft.commit();
                }
                else if (arraymenu[i] == "Chinese")
                {
                    android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                    ft.replace(R.id.frame, new ChineseFragment());
                    ft.commit();
                }

            }
        });

        return view;
    }



}
