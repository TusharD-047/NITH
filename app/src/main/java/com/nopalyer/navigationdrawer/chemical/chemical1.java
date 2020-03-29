package com.nopalyer.navigationdrawer.chemical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class chemical1 extends AppCompatActivity {

    CardView about,vision,programmes,labs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chemical_chemical1);
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
