package com.example.admin.housemd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;

/**
 * Created by Adm on 15-Apr-17.
 */

public class ListAdapter1 extends ArrayAdapter {

    public ListAdapter1(Context context, CheckedTextView textView) {
        super(context, R.layout.simplerow);
        this.context = context;
        this.textView = textView;
    }

    private final Context context;
    private final CheckedTextView textView;

    int i = 0;

    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View rowView = inflater.inflate(R.layout.simplerow, null, true);

        CheckedTextView txtHead = (CheckedTextView) rowView.findViewById(R.id.txt_lan);

        return rowView;

    };

}