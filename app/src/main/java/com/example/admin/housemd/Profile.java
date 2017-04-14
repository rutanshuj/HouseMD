package com.example.admin.housemd;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.github.fabtransitionactivity.SheetLayout;

import java.util.ArrayList;

public class Profile extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    String[] attribute = {"D.O.B", "Blood Group", "Gender", "Phone", "Email",  "Address"};
    String[] value = {"19-11-1996", "O+", "Male", "9790007096", "akhilagarwal96@gmail.com", "VIT Vellore, Men's Hostel L-022 Vellore-632014"};

    ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    SheetLayout mSheetLayout;
    FloatingActionButton mFab;

    private static final int REQUEST_CODE = 1;

    View fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        recyclerView = (RecyclerView) findViewById(R.id.profilerv);
        adapter = new ProfileRV(arrayList);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        int i = 0;
        for (String attr : attribute) {
            DataProvider dataProvider = new DataProvider(attribute[i], value[i]);
            arrayList.add(dataProvider);
            i++;
        }

        mFab = (FloatingActionButton) findViewById(R.id.fab);
//        mSheetLayout = (SheetLayout) findViewById(R.id.bottom_sheet);

//        mSheetLayout.setFab(mFab);
//        mSheetLayout.setFabAnimationEndListener((SheetLayout.OnFabAnimationEndListener) this);

        fragment = findViewById(R.id.frag);
        fragment.inflate(R.layout.fragment,);

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                mSheetLayout.expandFab();
                fragment.setVisibility(View.INVISIBLE);
                Toast.makeText(Profile.this, "Hello", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
