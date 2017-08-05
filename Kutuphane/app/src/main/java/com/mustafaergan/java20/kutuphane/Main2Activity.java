package com.mustafaergan.java20.kutuphane;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        MyDB myDB = new MyDB(getApplicationContext());
        ListView listView = (ListView) findViewById(R.id.listView);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getApplicationContext(),android.R.layout.simple_list_item_1,
                        android.R.id.text1,myDB.getKitapListesiString());

        listView.setAdapter(arrayAdapter);


    }
}
