package com.nopalyer.navigationdrawer.student.branchfaculty;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageViewAdepter extends FragmentPagerAdapter {
    public PageViewAdepter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch(position){
            case 0:
                fragment = new com.nopalyer.navigationdrawer.student.branchfaculty.science();
                break;
            case 1:
                fragment = new com.nopalyer.navigationdrawer.student.branchfaculty.engineering();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
