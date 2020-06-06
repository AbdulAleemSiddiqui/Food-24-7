package com.asad.sid.aifoodordering;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.sid.aifoodordering.Classes.DBHelper;
import com.asad.sid.aifoodordering.Classes.cartDetails;
import com.asad.sid.aifoodordering.Classes.common;
import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class FoodDetailFragment2 extends Fragment {


    public FoodDetailFragment2() {
        // Required empty public constructor
    }

    TextView food_name, small_price, regular_price, large_price;
    FloatingActionButton btnCart;
    ElegantNumberButton smallButton, regularButton, largeButton;
    String smallquantity = "0", regularquantity = "0", largequantity = "0";
    DatabaseReference foods;
    private DBHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_detail2, container, false);
        smallquantity = "0";
        regularquantity = "0";
        largequantity = "0";

        try {foods = FirebaseDatabase.getInstance().getReference("pizza");}
        catch(Exception e){};
        db = new DBHelper(getActivity());

        if(common.tempSize == "small")
        {
            smallquantity = Integer.toString(common.tempQuantity);
        }
        if(common.tempSize == "regular")
        {
            regularquantity = Integer.toString(common.tempQuantity);
        }
        if(common.tempSize == "large")
        {
            largequantity = Integer.toString(common.tempQuantity);
        }

        food_name = (TextView) view.findViewById(R.id.food_name);
        food_name.setText(common.foodflavor);
        small_price = (TextView) view.findViewById(R.id.small_price);
        regular_price = (TextView) view.findViewById(R.id.regular_price);
        large_price = (TextView) view.findViewById(R.id.large_price);
        small_price.setText("400");
        regular_price.setText("600");
        large_price.setText("800");
        smallButton = (ElegantNumberButton) view.findViewById(R.id.small_button);
        regularButton = (ElegantNumberButton) view.findViewById(R.id.regular_button);
        largeButton = (ElegantNumberButton) view.findViewById(R.id.large_button);
        smallButton.setNumber(smallquantity);
        regularButton.setNumber(regularquantity);
        largeButton.setNumber(largequantity);


        btnCart = (FloatingActionButton) view.findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                smallquantity = smallButton.getNumber();
                regularquantity = regularButton.getNumber();
                largequantity = largeButton.getNumber();

                common.totalamount = Integer.toString(Integer.parseInt(smallquantity) * Integer.parseInt(small_price.getText().toString())+
                        Integer.parseInt(regularquantity) * Integer.parseInt(regular_price.getText().toString())+Integer.parseInt(largequantity) * Integer.parseInt(large_price.getText().toString()));

                cartDetails cd = new cartDetails(common.currentUser.getPhone(), "Pizza", Integer.toString(Integer.parseInt(smallquantity)+Integer.parseInt(largequantity)+Integer.parseInt(regularquantity)), common.totalamount);
                long result = db.addToCart(cd);
                if (result > 0) {
                    Toast.makeText(getActivity(), "Your total amount is " + common.totalamount + " rupees.", Toast.LENGTH_SHORT).show();
                }
                common.BillAmount = common.BillAmount + Integer.parseInt(common.totalamount);
                if(common.FoodStack == "")
                    common.FoodStack = (Integer.parseInt(smallquantity)+Integer.parseInt(largequantity)+Integer.parseInt(regularquantity)) + " Pizza";
                else
                    common.FoodStack += " + " + (Integer.parseInt(smallquantity)+Integer.parseInt(largequantity)+Integer.parseInt(regularquantity)) + " Pizza";
            }
        });
        return view;
    }

}
