package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    ListView listView;
    java.util.List list = new ArrayList();
    public ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        listView = (ListView) findViewById(R.id.list_view);
        //list.addAll();

        /*list.add("orange");
        list.add("banana");
        list.add("apple");
        list.add("peach");
        list.add("pear");
        list.add("berry");
        list.add("beer");
        list.add("chocolate");
        list.add("soda");
        list.add("rum");
        list.add("ECE");
        list.add("SYDE");
        list.add("ENG");
        list.add("banana");
        list.add("banana");
        list.add("banana");
        list.add("banana");
        list.add("banana");
        list.add("banana");
        list.add("banana");
        list.add("banana");*/

        adapter = new ArrayAdapter(List.this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(adapter);
    }
}
