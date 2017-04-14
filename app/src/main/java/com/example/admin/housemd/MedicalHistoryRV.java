package com.example.admin.housemd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adm on 14-Apr-17.
 */

public class MedicalHistoryRV extends RecyclerView.Adapter<MedicalHistoryRV.RecyclerViewHolder> {

    private ArrayList<DataProviderMedicalHistory> arrayList = new ArrayList<DataProviderMedicalHistory>();
    public MedicalHistoryRV(ArrayList<DataProviderMedicalHistory> arrayList) {

        this.arrayList = arrayList;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.medicalhistory_rv, parent, false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }


    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        DataProviderMedicalHistory dataProviderMedicalHistory = arrayList.get(position);
        holder.disease.setText(dataProviderMedicalHistory.getDisease());
        holder.doctor.setText(dataProviderMedicalHistory.getDoctor());
        holder.medication.setText(dataProviderMedicalHistory.getMedication());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView disease,doctor,medication;

        public RecyclerViewHolder(View view){
            super(view);

            disease = (TextView) view.findViewById(R.id.disease_name);
            doctor = (TextView) view.findViewById(R.id.doctors);
            medication = (TextView) view.findViewById(R.id.medication);

        }

    }
}


