package com.nopalyer.navigationdrawer.mechanical;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nopalyer.navigationdrawer.R;

public class melabs extends AppCompatActivity {

    ViewFlipper slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.me_melabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Labs");

        slider = findViewById(R.id.slide);
        int[] images = {R.drawable.machineshop, R.drawable.turningshop1, R.drawable.practicaltraining};
        for(int image:images)
        {FlipperImages(image);
        }
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
