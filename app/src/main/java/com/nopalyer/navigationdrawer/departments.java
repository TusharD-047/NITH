package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Toolbar;

import com.google.android.material.tabs.TabLayout;
import com.nopalyer.navigationdrawer.architecture.architecture;
import com.nopalyer.navigationdrawer.humanities.humanities;
import com.nopalyer.navigationdrawer.management.management;

public class departments extends AppCompatActivity {

    Toolbar mtoolbar;
    ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departments);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());

        adapter.addFragment(new start(),"Engineering");
        adapter.addFragment(new sciences(),"Sciences");
        adapter.addFragment(new architecture(),"Architecture");
        adapter.addFragment(new management(),"Management");
        adapter.addFragment(new humanities(),"Humanities");

        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(viewPager);
    }
}
