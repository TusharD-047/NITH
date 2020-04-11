package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.squareup.picasso.Picasso;

import java.io.InputStream;

public class hostels extends AppCompatActivity {

    private CardView agh_card, pgh_card, kbh_card, him_card, hi_card, ud_card, ar_card, sat_card, dau_card, shiv_card, neel_card, mani_card, vin_card, info_card;
    private ImageView ambika, pgh, kbh, himgiri,sat,dau,shiv,neel,mani,vin,himadri,ud,ara;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostels);


        agh_card = (CardView) findViewById(R.id.agh_card);
        pgh_card = (CardView) findViewById(R.id.pgh_card);
        kbh_card = (CardView) findViewById(R.id.kbh_card);
        him_card = (CardView) findViewById(R.id.him_card);
        hi_card = (CardView) findViewById(R.id.hi_card);
        ud_card = (CardView) findViewById(R.id.ud_card);
        ar_card = (CardView) findViewById(R.id.ar_card);
        sat_card = (CardView) findViewById(R.id.sat_card);
        dau_card = (CardView) findViewById(R.id.dau_card);
        shiv_card = (CardView) findViewById(R.id.shiv_card);
        neel_card = (CardView) findViewById(R.id.neel_card);
        mani_card = (CardView) findViewById(R.id.mani_card);
        vin_card = (CardView) findViewById(R.id.vin_card);
        info_card = (CardView) findViewById(R.id.info_card);

        ambika = (ImageView) findViewById(R.id.ambika);
        kbh = (ImageView) findViewById(R.id.kbh);
        pgh = (ImageView) findViewById(R.id.pgh);
        himgiri = (ImageView) findViewById(R.id.himgiri);
        himadri = (ImageView) findViewById(R.id.hima);
        sat = (ImageView) findViewById(R.id.sat);
        vin = (ImageView) findViewById(R.id.vin);
        ud = (ImageView) findViewById(R.id.udya);
        mani = (ImageView) findViewById(R.id.mani);
        neel = (ImageView) findViewById(R.id.neel);
        dau = (ImageView) findViewById(R.id.dau);
        shiv = (ImageView) findViewById(R.id.shiv);
        ara = (ImageView) findViewById(R.id.ara);

        agh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(hostels.this, "Na Ho Paega", Toast.LENGTH_SHORT);
                startActivity(new Intent(hostels.this, ambika.class));
            }
        });
        pgh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, pgh.class));

            }
        });
        kbh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, kbh.class));

            }
        });
        him_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, himgiri.class));

            }
        });
        hi_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, himadri.class));

            }
        });
        ud_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, udaygiri.class));

            }
        });
        ar_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, aravali.class));

            }
        });
        sat_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, satp.class));

            }
        });
        dau_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, daul.class));

            }
        });
        shiv_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, shivalik.class));

            }
        });
        neel_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, neel.class));

            }
        });
        mani_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, mani.class));

            }
        });
        vin_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, vind.class));

            }
        });
        info_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(hostels.this, info.class));

            }
        });
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.placeholder(R.drawable.imageloading);
        requestOptions.error(R.drawable.imageloading);

        Glide.with(this).load(R.drawable.vindyanchal).apply(requestOptions).into(vin);
        Glide.with(this).load(R.drawable.udyagiri).apply(requestOptions).into(ud);
        Glide.with(this).load(R.drawable.satpura).apply(requestOptions).into(sat);
        Glide.with(this).load(R.drawable.shivalik).apply(requestOptions).into(shiv);
        Glide.with(this).load(R.drawable.neelkanth).apply(requestOptions).into(neel);
        Glide.with(this).load(R.drawable.himadri).apply(requestOptions).into(himadri);
        Glide.with(this).load(R.drawable.dhauladhar).apply(requestOptions).into(dau);
        Glide.with(this).load(R.drawable.aravali).apply(requestOptions).into(ara);
        Glide.with(this).load(R.drawable.manimahesh).apply(requestOptions).into(mani);
        Glide.with(this).load(R.drawable.ambika).apply(requestOptions).into(ambika);
        Glide.with(this).load(R.drawable.himgiri).apply(requestOptions).into(himgiri);
        Glide.with(this).load(R.drawable.pgh).apply(requestOptions).into(pgh);
        Glide.with(this).load(R.drawable.kbh).apply(requestOptions).into(kbh);

    }

}

