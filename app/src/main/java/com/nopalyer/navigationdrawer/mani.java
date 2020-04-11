package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class mani extends AppCompatActivity {
    ImageView img14;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mani);
        img14 = (ImageView)findViewById(R.id.img14);
        Glide.with(this).load(R.drawable.manimahesh).placeholder(R.drawable.manimahesh).into(img14);
    }
}
