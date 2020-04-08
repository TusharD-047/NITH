package com.nopalyer.navigationdrawer.AboutNithhp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.ToolbarWidgetWrapper;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import androidx.appcompat.widget.Toolbar;

import com.nopalyer.navigationdrawer.R;

import java.util.ArrayList;

public class home1 extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<Abnith> list45;
    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    Toolbar toolbar;
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutnith1);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("About Nith");
        toolbar.setTitleTextColor(Color.WHITE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list45 = new ArrayList<>();
        list45.addAll(AboutnithData.getlistAboutnithData());
        showRecyclerCardView();




    }
    public void setLayoutAnimation(){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context,R.anim.item_animation1);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, "");
        outState.putParcelableArrayList(STATE_LIST, list45);
        outState.putInt(STATE_MODE, mode);
    }


    private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleRecyclerAdapter1 cardViewAdapter1 = new SimpleRecyclerAdapter1(this);
        cardViewAdapter1.setListAbnith(list45);
        recyclerView.setAdapter(cardViewAdapter1);
    }
}
