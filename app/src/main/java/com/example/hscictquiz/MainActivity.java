package com.example.hscictquiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private GridView gridView;
    private ImageSlider imageSlider;

    private final int[] images = {
            R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic_2, R.drawable.unnamed, R.drawable.pic_3
    };

    private final String[] titles = {
            "প্রথম অধ্যায়", "দ্বিতীয় অধ্যায়", "তৃতীয় অধ্যায়",
            "চতুর্থ  অধ্যায়", "পঞ্চম অধ্যায়", "ষষ্ঠ অধ্যায়"
    };

    private final Class<?>[] activities = {
            Activity10.class, Activity11.class, Activity12.class,
            Activity13.class, Activity14.class, Activity15.class
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridView = findViewById(R.id.gridview);

        GridAdapter adapter = new GridAdapter(this, images, titles);
        gridView.setAdapter(adapter);


        gridView.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, activities[position]);
            startActivity(intent);
        });

        setupImageSlider();
    }

    private void setupImageSlider() {
        List<SlideModel> slideModels = new ArrayList<>();
        slideModels.add(new SlideModel(R.drawable.city1, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.city2, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.city3, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.city4, ScaleTypes.FIT));
        slideModels.add(new SlideModel(R.drawable.city5, ScaleTypes.FIT));

        imageSlider.setImageList(slideModels);
    }





}
