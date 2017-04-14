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

public class ProfileRV extends RecyclerView.Adapter<ProfileRV.RecyclerViewHolder> {

    private ArrayList<DataProvider> arrayList = new ArrayList<DataProvider>();

    public ProfileRV(ArrayList<DataProvider> arrayList) {

        this.arrayList = arrayList;

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.profile_recyclerview,parent,false);

        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {

        DataProvider dataProvider = arrayList.get(position);
        holder.attribute.setText(dataProvider.getAttribute());
        holder.value.setText(dataProvider.getValue());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView attribute,value;

        public RecyclerViewHolder(View view){
            super(view);

            attribute = (TextView) view.findViewById(R.id.attribute);
            value = (TextView) view.findViewById(R.id.value);

        }

    }
}
