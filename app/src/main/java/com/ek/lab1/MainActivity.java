package com.ek.lab1;

import androidx.appcompat.app.AppCompatActivity;


import android.icu.text.SimpleDateFormat;
import android.widget.TextView;
import android.os.Bundle;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(Calendar.getInstance().getTime());
        TextView textView = findViewById(R.id.textView);
        textView.setText("Date: "+formattedDate);

    }
}