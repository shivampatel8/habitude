package com.habitude.admin.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list extends AppCompatActivity {
    private String lol;
    final String Type = "pending";
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        final EditText et1 = (EditText) findViewById(R.id.editText);
        final Button badd = (Button) findViewById(R.id.button4);
        final DBhelper1 helper = new DBhelper1(getBaseContext(), null, null, 0);
        final EditText ed = (EditText) findViewById(R.id.editText);
        final ListView lv = (ListView) findViewById(R.id.listView);
        final ArrayList<String> al = new ArrayList<String>();

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et1.setText("");
            }
        });
        Cursor cur = null;
        cur = helper.selRecs2();
        if (cur != null && cur.moveToNext()) {
            al.clear();
            cur.moveToFirst();
            {
                do {
                    al.add(cur.getString(0));
                } while (cur.moveToNext());
            }
        }
        lv.setAdapter((ListAdapter) new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_1, al));

        registerForContextMenu(lv);

        badd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                helper.inRecords(ed.getText().toString());
                Cursor cur = helper.selRecs2();
                al.clear();
                cur.moveToFirst();
                {
                    do {
                        al.add(cur.getString(0));
                    } while (cur.moveToNext());
                }
                lv.setAdapter((ListAdapter) new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_1, al));
                ed.setText("I will ");
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                String value = (String) parent.getItemAtPosition(position);
                lol = value;


                return false;
            }
        });
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle(lol);
        menu.add(0, v.getId(), 0, "Delete Task");
        menu.add(0, v.getId(), 0, "Completed");

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getTitle() == "Delete Task") {
            final DBhelper1 helper = new DBhelper1(getBaseContext(), null, null, 0);
            helper.deleterow(lol);
            Toast.makeText(this, "Deleted " + lol, Toast.LENGTH_SHORT).show();
            final ArrayList<String> al = new ArrayList<String>();
            final ListView lv = (ListView) findViewById(R.id.listView);
            Cursor cur = null;
            cur = helper.selRecs2();
            if (cur != null && cur.moveToNext()) {
                al.clear();
                cur.moveToFirst();
                {
                    do {
                        al.add(cur.getString(0));
                    } while (cur.moveToNext());
                }
            }
            lv.setAdapter((ListAdapter) new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_1, al));

        } else if (item.getTitle() == "Completed") {
            final DBhelper1 helper = new DBhelper1(getBaseContext(), null, null, 0);
            helper.update(lol);

            final ArrayList<String> al = new ArrayList<String>();
            final ListView lv = (ListView) findViewById(R.id.listView);
            Cursor cur = null;
            cur = helper.selRecs2();
            if (cur != null && cur.moveToNext()) {
                al.clear();
                cur.moveToFirst();
                {
                    do {
                        al.add(cur.getString(0));
                    } while (cur.moveToNext());
                }
            }
            lv.setAdapter((ListAdapter) new ArrayAdapter<String>(list.this, android.R.layout.simple_list_item_1, al));
            Toast.makeText(this, "Task Completed", Toast.LENGTH_SHORT).show();
        } else {
            return false;
        }
        return true;
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
        menu.add(0, 0, 0, "Status");
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (item.getTitle() == "Status") {
            Intent aca = new Intent(getApplicationContext(), inner_list.class);

            startActivity(aca);
        }

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }
*/
        return super.onOptionsItemSelected(item);
    }
}


