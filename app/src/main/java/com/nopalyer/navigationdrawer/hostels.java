package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class hostels extends AppCompatActivity {
    Button btn_hostelbooklet,btn_functionaries;
    private CardView agh_card,pgh_card,kbh_card,him_card,hi_card,ud_card,ar_card,sat_card,dau_card,shiv_card,neel_card,mani_card,vin_card,info_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostels);

        btn_hostelbooklet=(Button)  findViewById(R.id.pdfhostelbooklet);
        btn_functionaries=(Button)  findViewById(R.id.pdffunctionaries);

        btn_hostelbooklet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(hostels.this,hostelbooklet.class);
                startActivity(i);
            }
        });
        btn_functionaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(hostels.this,functionaries.class);
                startActivity(i);
            }
        });

        agh_card=(CardView) findViewById(R.id.agh_card);
        pgh_card=(CardView) findViewById(R.id.pgh_card);
        kbh_card=(CardView) findViewById(R.id.kbh_card);
        him_card=(CardView) findViewById(R.id.him_card);
        hi_card=(CardView) findViewById(R.id.hi_card);
        ud_card=(CardView) findViewById(R.id.ud_card);
        ar_card=(CardView) findViewById(R.id.ar_card);
        sat_card=(CardView) findViewById(R.id.sat_card);
        dau_card=(CardView) findViewById(R.id.dau_card);
        shiv_card=(CardView) findViewById(R.id.shiv_card);
        neel_card=(CardView) findViewById(R.id.neel_card);
        mani_card=(CardView) findViewById(R.id.mani_card);
        vin_card=(CardView) findViewById(R.id.vin_card);
        info_card=(CardView) findViewById(R.id.info_card);

        agh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(hostels.this,"Na Ho Paega",Toast.LENGTH_SHORT);
                startActivity(new Intent(hostels.this,ambika.class));
            }
        });
        pgh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,pgh.class));

            }
        });
        kbh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,kbh.class));

            }
        });
        him_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,himadri.class));

            }
        });
        hi_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,himgiri.class));

            }
        });
        ud_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,udaygiri.class));

            }
        });
        ar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,aravali.class));

            }
        });
        sat_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,satp.class));

            }
        });
        dau_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,daul.class));

            }
        });
        shiv_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,shivalik.class));

            }
        });
        neel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,neel.class));

            }
        });
        mani_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,mani.class));

            }
        });
        vin_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,vind.class));

            }
        });
        info_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this,info.class));

            }
        });
    }
}

