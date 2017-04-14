//package com.example.admin.housemd;
//
//import android.support.annotation.Nullable;
//import android.support.v4.app.Fragment;
//import android.os.Bundle;
//import android.text.Editable;
//import android.text.TextWatcher;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.Menu;
//import android.view.MenuInflater;
//import android.view.MenuItem;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.ArrayAdapter;
//import android.widget.Button;
//import android.widget.CheckBox;
//import android.widget.EditText;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SymptomsFrag extends Fragment {
//
//    EditText inputSearch;
//    private ListView mainListView;
//    private mItems[] itemss;
//    private ArrayAdapter<mItems> listAdapter;
//    ArrayList<String> checked = new ArrayList<String>();
//
//    Button b1;
//
//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        final View view = inflater.inflate(R.layout.activity_symptoms_frag, container, false);
//        inputSearch = (EditText) view.findViewById(R.id.inputSearch);
//        b1 = (Button) view.findViewById(R.id.showResult);
//
//        mainListView = (ListView) view.findViewById(R.id.symptoms_list_view);
//        inputSearch = (EditText) view.findViewById(R.id.inputSearch);
//
//
//        //itemss = (mItems[]) getLastNonConfigurationInstance();
//
//        final ArrayList<mItems> symlist = new ArrayList<mItems>();
//
//        symlist.add(new mItems("Cold"));
//        symlist.add(new mItems("High Fever"));
//        symlist.add(new mItems("Sweating"));
//        symlist.add(new mItems("Vomiting"));
//        symlist.add(new mItems("Knee Pain"));
//        symlist.add(new mItems("Ear Pain"));
//        symlist.add(new mItems("Chest Pain"));
//        symlist.add(new mItems("Headache"));
//
//
//        listAdapter = new SelectArralAdapter(this, symlist);
//
//        mainListView.setAdapter(listAdapter);
//
//        mainListView
//                .setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View item,
//                                            int position, long id) {
//                        mItems symptoms = listAdapter.getItem(position);
//                        symptoms.toggleChecked();
//                        SelectViewHolder viewHolder = (SelectViewHolder) item
//                                .getTag();
//                        viewHolder.getCheckBox().setChecked(symptoms.isChecked());
//                        int duration = 500;  //miliseconds
//                        int offset = 0;      //fromListTop
//                        String mess = String.valueOf(symlist.get(position));
//                        //selectedItems.set(offset, );
//
//                    }
//                });
//
//
//        /**
//         * Enabling Search Filter
//         * */
//        inputSearch.addTextChangedListener(new TextWatcher() {
//
//            @Override
//            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
////                // When user changed the Text
////                List.this.listAdapter.getFilter().filter(cs);
//            }
//
//            @Override
//            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
//                                          int arg3) {
//                // TODO Auto-generated method stub
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable arg0) {
//                String message = inputSearch.getText().toString().toLowerCase();
//                listAdapter.getFilter().filter(message);
//            }
//        });
//        return view;
//
////        b1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////                for(int i = 0; i<selectedItems.size(); i++){
////                    if(selectedItems.get(i).isChecked()){
////                        String item = selectedItems.get(i);
////                        item.
////                    }
////                }
////            }
////        });
//    }
//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
//        // TODO Auto-generated method stub
//        menu.add(0, 1, Menu.NONE, "Products");
//        super.onCreateOptionsMenu(menu, menuInflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // TODO Auto-generated method stub
//        switch (item.getItemId()) {
//            case 1:
//
//                for (int i = 0; i < checked.size(); i++) {
//                    Log.d("pos : ", "" + checked.get(i));
//                }
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//
//    public static class mItems{
//        private String name = "";
//        private boolean checked = false;
//
//        public mItems() {
//        }
//
//        public mItems(String name, boolean checked) {
//            this.name = name;
//            this.checked = checked;
//        }
//
//        public mItems(String name) {
//            this.name = name;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public boolean isChecked() {
//            return checked;
//        }
//
//        public void setChecked(boolean checked) {
//            this.checked = checked;
//        }
//
//        public String toString() {
//            return name;
//        }
//        public void toggleChecked(){
//            checked = !checked;
//        }
//    }
//
//    private static class SelectViewHolder{
//        private CheckBox checkBox;
//        private TextView textView;
//
//        public SelectViewHolder() {
//        }
//
//        public SelectViewHolder(TextView textView, CheckBox checkBox) {
//            this.checkBox = checkBox;
//            this.textView = textView;
//        }
//
//        public CheckBox getCheckBox() {
//            return checkBox;
//        }
//
//        public void setCheckBox(CheckBox checkBox) {
//            this.checkBox = checkBox;
//        }
//
//        public TextView getTextView() {
//            return textView;
//        }
//
//        public void setTextView(TextView textView) {
//            this.textView = textView;
//        }
//    }
//
//    /** Custom adapter for displaying an array of Sympton objects. */
//    private static class SelectArralAdapter extends ArrayAdapter<mItems> {
//        private LayoutInflater inflater;
//
//        public SelectArralAdapter(SymptomsFrag context, List<mItems> symlist) {
//            super(context.getContext(), R.layout.simplerow, R.id.rowTextView, symlist);
//            // Cache the LayoutInflate to avoid asking for a new one each time.
//            inflater = LayoutInflater.from(context.getContext());
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            // Symptoms to display
//            mItems symptoms = (mItems) this.getItem(position);
//
//            // The child views in each row.
//            CheckBox checkBox;
//            TextView textView;
//
//            // Create a new row view
//            if (convertView == null) {
//                convertView = inflater.inflate(R.layout.simplerow, null);
//
//                // Find the child views.
//                textView = (TextView) convertView
//                        .findViewById(R.id.rowTextView);
//                checkBox = (CheckBox) convertView.findViewById(R.id.txt_lan);
//                // Optimization: Tag the row with it's child views, so we don't
//                // have to
//                // call findViewById() later when we reuse the row.
//                convertView.setTag(new SelectViewHolder(textView, checkBox));
//                // If CheckBox is toggled, update the planet it is tagged with.
//                checkBox.setOnClickListener(new View.OnClickListener() {
//                    public void onClick(View v) {
//                        CheckBox cb = (CheckBox) v;
//                        mItems symptons = (mItems) cb.getTag();
//                        symptons.setChecked(cb.isChecked());
//                    }
//                });
//            }
//            // Reuse existing row view
//            else {
//                // Because we use a ViewHolder, we avoid having to call
//                // findViewById().
//                SelectViewHolder viewHolder = (SelectViewHolder) convertView
//                        .getTag();
//                checkBox = viewHolder.getCheckBox();
//                textView = viewHolder.getTextView();
//            }
//
//            // Tag the CheckBox with the Planet it is displaying, so that we can
//            // access the planet in onClick() when the CheckBox is toggled.
//            checkBox.setTag(symptoms);
//            // Display planet data
//            checkBox.setChecked(symptoms.isChecked());
//            textView.setText(symptoms.getName());
//            return convertView;
//        }
//    }
//    public Object onRetainNonConfigurationInstance() {
//        return itemss;
//    }
//
//
//}
//
