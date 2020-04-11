package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class daul extends AppCompatActivity {
    ImageView img14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daul);
        img14 = (ImageView)findViewById(R.id.img14);
        Glide.with(this).load(R.drawable.dhauladhar).placeholder(R.drawable.dhauladhar).into(img14);
    }
}
