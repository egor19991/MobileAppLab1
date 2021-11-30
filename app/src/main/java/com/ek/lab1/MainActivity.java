package com.ek.lab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;

import java.util.Calendar;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    String[] locomotive = { "ЭР 2", "ТЭП 60", "ВЛ 8", "ЧС 2", "ЭР 200"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);

        SimpleDateFormat df = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        String formattedDate = df.format(Calendar.getInstance().getTime());
        TextView textView = findViewById(R.id.textView);
        textView.setText("Date: "+formattedDate);

        EditText editText = findViewById(R.id.editText);
        editText.addTextChangedListener(new TextWatcher(){
            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                TextView textView = findViewById(R.id.textView2);
                textView.setText(s);
            }
        });

                Spinner spinner = findViewById(R.id.spinner);
        // Создаем адаптер ArrayAdapter с помощью массива строк и стандартной разметки элемета spinner
        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, locomotive);
        // Определяем разметку для использования при выборе элемента
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Применяем адаптер к элементу spinner
        spinner.setAdapter(adapter);

        AdapterView.OnItemSelectedListener itemSelectedListener = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Получаем выбранный объект
                String item = (String)parent.getItemAtPosition(position);
                //selection.setText(item);
                TextView textView = findViewById(R.id.textView2);
                ImageView image = (ImageView)findViewById(R.id.imageView);
                switch (item) {
                    case  ("ЭР 2"):
                        image.setImageResource(R.drawable.er2);
                        break;
                    case ("ТЭП 60"):
                        image.setImageResource(R.drawable.tep60);
                        break;
                    case ("ВЛ 8"):
                        image.setImageResource(R.drawable.vl8);
                        break;
                    case ("ЧС 2"):
                        image.setImageResource(R.drawable.chs2);
                        break;
                    case ("ЭР 200"):
                        image.setImageResource(R.drawable.er200);
                        break;
                    default:
                        image.setImageResource(R.drawable.er2);
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        };
        spinner.setOnItemSelectedListener(itemSelectedListener);


    }
}