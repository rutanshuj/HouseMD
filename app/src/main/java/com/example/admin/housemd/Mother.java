package com.example.admin.housemd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Mother extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] fdisease = {"D.O.B", "Blood Group", "Gender"};
    String[] fdoctor = {"19-11-1996", "O+", "Male"};
    String[] fmedication = {"19-11-1996", "O+", "Male"};

    ArrayList<DataProviderFather> arrayList = new ArrayList<DataProviderFather>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_mother,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.mother);
        adapter = new FatherRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String dis : fdisease) {
            DataProviderFather dataProviderFather = new DataProviderFather(fdisease[i], fdoctor[i], fmedication[i]);
            arrayList.add(dataProviderFather);
            i++;
        }
        return view;
    }
}