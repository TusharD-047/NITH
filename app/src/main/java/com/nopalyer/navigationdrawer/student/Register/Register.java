package com.nopalyer.navigationdrawer.student.Register;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.nopalyer.navigationdrawer.R;

import java.util.ArrayList;

public class Register extends AppCompatActivity {

    RecyclerView recyclerView;
    private ArrayList<reg> list5;
    final String STATE_TITLE = "state_title";
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    Toolbar toolbar;
    int mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Registration");
        toolbar.setTitleTextColor(Color.WHITE);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        list5 = new ArrayList<>();
        list5.addAll(regdata.getListregdata());
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
        outState.putParcelableArrayList(STATE_LIST, list5);
        outState.putInt(STATE_MODE, mode);
    }


    private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleRecyclerAdapter2 cardViewAdapter2 = new SimpleRecyclerAdapter2(this);
        cardViewAdapter2.setListreg(list5);
        recyclerView.setAdapter(cardViewAdapter2);
    }
}

