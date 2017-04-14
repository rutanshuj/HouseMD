package com.example.admin.housemd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MedicalHistory extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] disease = {"D.O.B", "Blood Group", "Gender"};
    String[] doctor = {"19-11-1996", "O+", "Male"};
    String[] medication = {"19-11-1996", "O+", "Male"};

    ArrayList<DataProviderMedicalHistory> arrayList = new ArrayList<DataProviderMedicalHistory>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medical_history);

        recyclerView = (RecyclerView) findViewById(R.id.medical_history_rv);
        adapter = new MedicalHistoryRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String dis : disease) {
            DataProviderMedicalHistory dataProviderMedicalHistory = new DataProviderMedicalHistory(disease[i], doctor[i], medication[i]);
            arrayList.add(dataProviderMedicalHistory);
            i++;
        }
    }
}
