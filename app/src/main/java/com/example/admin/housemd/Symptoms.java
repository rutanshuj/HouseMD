package com.example.admin.housemd;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class Symptoms extends AppCompatActivity {

    final ArrayList<String> selectedItems = new ArrayList<>();
    final ArrayList<String> allitems = new ArrayList<>();

    EditText inputSearch;
    ListView check, select;
    CheckedTextView textview;
    Button b;

    String[] items = {"Nuasea", "asffds","dsfsfdsf","cdcdcdc", "asjhhaksf"};
    String[] text = {"asd", "sad", "cdcd", "sadaasd"};
    Integer[] integer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_symptoms);

        //ListAdapter1 adapter1 = new ListAdapter1(getApplicationContext(),textview);
        //check.setAdapter(adapter1);

        for (int i=0;i<items.length;i++) {
            selectedItems.add(items[i]);
        }

        for (int j=0;j<text.length;j++)
        {
            allitems.add(text[j]);
        }

        textview = (CheckedTextView) findViewById(R.id.txt_lan);

        final ListAdapter1 adapter1 = new ListAdapter1(getApplicationContext(),allitems);
        check = (ListView) findViewById(R.id.symptoms_list_view);
        check.setAdapter(adapter1);
/*
        check.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.simplerow,R.id.txt_lan, text);
        check.setAdapter(adapter);
*/
        final ListAdapter2 adapter2 = new ListAdapter2(getApplicationContext(),selectedItems,integer);
        select = (ListView) findViewById(R.id.checkedList);
        select.setAdapter(adapter2);

        inputSearch = (EditText) findViewById(R.id.inputSearch);

        check.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                String item_selected = ((TextView) view).getText().toString();
                String data=(String)adapterView.getItemAtPosition(i);

                if (selectedItems.contains(data))
                {
                    selectedItems.remove(data);
                    allitems.add(data);
                    select.setAdapter(adapter2);
                }
                else
                {
                    selectedItems.add(data);
                    select.setAdapter(adapter2);
                    allitems.remove(data);
                    check.setAdapter(adapter1);
                }
            }
        });

/*
        b = (Button) findViewById(R.id.remove_button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectedItems.remove(select.getSelectedItem());
            }
        });
*/

    }
}

/*

        ListAdapter1 adapter1 = new ListAdapter1((FragmentActivity) getApplicationContext(), textview);
        final ListAdapter2 adapter2 = new ListAdapter2((FragmentActivity) getApplicationContext(), text,integer);


        select = (ListView) findViewById(R.id.symptoms_list_view);


        select.setAdapter(adapter2);

        check.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        inputSearch = (EditText) findViewById(R.id.inputSearch);

        check.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((TextView) view).getText().toString();

                if(selectedItem.contains(selectedItem)){
                    selectedItems.remove(selectedItem);
                    select.setAdapter(adapter2);

                }
                else {
                    selectedItems.add(selectedItem);
                    select.setAdapter(adapter2);
                    select.isShown();
                }
            }
        });
    }
*/
    /*final ArrayList<String> selectedItems = new ArrayList<>();
    EditText inputSearch;
    TextView text_sl;
    Button b1;
    ImageButton b2;

    public class CheckedListAdapter extends ArrayAdapter {

        public CheckedListAdapter(Context context, ArrayList<String> text, ImageButton button) {
            super(context, R.layout.checkedrow );
            this.context = (Activity) context;
            this.text = text;
            this.button = button;
        }
        private final  Activity context;
        private final ArrayList<String> text;
        private final ImageButton button;


        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View rowView = inflater.inflate(R.layout.checkedrow, null, true);

            b2 = (ImageButton) rowView.findViewById(R.id.remove_button);
            text_sl = (TextView) rowView.findViewById(R.id.text_sl);

            text_sl.setText(text.get(position));
            b2.setImageResource(R.mipmap.ic_launcher);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "Hello There", Toast.LENGTH_SHORT).show();
                }
            });
            return rowView;
        }
    }

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

        final CheckedListAdapter adapter2 = new CheckedListAdapter(getContext(),selectedItems,b2);

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
}
*/