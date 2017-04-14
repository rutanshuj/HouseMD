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

public class FatherRV extends RecyclerView.Adapter<FatherRV.RecyclerViewHolder> {

    private ArrayList<DataProviderFather> arrayList = new ArrayList<DataProviderFather>();

    public FatherRV(ArrayList<DataProviderFather> arrayList) {

        this.arrayList = arrayList;

    }

    @Override
    public FatherRV.RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.father_rv,parent,false);

        FatherRV.RecyclerViewHolder recyclerViewHolder = new FatherRV.RecyclerViewHolder(view);

        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(FatherRV.RecyclerViewHolder holder, int position) {

        DataProviderFather dataProviderFather = arrayList.get(position);
        holder.fdis.setText(dataProviderFather.getFdis());
        holder.fdoc.setText(dataProviderFather.getFdoc());
        holder.fmed.setText(dataProviderFather.getFmed());

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        TextView fdis,fdoc,fmed;

        public RecyclerViewHolder(View view){
            super(view);

            fdis = (TextView) view.findViewById(R.id.f_dname);
            fdoc = (TextView) view.findViewById(R.id.f_doc);
            fmed = (TextView) view.findViewById(R.id.f_med);

        }

    }
}
