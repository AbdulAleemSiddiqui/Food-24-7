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
public class FoodDetailFragment extends Fragment {


    public FoodDetailFragment() {
        // Required empty public constructor
    }

    TextView food_name, food_price;
    FloatingActionButton btnCart;
    ElegantNumberButton numberButton;
    String quantity;
    DatabaseReference foods;
    private DBHelper db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_food_detail, container, false);

        try {foods = FirebaseDatabase.getInstance().getReference(common.selectedMenu);}
        catch(Exception e){};
        db = new DBHelper(getActivity());

        food_name = (TextView) view.findViewById(R.id.food_name);
        food_name.setText(common.foodname);
        food_price = (TextView) view.findViewById(R.id.food_price);
        food_price.setText(common.foodprice);
        numberButton = (ElegantNumberButton) view.findViewById(R.id.number_button);
        numberButton.setNumber(Integer.toString(common.tempQuantity));

        btnCart = (FloatingActionButton) view.findViewById(R.id.btnCart);
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantity = numberButton.getNumber();
                common.totalamount = Integer.toString(Integer.parseInt(quantity) * Integer.parseInt(common.foodprice));

                cartDetails cd = new cartDetails(common.currentUser.getPhone(), common.foodname, quantity, common.totalamount);
                long result = db.addToCart(cd);
                if (result > 0) {
                    Toast.makeText(getActivity(), quantity + " " + common.foodname + " of " +
                            common.totalamount + " rupees added to Cart", Toast.LENGTH_SHORT).show();
                }
                common.BillAmount = common.BillAmount + Integer.parseInt(common.totalamount);
                if(common.FoodStack == "")
                    common.FoodStack = quantity + " " + common.foodname;
                else
                    common.FoodStack += " + " + quantity + " " + common.foodname;
            }
        });
        return view;
    }

}
