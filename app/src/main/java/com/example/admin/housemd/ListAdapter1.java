package com.example.admin.housemd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Adm on 15-Apr-17.
 */

public class ListAdapter1 extends ArrayAdapter {

    public ListAdapter1(Context context, ArrayList<String> text) {
        super(context, R.layout.simplerow1, text);

        this.context = context;
        this.text = text;
    }

    private final Context context;
    private final ArrayList<String> text;

    int i = 0;

    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View rowView = inflater.inflate(R.layout.simplerow1, null, true);

        TextView txt = (TextView) rowView.findViewById(R.id.sym_text);

        txt.setText(text.get(position));

        return rowView;

    };

}