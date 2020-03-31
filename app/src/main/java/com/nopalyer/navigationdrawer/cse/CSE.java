package com.nopalyer.navigationdrawer.cse;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class CSE extends AppCompatActivity {

    ViewFlipper slider;
    CardView cv1,cv2,cv3,cv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse_cse);

        cv1 = (CardView) findViewById(R.id.cv1);
        cv2 = (CardView) findViewById(R.id.cv2);
        cv3 = (CardView) findViewById(R.id.cv3);
        cv4 = (CardView) findViewById(R.id.cv4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CSE Department");

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSE.this,cseaboutus.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSE.this,csevision.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSE.this, cseprogrammes.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CSE.this,cselabs.class);
                startActivity(intent);
            }
        });



        slider = findViewById(R.id.slide);
        int[] images = {R.drawable.computercentre, R.drawable.cse, R.drawable.glab};
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

