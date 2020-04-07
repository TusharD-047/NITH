package com.nopalyer.navigationdrawer;

import java.util.ArrayList;

public class home {
    public static String[][] data = new String[][]{
            {
                "News and Announcements"
            },
            {
                "Achievements"
            },
            {
              "Campus Events"
            },
            {
                "Tenders"
            }

    };
    public static ArrayList<hme> getListData(){
        hme hmE;
        ArrayList<hme> list = new ArrayList<>();

        for (String[] mData : data) {
            hmE = new hme();
            hmE.setName(mData[0]);


            list.add(hmE);
        }

        return list;

    }
}
