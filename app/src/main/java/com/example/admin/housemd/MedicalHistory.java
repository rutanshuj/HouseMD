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

public class MedicalHistory extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] disease = {"D.O.B", "Blood Group", "Gender"};
    String[] doctor = {"19-11-1996", "O+", "Male"};
    String[] medication = {"19-11-1996", "O+", "Male"};

    ArrayList<DataProviderMedicalHistory> arrayList = new ArrayList<DataProviderMedicalHistory>();


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_checking,container,false);

        recyclerView = (RecyclerView) view.findViewById(R.id.medical_history_rv);
        adapter = new MedicalHistoryRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String dis : disease) {
            DataProviderMedicalHistory dataProviderMedicalHistory = new DataProviderMedicalHistory(disease[i], doctor[i], medication[i]);
            arrayList.add(dataProviderMedicalHistory);
            i++;
        }
        return view;
    }
}
