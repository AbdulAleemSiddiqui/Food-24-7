package com.asad.sid.aifoodordering;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.asad.sid.aifoodordering.Classes.common;
import com.asad.sid.aifoodordering.Classes.foodDetails2;
import com.asad.sid.aifoodordering.Classes.foodDetailsAdapter2;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PizzaFragment extends Fragment {

    private ListView listView;
    DatabaseReference databaseReference;
    List<foodDetails2> foodList;
    public PizzaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pizza, container, false);
        databaseReference = FirebaseDatabase.getInstance().getReference("pizza");
        listView = (ListView) view.findViewById(R.id.listview);
        foodList = new ArrayList<>();

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot foodSS : dataSnapshot.getChildren()){

                    foodDetails2 food = foodSS.getValue(foodDetails2.class);
                    foodList.add(food);
                }
                foodDetailsAdapter2 foodAdapter = new foodDetailsAdapter2(getContext(), foodList);
                listView.setAdapter(foodAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

//                        fdetail.putExtra("ID", foodList.get(i).getSno());
//                        fdetail.putExtra("NAME", foodList.get(i).getFoodname());
//                        fdetail.putExtra("PRICE", foodList.get(i).getFoodname());

                        common.Sno = (foodList.get(i).getSno());
                        common.foodflavor = (foodList.get(i).getFlavor());
                        common.selectedMenu = "pizza";

                        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, new FoodDetailFragment2());
                        ft.commit();
                    }
                });
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
