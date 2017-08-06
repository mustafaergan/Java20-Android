package com.mustafaergan.java20.titresim;

import android.content.Context;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.button = (Button) findViewById(R.id.bTitret);

        this.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.eTSaniye);
                String veri = editText.getText().toString();
                Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibrator.vibrate(Long.parseLong(veri));
                button.setTextSize(editText.getTextSize()+10);
                Toast.makeText(MainActivity.this, "Titriyorum", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
