package com.nopalyer.navigationdrawer.chemistry;

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

public class chemistry extends AppCompatActivity {

    CardView about5,programmes5,vision5,labs5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemistry_chemistry);
        vision5 = findViewById(R.id.vision1);
        programmes5 = findViewById(R.id.programmes);
        about5 = findViewById(R.id.about);
        labs5 = findViewById(R.id.labs);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chemistry Department");
        toolbar.setTitleTextColor(Color.WHITE);


        about5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemistryaboutus.class));
            }
        });
        vision5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemission.class));
            }
        });
        programmes5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemprogrammes.class));
            }
        });
        labs5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemistry.this, chemistrylabs.class));
            }
        });
    }


}
