package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CardView city_card,college_card,srijan_card,vision_card;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        city_card=(CardView) findViewById(R.id.city_card);
        college_card=(CardView) findViewById(R.id.college_card);
        srijan_card=(CardView) findViewById(R.id.srijan_card);
        vision_card=(CardView) findViewById(R.id.vision_card);

        city_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, about_city.class));
            }
        });





        college_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, about_college.class));
            }
        });



        srijan_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, srijan.class));
            }
        });




        vision_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, vision.class));


            }
        });


        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitleTextColor(Color.WHITE);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        toggle.getDrawerArrowDrawable().setColor(Color.WHITE);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.departments:
                Intent myintent = new Intent(MainActivity.this,
                        departments.class);
                startActivity(myintent);
                return false;
            case R.id.hostels:
                myintent= new Intent(MainActivity.this,
                        hostels.class);
                startActivity(myintent);
                return false;
            case R.id.login:
                myintent = new Intent(MainActivity.this,
                        Try.class);
                startActivity(myintent);
                return false;

            case R.id.events:
                myintent = new Intent(MainActivity.this,
                        events.class);
                startActivity(myintent);
                return false;
            case R.id.registration:
                myintent = new Intent(MainActivity.this,
                        registration.class);
                startActivity(myintent);
                return false;
            case R.id.home1:
                myintent = new Intent(MainActivity.this,
                        home1.class);
                startActivity(myintent);
                return false;

            default:
                break;
        }


        return false;
    }
}
