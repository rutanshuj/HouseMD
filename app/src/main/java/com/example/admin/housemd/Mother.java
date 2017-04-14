package com.example.admin.housemd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class Mother extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] fdisease = {"D.O.B", "Blood Group", "Gender"};
    String[] fdoctor = {"19-11-1996", "O+", "Male"};
    String[] fmedication = {"19-11-1996", "O+", "Male"};

    ArrayList<DataProviderFather> arrayList = new ArrayList<DataProviderFather>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother);

        recyclerView = (RecyclerView) findViewById(R.id.father);
        adapter = new FatherRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String dis : fdisease) {
            DataProviderFather dataProviderFather = new DataProviderFather(fdisease[i], fdoctor[i], fmedication[i]);
            arrayList.add(dataProviderFather);
            i++;
        }

    }
}