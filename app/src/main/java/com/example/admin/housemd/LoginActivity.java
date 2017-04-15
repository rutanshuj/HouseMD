package com.example.admin.housemd;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username, password;
    Button signUp, logIn;

    List<String> userIdList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.pass);

        signUp = (Button) findViewById(R.id.signUpBttn);
        logIn = (Button) findViewById(R.id.loginBttn);

        signUp.setOnClickListener(this);
        logIn.setOnClickListener(this);

        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Users/").push();

        myRef.addValueEventListener(new ValueEventListener() {
            int i = 0;
            int index = 0;
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    userIdList.add(postSnapshot.getKey());
                    Log.d("asdasd", postSnapshot.getKey());
                    i++;
                }

                for (index=0;index<=dataSnapshot.getChildrenCount();index++)
                {
                    String x = dataSnapshot.getKey();
                    Log.d("asdasdasd", x);
                    index++;
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signUpBttn:
                break;
            case R.id.loginBttn:
                Intent i = new Intent(LoginActivity.this, Profile.class);
                startActivity(i);
                break;
        }
    }
}
