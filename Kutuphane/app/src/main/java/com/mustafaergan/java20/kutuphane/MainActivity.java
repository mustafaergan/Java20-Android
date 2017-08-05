package com.mustafaergan.java20.kutuphane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MyDB myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myDB = new MyDB(getApplicationContext());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bilgi,menu);
        return true;
    }

    public void goster(MenuItem menuItem){
        Intent inIntent = new Intent(MainActivity.this,
                Main2Activity.class);
        startActivity(inIntent);
    }

    public void veriEkle(View view){
        String id = ((EditText)findViewById(R.id.id)).getText().toString();
        String name = ((EditText)findViewById(R.id.name)).getText().toString();
        Kitap kitap = new Kitap();
        kitap.setId(Integer.parseInt(id));
        kitap.setName(name);
        myDB.insertKitap(kitap);
        Toast.makeText(MainActivity.this, name + " Veri Ekledi", Toast.LENGTH_SHORT).show();
        ((EditText)findViewById(R.id.name)).setText("");
        ((EditText)findViewById(R.id.id)).setText("");
    }
}
