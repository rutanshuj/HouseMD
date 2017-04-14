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

public class MotherRV extends RecyclerView.Adapter<MotherRV.RecyclerViewHolder> {

    private ArrayList<DataProviderMother> arrayList = new ArrayList<DataProviderMother>();

    public MotherRV(ArrayList<DataProviderMother> arrayList) {

        this.arrayList = arrayList;

    }

    @Override
    public MotherRV.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mother_rv,parent,false);

        MotherRV.RecyclerViewHolder recyclerViewHolder = new MotherRV.RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(MotherRV.RecyclerViewHolder holder, int position) {

        DataProviderMother dataProviderMother = arrayList.get(position);
        holder.mdis.setText(dataProviderMother.getMdis());
        holder.mdoc.setText(dataProviderMother.getMdoc());
        holder.mmed.setText(dataProviderMother.getMmed());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView mdis,mdoc,mmed;

        public RecyclerViewHolder(View view){
            super(view);

            mdis = (TextView) view.findViewById(R.id.m_dname);
            mdoc = (TextView) view.findViewById(R.id.m_doc);
            mmed = (TextView) view.findViewById(R.id.m_med);

        }

    }
}
