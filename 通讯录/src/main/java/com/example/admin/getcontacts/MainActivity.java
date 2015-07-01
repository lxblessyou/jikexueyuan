package com.example.admin.getcontacts;


import android.app.Activity;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {
    private ListView lv;
    private MyAdapter myAdapter;
    private List<Contacts> list = new ArrayList<Contacts>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initList();
        initView();
    }

    private void initList() {
        Utility.getContacts(this, list);
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        myAdapter = new MyAdapter(this,list);
        lv.setAdapter(myAdapter);
    }

}
