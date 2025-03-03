package com.example.hscictquiz;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GridAdapter extends BaseAdapter {
    private final Context context;
    private final int[] images;
    private final String[] titles;

    public GridAdapter(Context context, int[] images, String[] titles) {
        this.context = context;
        this.images = images;
        this.titles = titles;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView = convertView.findViewById(R.id.titleTextView);

        imageView.setImageResource(images[position]);
        textView.setText(titles[position]);

        return convertView;
    }
}
