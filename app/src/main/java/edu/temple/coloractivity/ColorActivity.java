package edu.temple.coloractivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;

public class ColorActivity extends AppCompatActivity implements PaletteFragment.OnColorChosen {

    Fragment CanvasFragment;
    String colors[];
    String backgrounds[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = this.getResources().getStringArray(R.array.colors);
        backgrounds = this.getResources().getStringArray(R.array.backgrounds);

        CanvasFragment = new CanvasFragment();

        getSupportFragmentManager().beginTransaction()
                .add(R.id.PaletteContainer, edu.temple.coloractivity.PaletteFragment.newInstance(colors, backgrounds))
                .add(R.id.CanvasContainer, CanvasFragment)
                .commit();
    }

    @Override
    public void colorChosen(int position) {
        int color = Color.parseColor(backgrounds[position]);
        ((CanvasFragment) CanvasFragment).changeColor(color);
    }
}
