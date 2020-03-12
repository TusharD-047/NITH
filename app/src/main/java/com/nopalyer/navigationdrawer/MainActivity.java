package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
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
                myintent = new Intent(MainActivity.this,
                        hostels.class);
                startActivity(myintent);
                return false;
            case R.id.login:
                Toast.makeText(  MainActivity.this, "Please enter your Credentials",Toast.LENGTH_SHORT).show();
                break;
            case R.id.courses:
                Toast.makeText(  MainActivity.this, "Courses",Toast.LENGTH_SHORT).show();
                break;
            case R.id.events:
                Toast.makeText(  MainActivity.this, "Events of NITH",Toast.LENGTH_SHORT).show();
                break;
            case R.id.registration:
                Toast.makeText(  MainActivity.this, "Registration Page",Toast.LENGTH_SHORT).show();
                break;
            case R.id.home1:
                Toast.makeText(  MainActivity.this, "Welcome to HomePage",Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }


        return false;
    }
}
