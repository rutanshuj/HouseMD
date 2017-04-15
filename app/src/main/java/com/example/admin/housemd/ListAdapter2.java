package com.example.admin.housemd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by Adm on 15-Apr-17.
 */

public class ListAdapter2 extends ArrayAdapter {

    public ListAdapter2(Context context, String[] heading, Integer[] button) {
        super(context, R.layout.checkedrow, heading);

        this.context = context;
        this.heading = heading;
        this.button = button;
    }

    private final Context context;
    private final String[] heading;
    private final Integer[] button;

    int i = 0;

    public View getView(final int position, View view, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context.getApplicationContext());
        View rowView = inflater.inflate(R.layout.checkedrow, null, true);

        TextView txtHead = (TextView) rowView.findViewById(R.id.text_sl);
        ImageButton bcall = (ImageButton) rowView.findViewById(R.id.remove_button);

        txtHead.setText(heading[position]);
        bcall.setImageResource(R.mipmap.ic_launcher);

        bcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return rowView;

    };

}