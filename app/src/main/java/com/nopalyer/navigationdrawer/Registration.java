package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class Registration extends AppCompatActivity {

    Toolbar toolbar;
    private CardView btechreg,bonafide;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registration");
        toolbar.setTitleTextColor(Color.WHITE);

        final CardView btechreg = findViewById(R.id.btechreg);
        CardView bonafide = findViewById(R.id.bonafide);

        btechreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registration.this,Btech_registration.class);
                startActivity(i);
            }
        });

        bonafide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Registration.this,Bonafide_Application.class);
                startActivity(i);
            }
        });



    }
}
