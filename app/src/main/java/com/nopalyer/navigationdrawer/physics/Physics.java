package com.nopalyer.navigationdrawer.physics;

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

public class Physics extends AppCompatActivity {

    ViewFlipper slider;
    CardView about7,programmes7,vision7,labs7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_chemistry);
        vision7 = findViewById(R.id.vision1);
        programmes7 = findViewById(R.id.programmes);
        about7 = findViewById(R.id.about);
        slider = findViewById(R.id.slide);
        labs7 = findViewById(R.id.labs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Physics Department");
        toolbar.setTitleTextColor(Color.WHITE);

        int[] images = {R.drawable.chemistry1, R.drawable.chemistry1};
        for(int image:images)
        {FlipperImages(image);

        }
        about7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Physics.this, physicsaboutus.class));
            }
        });
        vision7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Physics.this, physicsmission.class));
            }
        });
        programmes7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Physics.this, physicsprogrammes.class));
            }
        });
        labs7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Physics.this, physicslabs.class));
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
