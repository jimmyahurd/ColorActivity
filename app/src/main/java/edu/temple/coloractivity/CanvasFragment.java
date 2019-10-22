package edu.temple.coloractivity;


import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class CanvasFragment extends Fragment {

    View background;

    public CanvasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        background = inflater.inflate(R.layout.fragment_canvas, container, false);
        return background;
    }

    public void changeColor(int color){
        background.setBackgroundColor(color);
    }
}
