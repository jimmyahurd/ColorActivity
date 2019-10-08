package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class CanvasActivity extends AppCompatActivity {

    View layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        layout = findViewById(R.id.layout);

        Intent intent = getIntent();
        String color = intent.getStringExtra("edu.temple.coloractivity.COLOR");
        layout.setBackgroundColor(Color.parseColor(color));
    }
}
