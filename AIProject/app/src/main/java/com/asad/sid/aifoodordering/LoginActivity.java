package com.asad.sid.aifoodordering;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.asad.sid.aifoodordering.Classes.common;
import com.asad.sid.aifoodordering.Classes.user;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {
    private EditText phone, password;
    private Button signin;
    private TextView signup;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        sp = getSharedPreferences("myData", MODE_PRIVATE);

        phone = (EditText) findViewById(R.id.phone);
        password = (EditText) findViewById(R.id.password);
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = db.getReference("User");

        signin = (Button) findViewById(R.id.signIn);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        if(dataSnapshot.child(phone.getText().toString()).exists()) {

                            user us = dataSnapshot.child(phone.getText().toString()).getValue(user.class);

                            if (us.getPassword().equals(password.getText().toString())) {

                                common.currentUser = us;
                                common.usname = common.currentUser.getName();
                                common.usemail = common.currentUser.getEmail();

                                common.currentUser.setPhone(phone.getText().toString());

                                sp.edit().putString("email", common.currentUser.getEmail()).commit();
                                sp.edit().putString("password", common.currentUser.getPassword()).commit();
                                sp.edit().putString("name",common.currentUser.getName()).commit();
                                sp.edit().putString("phone", common.currentUser.getPhone()).commit();

                                Intent home = new Intent(LoginActivity.this, HomeActivity.class);
                                startActivity(home);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Sign in failed !", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "User not registered", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });

        signup = (TextView) findViewById(R.id.signupTxt);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent reg = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(reg);
            }
        });

    }
}
