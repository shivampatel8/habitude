package com.habitude.admin.myapplication;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class current extends AppCompatActivity {
    String lol = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current);
        final ListView lv = (ListView) findViewById(R.id.listview);
        final DBhelper helper = new DBhelper(getBaseContext(), null, null, 0);
        Cursor cur = null;
        cur = helper.selRecs();
        List<String> al = new ArrayList<String>();
        if (cur != null && cur.moveToNext()) {
            al.clear();
            cur.moveToFirst();
            {
                do {
                    al.add(cur.getString(0));
                } while (cur.moveToNext());
            }
        }

        lv.setAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al));
        registerForContextMenu(lv);
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) parent.getItemAtPosition(position);
                lol = value;


                return false;
            }
        });


    }

    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(lol);
        menu.add(0, v.getId(), 0, "Delete Task");
        //menu.add(0, v.getId(), 0, "Completed");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Delete Task") {
            final DBhelper helper = new DBhelper(getBaseContext(), null, null, 0);
            helper.deleterow(lol);
            Toast.makeText(this, "Deleted " + lol, Toast.LENGTH_SHORT).show();
            final ArrayList<String> al = new ArrayList<String>();
            final ListView lv = (ListView) findViewById(R.id.listview);
            Cursor cur = null;
            cur = helper.selRecs();
            if (cur != null && cur.moveToNext()) {
                al.clear();
                cur.moveToFirst();
                {
                    do {
                        al.add(cur.getString(0));
                    } while (cur.moveToNext());
                }

            } else if (!cur.moveToNext()) {
                al.clear();
                lv.setAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al));
            }
            lv.setAdapter((ListAdapter) new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, al));

        }  /*else if (item.getTitle() == "Completed") {
            final DBhelper helper=new DBhelper(getBaseContext(), null, null, 0);
            helper.update(lol);

            final ArrayList<String> al=new ArrayList<String>();
            final ListView lv =(ListView)findViewById(R.id.listView);
            Cursor cur = null;
            cur = helper.selRecs();
            if (cur != null && cur.moveToNext()) {
                al.clear();
                cur.moveToFirst();
                {
                    do {
                        al.add(cur.getString(0));
                    } while (cur.moveToNext());
                }
            }
            lv.setAdapter((ListAdapter) new ArrayAdapter<String>(current.this, android.R.layout.simple_list_item_1, al));
            Toast.makeText(this, "Task Completed", Toast.LENGTH_SHORT).show();
        }  */ else {
            return false;
        }
        return true;
    }
}



