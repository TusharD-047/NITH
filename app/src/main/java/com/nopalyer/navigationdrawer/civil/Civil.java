package com.nopalyer.navigationdrawer.civil;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;

public class Civil extends AppCompatActivity {

    CardView about4,vision4,programmes4,labs4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.civil_civil);
        programmes4 = findViewById(R.id.programmes);
        about4 = findViewById(R.id.about);
        vision4= findViewById(R.id.vision1);
        labs4 = findViewById(R.id.labs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Civil Engineering Department");
        toolbar.setTitleTextColor(Color.WHITE);

        about4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil.this, civilaboutus.class));
            }
        });
        vision4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil.this, civilvision.class));
            }
        });
        programmes4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil.this, civilprogrammes.class));
            }
        });
        labs4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Civil.this,civillabs.class));
            }
        });

    }

}
