package com.example.admin.housemd;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {

    Button signup;
    EditText name,email,password,phone,fmail,mmail,adddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        name = (EditText) findViewById(R.id.user_name);
        email = (EditText) findViewById(R.id.user_email);
        password = (EditText) findViewById(R.id.user_password);
        phone = (EditText) findViewById(R.id.user_phone);
        fmail = (EditText) findViewById(R.id.user_fmail);
        mmail = (EditText) findViewById(R.id.user_mmail);
        adddress = (EditText) findViewById(R.id.user_address);

        signup = (Button) findViewById(R.id.signupbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty() ||
                        phone.getText().toString().isEmpty() || fmail.getText().toString().isEmpty() ||
                        mmail.getText().toString().isEmpty() || adddress.getText().toString().isEmpty())
                {
                    AlertDialog.Builder complete = new AlertDialog.Builder(getApplicationContext());
                    complete.setMessage("Oops!! It's empty");
                    complete.setCancelable(true);
                    complete.setPositiveButton(
                            "Okay!",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert1 = complete.create();
                    alert1.show();
                }
                else
                {

                }
            }
        });

    }
}
