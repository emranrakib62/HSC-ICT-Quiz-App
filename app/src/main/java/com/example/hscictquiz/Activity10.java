package com.example.hscictquiz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class Activity10 extends AppCompatActivity {
    ListView listView;
    ArrayList<HashMap<String, String>> arrayList;
    MyAdapter myAdapter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_10);

        listView = findViewById(R.id.list);
        arrayList = new ArrayList<>();

        // Sample data (6 items)
        addItem("1ST Chapter All MCQ", "At a glance");
        addItem("QUIZ TEST-1", "25 MCQ\nTime Limit 20min");
        addItem("QUIZ TEST-2", "25 MCQ\nTime Limit 20min");
        addItem("QUIZ TEST-3", "25 MCQ\nTime Limit 20min");
        addItem("QUIZ TEST-4", "25 MCQ\nTime Limit 20min");

        // Set adapter
        myAdapter = new MyAdapter(this, arrayList);
        listView.setAdapter(myAdapter);

        // Handle item clicks, each item opens a different activity
        listView.setOnItemClickListener((adapterView, view, position, id) -> {
            Intent intent;

            switch (position) {
                case 0:
                    intent = new Intent(Activity10.this, Activity16.class);
                    break;
                case 1:
                    intent = new Intent(Activity10.this, Activity17.class);
                    break;
                case 2:
                    intent = new Intent(Activity10.this, Activity18.class);
                    break;
                case 3:
                    intent = new Intent(Activity10.this, Activity19.class);
                    break;
                case 4:
                    intent = new Intent(Activity10.this, Activity20.class);
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + position);
            }

            // Pass data to the next activity
            intent.putExtra("name", arrayList.get(position).get("name"));
            intent.putExtra("mobile", arrayList.get(position).get("mobile"));
            startActivity(intent);
        });
    }

    private void addItem(String name, String mobile) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", name);
        hashMap.put("mobile", mobile);
        arrayList.add(hashMap);
    }

    private static class MyAdapter extends BaseAdapter {
        Context context;
        ArrayList<HashMap<String, String>> data;
        LayoutInflater inflater;

        public MyAdapter(Context context, ArrayList<HashMap<String, String>> data) {
            this.context = context;
            this.data = data;
            this.inflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int position) {
            return data.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = inflater.inflate(R.layout.item_1, parent, false);

            TextView tvName = view.findViewById(R.id.tvname);
            TextView tvMobile = view.findViewById(R.id.tvmobile);

            HashMap<String, String> hashMap = data.get(position);
            tvName.setText(hashMap.get("name"));
            tvMobile.setText(hashMap.get("mobile"));

            return view;
        }
    }
}
