package com.nopalyer.navigationdrawer.ece;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class ece extends AppCompatActivity {
    ViewFlipper slider;
    CardView about2,vision2,programmes2,labs2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ece_ece);
        programmes2 = findViewById(R.id.programmes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("ECE Department");

        about2 = findViewById(R.id.about);
        vision2= findViewById(R.id.vision1);
        labs2 = findViewById(R.id.labs);
        slider = findViewById(R.id.slide);
        int[] images = {R.drawable.ece1, R.drawable.ece2};
        for(int image:images)
        {FlipperImages(image);


        }
        about2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ece.this,eceaboutus.class));
            }
        });
        vision2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ece.this,ecevision.class));
            }
        });
        programmes2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ece.this,eceprogrammes.class));
            }
        });
        labs2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ece.this,ecelabs.class));
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

