package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class PaletteActivity extends AppCompatActivity {

    Spinner colorPicker;
    static String backgrounds[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String colors[] = this.getResources().getStringArray(R.array.colors);
        backgrounds = this.getResources().getStringArray(R.array.backgrounds);

        colorPicker = findViewById(R.id.colorPicker);

        ColorAdapter adapter = new ColorAdapter(colors, backgrounds,PaletteActivity.this);
        colorPicker.setAdapter(adapter);
        colorPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0) {
                    String color = PaletteActivity.backgrounds[position];
                    Intent intent = new Intent(PaletteActivity.this, CanvasActivity.class);
                    intent.putExtra("edu.temple.coloractivity.COLOR", color);
                    startActivity(intent);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }
}
