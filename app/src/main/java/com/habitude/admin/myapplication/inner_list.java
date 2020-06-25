package com.habitude.admin.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class inner_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inner_list);

        final DBhelper1 helper = new DBhelper1(getBaseContext(), null, null, 0);

        final ListView lv = (ListView) findViewById(R.id.listView);
        final ArrayList<String> al = new ArrayList<String>();
        Cursor cur = null;
        cur = helper.selRecs1();
        if (cur != null && cur.moveToNext()) {
            al.clear();
            cur.moveToFirst();
            {
                do {
                    al.add(cur.getString(0));
                } while (cur.moveToNext());
            }
        }
        lv.setAdapter((ListAdapter) new ArrayAdapter<String>(inner_list.this, android.R.layout.simple_list_item_1, al));

        registerForContextMenu(lv);

        /*lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) parent.getItemAtPosition(position);
                lol = value;


                return false;
            }
        });*/
    }
}
