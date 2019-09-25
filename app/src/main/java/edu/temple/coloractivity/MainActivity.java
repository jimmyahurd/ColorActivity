package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Spinner colorPicker;
    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String colors[] = {"Red", "Blue", "Green", "Yellow", "Cyan", "Grey", "Magenta", "Purple", "Cyan", "Silver", "Black"};

        colorPicker = findViewById(R.id.colorPicker);
        layout = findViewById(R.id.layoutID);

        ColorAdapter adapter = new ColorAdapter(colors, MainActivity.this);
        colorPicker.setAdapter(adapter);
        colorPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String color = (String)parent.getAdapter().getItem(position);
                layout.setBackgroundColor(Color.parseColor(color));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
