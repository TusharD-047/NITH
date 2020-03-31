package com.nopalyer.navigationdrawer.chemical;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class chemical1 extends AppCompatActivity {
    Toolbar toolbar;
    CardView about,vision,programmes,labs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_chemical1);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Chemical Engineering Department");
        toolbar.setTitleTextColor(Color.WHITE);
        vision = findViewById(R.id.vision1);
        programmes = findViewById(R.id.programmes);
        about = findViewById(R.id.about);
        labs = findViewById(R.id.labs);

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemical1.this, chemicalaboutus.class));
            }
        });
        vision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemical1.this, chemicalvision.class));
            }
        });
        programmes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemical1.this, chemicalprogrammes.class));
            }
        });
        labs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(chemical1.this, chemlabs.class));
            }
        });
    }


}
