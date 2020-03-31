package com.nopalyer.navigationdrawer.math;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class maths extends AppCompatActivity {

    ViewFlipper slider;
    CardView about6,programmes6,vision6,labs6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_chemistry);
        vision6 = findViewById(R.id.vision1);
        programmes6 = findViewById(R.id.programmes);
        about6 = findViewById(R.id.about);
        slider = findViewById(R.id.slide);
        labs6 = findViewById(R.id.labs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Maths Department");

        int[] images = {R.drawable.chemistry1, R.drawable.chemistry1};
        for(int image:images)
        {FlipperImages(image);

        }
        about6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(maths.this,mathsaboutus.class));
            }
        });
        vision6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(maths.this,mathission.class));
            }
        });
        programmes6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(maths.this,mathsprogrammes.class));
            }
        });
        labs6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(maths.this,mathslabs.class));
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

