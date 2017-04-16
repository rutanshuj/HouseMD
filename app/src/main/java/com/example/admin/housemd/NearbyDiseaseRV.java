package com.example.admin.housemd;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adm on 16-Apr-17.
 */

public class NearbyDiseaseRV extends RecyclerView.Adapter<NearbyDiseaseRV.RecyclerViewHolder> {

    private ArrayList<DataProviderNearbyDisease> arrayList = new ArrayList<DataProviderNearbyDisease>();

    public NearbyDiseaseRV(ArrayList<DataProviderNearbyDisease> arrayList) {

        this.arrayList = arrayList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nd_rv,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        DataProviderNearbyDisease dataProviderNearbyDisease = arrayList.get(position);
        holder.symptoms.setText(dataProviderNearbyDisease.getSymptoms());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView symptoms;

        public RecyclerViewHolder(View view){
            super(view);

            symptoms = (TextView) view.findViewById(R.id.nd_symptoms1);

        }

    }
}

