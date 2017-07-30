package com.mustafaergan.java20.merhabadunya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tVBasari;
    EditText eTKullaniciAdi;
    EditText eTSifre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
//        EditText editText =
//                (EditText) findViewById(R.id.eTKullaniciAdi);
        this.eTKullaniciAdi = (EditText) findViewById(R.id.eTKullaniciAdi);
        this.eTSifre = (EditText)findViewById(R.id.eTSifre);
        this.tVBasari = (TextView)findViewById(R.id.tVBasarili);
        if(this.eTKullaniciAdi.getText().toString().equals("admin")&&
                this.eTSifre.getText().toString().equals("admin")){
//            this.tVBasari.setText("Giris Başarılı");
            Intent inMahmut = new Intent(MainActivity.this,
                    KullaniciGirisi.class);
            startActivity(inMahmut);
        }else
            this.tVBasari.setText("Giris Başarısız");
    }

}
