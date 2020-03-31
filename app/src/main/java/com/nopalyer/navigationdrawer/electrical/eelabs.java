package com.nopalyer.navigationdrawer.electrical;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nopalyer.navigationdrawer.R;

public class eelabs extends AppCompatActivity {

    ViewFlipper slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ee_eelabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Labs");

        slider = findViewById(R.id.slide);
        int[] images = {R.drawable.eelab1, R.drawable.eelab3, R.drawable.eelab4, R.drawable.eelab5, R.drawable.eelab6, R.drawable.eelab7};
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
