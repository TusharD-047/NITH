package com.nopalyer.navigationdrawer.student.clubs;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.nopalyer.navigationdrawer.student.clubs.activities.Cultural;
import com.nopalyer.navigationdrawer.student.clubs.activities.Technical;
import com.google.android.material.tabs.TabLayout;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.activities.Departmental;


public class Clu extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Clubs");
        toolbar.setTitleTextColor(Color.WHITE);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new Departmental(), "Departmental");
        adapter.addFragment(new Cultural(), "Cultural");
        adapter.addFragment(new Technical(), "technical");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);


    }
}