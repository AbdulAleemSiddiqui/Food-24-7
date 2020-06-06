package com.asad.sid.aifoodordering;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.asad.sid.aifoodordering.Classes.common;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    public ProfileFragment() {
        // Required empty public constructor
    }
    EditText pname, pemail, pcontact;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        pname = (EditText) view.findViewById(R.id.pname);
        pemail = (EditText) view.findViewById(R.id.pemail);
        pcontact = (EditText) view.findViewById(R.id.pcontact);
        pname.setText(common.currentUser.getName());
        pemail.setText(common.currentUser.getEmail());
        pcontact.setText(common.currentUser.getPhone());


        return view;
    }

}
