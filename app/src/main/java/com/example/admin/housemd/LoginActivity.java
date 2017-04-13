package com.example.admin.housemd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    EditText username, password;
    Button signUp, logIn;

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
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.signUpBttn:
                break;
            case R.id.loginBttn:
                Intent i = new Intent(LoginActivity.this, NavigationActivity.class);
                startActivity(i);
                break;
        }
    }
}
