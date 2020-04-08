package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class home1 extends AppCompatActivity {
    private CardView city_card,college_card,srijan_card,vision_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutnith);
        city_card=(CardView) findViewById(R.id.city_card);
        college_card=(CardView) findViewById(R.id.college_card);
        srijan_card=(CardView) findViewById(R.id.srijan_card);
        vision_card=(CardView) findViewById(R.id.vision_card);

        city_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this, about_city.class));
            }
        });





        college_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this, about_college.class));
            }
        });



        srijan_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this, srijan.class));
            }
        });




        vision_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this, vision.class));


            }
        });

    }
}
