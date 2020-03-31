package com.nopalyer.navigationdrawer.material;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class material extends AppCompatActivity {


    CardView about3,vision3,programmes3,labs3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.material_material);
        about3 = findViewById(R.id.about);
        vision3 = findViewById(R.id.vision1);
        labs3 = findViewById(R.id.labs);
        programmes3 = findViewById(R.id.programmes);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("CMSE Department");

        about3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(material.this,materialaboutus.class));
            }
        });
        vision3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(material.this,materialvision.class));
            }
        });
        programmes3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(material.this, materialprogrammes.class));
            }
        });
        labs3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(material.this, matlabs.class));
            }
        });

    }


}
