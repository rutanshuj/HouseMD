package com.example.admin.housemd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class NearbyDisease extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    ArrayList<DataProviderNearbyDisease> arrayList = new ArrayList<DataProviderNearbyDisease>();

    String[] sym = {"D.O.B", "Blood Group", "Gender", "Phone"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby_disease);

        recyclerView = (RecyclerView) findViewById(R.id.nd_recycler);
        adapter = new NearbyDiseaseRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String s : sym) {
            DataProviderNearbyDisease dataProviderNearbyDisease = new DataProviderNearbyDisease(sym[i]);
            arrayList.add(dataProviderNearbyDisease);
            i++;
        }



    }
}
