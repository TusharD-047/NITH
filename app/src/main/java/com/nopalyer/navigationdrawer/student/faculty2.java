package com.nopalyer.navigationdrawer.student;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.nopalyer.navigationdrawer.R;

public class faculty2 extends AppCompatActivity {

    TextView science, engineering;
    ViewPager viewPager;
    PageViewAdepter pageViewAdepter;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty2);
        science = (TextView) findViewById(R.id.science);
        engineering = (TextView)findViewById(R.id.engineering);
        viewPager = (ViewPager)findViewById(R.id.fragment_container);
        pageViewAdepter = new PageViewAdepter(getSupportFragmentManager());
        viewPager.setAdapter(pageViewAdepter);
        science.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(0);
            }
        });
        engineering.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(1);
            }
        });
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                onChangeTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void onChangeTab(int position) {
        if(position==0){
            science.setTextSize(25);
            science.setTextColor(Color.WHITE);
            engineering.setTextSize(20);
            engineering.setTextColor(Color.BLACK);
        }
        if(position==1){
            science.setTextSize(20);
            science.setTextColor(Color.BLACK);
            engineering.setTextSize(25);
            engineering.setTextColor(Color.WHITE);
        }
    }
}