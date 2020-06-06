package com.asad.sid.aifoodordering;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.asad.sid.aifoodordering.Classes.CartAdapter;
import com.asad.sid.aifoodordering.Classes.DBHelper;
import com.asad.sid.aifoodordering.Classes.cartDetails;
import com.asad.sid.aifoodordering.Classes.common;
import com.asad.sid.aifoodordering.Classes.orderDetails;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CartFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference requests;
    DBHelper db;
    private ListView listView;
    public TextView txtTotalPrice;
    Button btnPlace, btnClear;
    List<cartDetails> cart = new ArrayList<>();
    CartAdapter adapter;
    orderDetails od;

    public CartFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        db = new DBHelper(getContext());
        listView = (ListView) view.findViewById(R.id.listCart);

        txtTotalPrice=(TextView)view.findViewById(R.id.total);
        txtTotalPrice.setText(Integer.toString(common.BillAmount));

        cart = new ArrayList<cartDetails>();
        cart =  db.getAllFoodData(common.currentUser.getPhone());
        adapter = new CartAdapter (getContext(), cart);
        listView.setAdapter(adapter);

        btnClear=(Button) view.findViewById(R.id.btnClearCart);
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.clearCart(common.currentUser.getPhone());
                common.BillAmount = 0;
                common.FoodStack = "";
                android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.frame, new CartFragment());
                ft.commit();
            }
        });

        btnPlace=(Button) view.findViewById(R.id.btnPlaceOrder);
        btnPlace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAlertDialog();
            }
        });

        return view;
    }


    public void showAlertDialog() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());

        alertDialog.setTitle("Address!");
        alertDialog.setMessage("Enter your address: ");
        alertDialog.setIcon(R.drawable.ic_address);

        final EditText edtAddress  = new EditText(getContext());
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        edtAddress.setLayoutParams(lp);
        alertDialog.setView(edtAddress);

        alertDialog.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                if (edtAddress.getText().toString() == null){
                    Toast.makeText(getActivity(), "Enter your address first", Toast.LENGTH_SHORT).show();
                }
                else {

                    common.Address = edtAddress.getText().toString();
                    common.FinalAmount = Integer.toString(common.BillAmount);

                    od = new orderDetails(common.currentUser.getPhone(), common.FoodStack, common.FinalAmount, common.Address);
                    long result = db.addToOrder(od);
                    if (result > 0) {
                        Toast.makeText(getActivity(), "Order Placed", Toast.LENGTH_SHORT).show();
                        db.clearCart(common.currentUser.getPhone());
                        common.BillAmount = 0;
                        common.FoodStack = "";

                        android.support.v4.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
                        ft.replace(R.id.frame, new OrderFragment());
                        ft.commit();
                    }
                }

            }
        });
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alertDialog.show();
    }


}
