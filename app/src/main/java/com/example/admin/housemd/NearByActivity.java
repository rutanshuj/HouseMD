package com.example.admin.housemd;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class NearByActivity extends FragmentActivity {
    DatabaseReference databaseReference;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near_by);

        SharedPreferences sp = getSharedPreferences("location", Context.MODE_PRIVATE);
        final int latitude = sp.getInt("lat", 0);
        final int longitude = sp.getInt("long", 0);
        t1 = (TextView) findViewById(R.id.dname);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Disease").child("Nearby").child("D1");

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                final double dlat = (Double) dataSnapshot.child("Lat").getValue();
                final double dlong = (Double) dataSnapshot.child("Long").getValue();

                int difflat = (int) (dlat-latitude)^2;
                int difflong = (int) (dlong-longitude)^2;

                if(difflat<25 && difflong<25){
                    final String name = (String) dataSnapshot.child("Name").getValue();
                    t1.setText(name);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
