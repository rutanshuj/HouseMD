package com.example.admin.housemd;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity {

    Button signup;
    EditText name,email,password,phone,dob,fmail,mmail,adddress;
    Spinner bg_spinner, s_spinner;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        final String url = "https://housemd.heroku.com/auth/save";

        name = (EditText) findViewById(R.id.user_name);
        email = (EditText) findViewById(R.id.user_email);
        password = (EditText) findViewById(R.id.user_password);
        phone = (EditText) findViewById(R.id.user_phone);
        fmail = (EditText) findViewById(R.id.user_fmail);
        mmail = (EditText) findViewById(R.id.user_mmail);
        adddress = (EditText) findViewById(R.id.user_address);
/*
        final Calendar myCalendar = Calendar.getInstance();

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }


            private void updateLabel() {

                String myFormat = "MM/dd/yy"; //In which you need put here
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

                dob.setText(sdf.format(myCalendar.getTime()));
            }

        };
*/
        dob = (EditText) findViewById(R.id.user_dob);
/*
        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(SignUp.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
*/

        signup = (Button) findViewById(R.id.signupbutton);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (name.getText().toString().isEmpty() || email.getText().toString().isEmpty() || password.getText().toString().isEmpty() ||
                        phone.getText().toString().isEmpty() || dob.getText().toString().isEmpty() ||
                        fmail.getText().toString().isEmpty() ||
                        mmail.getText().toString().isEmpty() || adddress.getText().toString().isEmpty()) {
                    Toast.makeText(SignUp.this, "Please fill in the details!!!", Toast.LENGTH_SHORT).show();
                    /*AlertDialog.Builder complete = new AlertDialog.Builder(getApplicationContext());
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
                    alert1.show();*/
                }
                else {
                    /*
                    JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                            url, null,
                            new Response.Listener<JSONObject>() {

                                @Override
                                public void onResponse(JSONObject response) {
                                    Log.d("TAG1", response.toString());
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            VolleyLog.d("TAG", "Error: " + error.getMessage());
                        }
                    }) {

                        @Override
                        protected Map<String, String> getParams() {
                            Map<String, String> params = new HashMap<String, String>();
                            params.put("name",name.getText().toString());
                            params.put("email", email.getText().toString());
                            params.put("password", password.getText().toString());
                            params.put("phone", phone.getText().toString());
                            params.put("address", adddress.getText().toString());
                            params.put("femail", fmail.getText().toString());
                            params.put("memail", mmail.getText().toString());
                            return params;
                        }

                    };

                    AppController.getInstance().addToRequestQueue(jsonObjReq,"TAG");
                }*/

                    // Write a message to the database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    DatabaseReference myRef = database.getReference("Users/").push();

                    myRef.child("Name").setValue(name.getText().toString());
                    myRef.child("Email").setValue(email.getText().toString());
                    myRef.child("Password").setValue(password.getText().toString());
                    myRef.child("Phone").setValue(phone.getText().toString());
                    myRef.child("Date of Birth").setValue(dob.getText().toString());
                    myRef.child("Address").setValue(adddress.getText().toString());
                    myRef.child("Father's Email").setValue(fmail.getText().toString());
                    myRef.child("Mother's Email").setValue(mmail.getText().toString());
                    myRef.child("Sex").setValue(s_spinner.getSelectedItem());

                }
            }
        });
    }
}
