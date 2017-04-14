package com.example.admin.housemd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class Symptoms1Frag extends Fragment {
    final ArrayList<String> selectedItems = new ArrayList<>();
    EditText inputSearch;
    TextView text_sl;
    Button b1;
    ImageButton b2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_symptoms_frag, container, false);
        final ListView chl = (ListView) view.findViewById(R.id.symptoms_list_view);
        final ListView shl = (ListView) view.findViewById(R.id.checkedList);
        b1 = (Button) view.findViewById(R.id.showResult);
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        inputSearch = (EditText) view.findViewById(R.id.inputSearch);



        String[] items = {"Nuasea", "cdcd", "cdcdcdc", "rutanshu" };
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), R.layout.simplerow,R.id.txt_lan, items);


        chl.setAdapter(adapter);


        final CheckedListAdapter adapter2 = new CheckedListAdapter(getActivity(), selectedItems )

        chl.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();

                if(selectedItems.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                    shl.setAdapter(adapter2);


                    //int duration = 500;  //miliseconds
//                    int offset = 0;      //fromListTop
//
//                    chl.smoothScrollToPositionFromTop(position,offset,duration);
//                    chl.setSelection(position);

                }
                else {
                    selectedItems.add(selectedItem);
                    shl.setAdapter(adapter2);
                    shl.isShown();
                }
            }
        });

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
//                // When user changed the Text
//                List.this.listAdapter.getFilter().filter(cs);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                          int arg3) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable arg0) {
                String message = inputSearch.getText().toString().toLowerCase();
                adapter.getFilter().filter(message);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String items="";
                for(String item: selectedItems){
                    items+="-"+item+"\n";

                }
                Toast.makeText(getContext(), "You have selected \n" + items, Toast.LENGTH_SHORT).show();
            }
        });


        return view;

    }
    public class CheckedListAdapter extends ArrayAdapter {

        public CheckedListAdapter(FragmentActivity context, String[] text, int[] button) {
            super(context, R.layout.checkedrow );
            this.context = context;
            this.text = text;
            this.button = button;
        }
        private final  Activity context;
        private final String[] text;
        private final int[] button;

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.checkedrow, null, true);

            b2 = (ImageButton) rowView.findViewById(R.id.remove_button);
            text_sl = (TextView) rowView.findViewById(R.id.text_sl);

            text_sl.setText(text[position]);
            b2.setImageResource(button[position]);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Hello There", Toast.LENGTH_SHORT).show();
                }
            });
            return rowView;
        }
    }
}
