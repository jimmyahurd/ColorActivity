package edu.temple.coloractivity;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ColorAdapter extends BaseAdapter {
    String[] colors;
    Context context;

    public ColorAdapter(String[] colors, Context context){
        this.colors = colors;
        this.context = context;
    }

    @Override
    public int getCount() {
        return colors.length;
    }

    @Override
    public Object getItem(int position) {
        return colors[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView toReturn;
        if(convertView instanceof TextView)
            toReturn = (TextView) convertView;
        else
            toReturn = new TextView(context);
        toReturn.setText(colors[position]);
        toReturn.setBackgroundColor(Color.WHITE);
        toReturn.setTextSize(24);
        toReturn.setPadding(5,5,5,5);
        return toReturn;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView toReturn = (TextView) getView(position, convertView, parent);
        toReturn.setBackgroundColor(Color.parseColor(colors[position]));
        return toReturn;
    }
}
