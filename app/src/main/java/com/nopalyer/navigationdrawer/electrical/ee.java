package com.nopalyer.navigationdrawer.electrical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;


public class ee extends AppCompatActivity {


    CardView cv1,cv2,cv3,cv4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ee_ee);

        cv1 = (CardView) findViewById(R.id.cv1);
        cv2 = (CardView) findViewById(R.id.cv2);
        cv3 = (CardView) findViewById(R.id.cv3);
        cv4 = (CardView) findViewById(R.id.cv4);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Electrical Engineering Department");

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ee.this, eeaboutus.class);
                startActivity(intent);
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ee.this, eevision.class);
                startActivity(intent);
            }
        });

        cv3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ee.this, eeprogrammes.class);
                startActivity(intent);
            }
        });

        cv4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ee.this, eelabs.class);
                startActivity(intent);
            }
        });




    }

}
