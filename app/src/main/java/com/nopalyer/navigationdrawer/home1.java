package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class home1 extends AppCompatActivity {
    private CardView dir_card,pl_card,mag_card,map_card;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);

        dir_card=(CardView) findViewById(R.id.dir_card);
        pl_card=(CardView) findViewById(R.id.pl_card);
        map_card=(CardView) findViewById(R.id.map_card);
        mag_card=(CardView) findViewById(R.id.mag_card);

        dir_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(home1.this,"Na Ho Paega",Toast.LENGTH_SHORT);
                startActivity(new Intent(home1.this,dir.class));
            }
        });
        pl_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this,pl.class));

            }
        });
        map_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this,map.class));

            }
        });
        mag_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(home1.this,mag.class));

            }
        });


    }
}
