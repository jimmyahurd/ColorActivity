package edu.temple.coloractivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OnColorChosen} interface
 * to handle interaction events.
 * Use the {@link PaletteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PaletteFragment extends Fragment {
    private static final String COLOR_KEY = "colors";
    private static final String BACKGROUND_KEY = "backgrounds";
    private String[] colors;
    private String[] backgrounds;
    private OnColorChosen parent;

    public PaletteFragment() {
        // Required empty public constructor
    }
    public static PaletteFragment newInstance(String[] colors, String[] backgrounds) {
        PaletteFragment fragment = new PaletteFragment();
        Bundle args = new Bundle();
        args.putStringArray(COLOR_KEY, colors);
        args.putStringArray(BACKGROUND_KEY, backgrounds);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            colors = getArguments().getStringArray(COLOR_KEY);
            backgrounds = getArguments().getStringArray(BACKGROUND_KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Spinner colorPicker = (Spinner) inflater.inflate(R.layout.fragment_palette, container, false);
        colorPicker.setAdapter(new ColorAdapter(colors, backgrounds, (Context) parent));
        colorPicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View view, int position, long id) {
                if(position != 0)
                    parent.colorChosen(position);
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        return colorPicker;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnColorChosen) {
            parent = (OnColorChosen) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnColorChosen");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        parent = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnColorChosen {
        void colorChosen(int position);
    }
}
