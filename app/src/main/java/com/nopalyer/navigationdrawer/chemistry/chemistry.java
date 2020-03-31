package com.nopalyer.navigationdrawer.chemistry;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class chemistry extends AppCompatActivity {
    ViewFlipper slider;
    CardView about5,programmes5,vision5,labs5;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_chemistry);
        vision5 = findViewById(R.id.vision1);
        programmes5 = findViewById(R.id.programmes);
        about5 = findViewById(R.id.about);
        slider = findViewById(R.id.slide);
        labs5 = findViewById(R.id.labs);
        toolbar.setTitleTextColor(Color.WHITE);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chemistry Department");

        int[] images = {R.drawable.chemistry1, R.drawable.chemistry1};
        for(int image:images)
        {FlipperImages(image);

        }
        about5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemistryaboutus.class));
            }
        });
        vision5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemission.class));
            }
        });
        programmes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemprogrammes.class));
            }
        });
        labs5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemistrylabs.class));
            }
        });
    }
    public void FlipperImages(int image){
        ImageView imageview = new ImageView(this);
        imageview.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageview.setBackgroundResource(image);

        slider.addView(imageview);
        slider.setFlipInterval(2500);
        slider.setAutoStart(true);
        slider.setInAnimation(this,android.R.anim.slide_in_left);
        slider.setOutAnimation(this,android.R.anim.slide_out_right);
    }

}
