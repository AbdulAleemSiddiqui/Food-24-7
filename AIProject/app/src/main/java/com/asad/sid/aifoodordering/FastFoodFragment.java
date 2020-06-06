package com.asad.sid.aifoodordering;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.asad.sid.aifoodordering.Classes.common;
import com.asad.sid.aifoodordering.Classes.foodDetails;
import com.asad.sid.aifoodordering.Classes.foodDetailsAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FastFoodFragment extends Fragment {

    public FastFoodFragment() {

    }
    private ListView listView;
    DatabaseReference databaseReference;
    List<foodDetails> foodList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fast_food, container, false);

        databaseReference = FirebaseDatabase.getInstance().getReference("fastfood");
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

                    foodDetails food = foodSS.getValue(foodDetails.class);

                    foodList.add(food);
            }
                foodDetailsAdapter foodAdapter = new foodDetailsAdapter(getContext(), foodList);
                listView.setAdapter(foodAdapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {

//                        fdetail.putExtra("ID", foodList.get(i).getSno());
//                        fdetail.putExtra("NAME", foodList.get(i).getFoodname());
//                        fdetail.putExtra("PRICE", foodList.get(i).getFoodname());

                        common.Sno = (foodList.get(i).getSno());
                        common.foodname = (foodList.get(i).getFoodname());
                        common.foodprice = (foodList.get(i).getFoodprice());
                        common.selectedMenu = "fastfood";

                        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, new FoodDetailFragment());
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
