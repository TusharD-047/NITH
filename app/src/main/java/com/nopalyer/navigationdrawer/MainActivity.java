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
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CardView dir_card,pl_card,mag_card,map_card;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        dir_card=(CardView) findViewById(R.id.dir_card);
        pl_card=(CardView) findViewById(R.id.pl_card);
        map_card=(CardView) findViewById(R.id.map_card);
        mag_card=(CardView) findViewById(R.id.mag_card);

        dir_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Na Ho Paega",Toast.LENGTH_SHORT);
                startActivity(new Intent(MainActivity.this,dir.class));
            }
        });
        pl_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,pl.class));

            }
        });
        map_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,map.class));

            }
        });
        mag_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,mag.class));

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
                        login.class);
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

            case R.id.website:

                Intent browsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nith.ac.in/"));
                startActivity(browsIntent);

            default:
                break;
        }


        return false;
    }
}
