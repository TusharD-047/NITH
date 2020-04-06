package com.nopalyer.navigationdrawer.math;

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

public class maths extends AppCompatActivity {


    CardView about6,programmes6,vision6,labs6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maths_maths);
        vision6 = findViewById(R.id.vision1);
        programmes6 = findViewById(R.id.programmes);
        about6 = findViewById(R.id.about);
        labs6 = findViewById(R.id.labs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Maths Department");
        toolbar.setTitleTextColor(Color.WHITE);

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


}

