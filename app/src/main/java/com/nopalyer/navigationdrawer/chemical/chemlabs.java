package com.nopalyer.navigationdrawer.chemical;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;

import com.nopalyer.navigationdrawer.R;

public class chemlabs extends AppCompatActivity {

    ViewFlipper slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_chemlabs);


        slider = findViewById(R.id.slide);
        int[] images = {R.drawable.inorganiclab, R.drawable.pginorgnaiclab, R.drawable.uglab};
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
