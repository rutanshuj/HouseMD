package com.example.admin.housemd;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DiseasesCardView extends AppCompatActivity {

    DatabaseReference databaseReference;
    Collection<Object> values;
    final ArrayList<String> aList = new ArrayList<>();
     static final ArrayList<String> hitList = new ArrayList<>();
    int malaria, sf, cholera, tb, azd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseases_card_view);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Symptoms");

        aList.add("Fever");
        aList.add("Cough");
        aList.add("Muscle Pain");

        for (int x = 0; x < aList.size(); x++) {
            final int finalX = x;
            databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {

                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                        final String msg = aList.get(finalX);

                        if (msg.equals(snapshot.getKey())) {
                            databaseReference.child(msg).addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {
                                    Map<String, Object> td = (HashMap<String, Object>) dataSnapshot.getValue();

                                    values = td.values();

                                    SharedPreferences sharedPreferences = getSharedPreferences("values", Context.MODE_PRIVATE);
                                    SharedPreferences.Editor editor = sharedPreferences.edit();


//                                for (String s : td.keySet()) {
//                                    // use the name as the key, and the icon as the value
//                                    editor.putString(s, String.valueOf(td.get(s)));
//                                    Log.d("sss", s);
//                                }
//
                                    editor.putString("list", String.valueOf(values));
                                    editor.commit();
//
////                                Log.d("yuss", v);
                                }

                                @Override
                                public void onCancelled(DatabaseError databaseError) {

                                }
                            });

                        }
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
            SharedPreferences sharedPreferences = getSharedPreferences("values", Context.MODE_PRIVATE);
            final String finalvalues = sharedPreferences.getString("list", "");

            Log.d("babli", finalvalues);
        }

        for(String disease: aList){
            if(disease.equals("Malaria")){
                Toast.makeText(this, "Malaria Detected", Toast.LENGTH_SHORT).show();
                malaria =+1;
            }
            if(disease.equals("Swine Flu")){
                sf =+1;
            }
            if (disease.equals("Cholera")){
                cholera=+1;
            }
            if(disease.equals("Tuberculosis")){
                tb =+1;
            }
            if(disease.equals("Alzheimer's Disease")){
                azd =+1;
            }
        }
        Log.d("malaria1", String.valueOf(malaria));
    }
}

