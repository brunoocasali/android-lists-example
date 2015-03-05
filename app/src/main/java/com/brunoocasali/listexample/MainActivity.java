package com.brunoocasali.listexample;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity{

    private List<String> names = new ArrayList<>();
    private ArrayAdapter<String> adapter;
    static final int ADD_NAME = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Names List!");

        ListView list = getListView();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, names);

        list.setAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        String selectedName = names.get(position);

        Toast.makeText(this, selectedName, Toast.LENGTH_LONG).show();
    }

    public void include(View view){
        Intent intent = new Intent(this, DataIncludeActivity.class);
        this.startActivityForResult(intent, ADD_NAME);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        names.add(data.getStringExtra(DataIncludeActivity.PUBLIC_STATIC_STRING_IDENTIFIER));
        adapter.notifyDataSetChanged();
    }
}
