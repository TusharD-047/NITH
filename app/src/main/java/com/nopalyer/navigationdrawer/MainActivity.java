package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.AboutNithhp.home1;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private CardView dir_card,pl_card,mag_card,map_card;

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    RecyclerView recyclerView;
    final String STATE_TITLE = "state_title";
    private ArrayList<hme> list1;
    final String STATE_LIST = "state_list";
    final String STATE_MODE = "state_mode";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ref;
    ProgressDialog pd;

    int mode;


    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseDatabase = FirebaseDatabase.getInstance();
        pd =new ProgressDialog(this);

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

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);


        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setHasFixedSize(true);
//        ((AppCompatActivity)getActivity()).getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.design_default_color_primary)));
        list1 = new ArrayList<>();
        list1.addAll(home.getListData());
        showRecyclerCardView();


    }

    // menu

    public void setLayoutAnimation(){
        Context context = recyclerView.getContext();
        LayoutAnimationController layoutAnimationController = AnimationUtils.loadLayoutAnimation(context,R.anim.item_animation_slide_from_right);

        recyclerView.setLayoutAnimation(layoutAnimationController);
        recyclerView.getAdapter().notifyDataSetChanged();
        recyclerView.scheduleLayoutAnimation();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId()){
            case R.id.departments:
                Intent myintent = new Intent(MainActivity.this, departments.class);
                startActivity(myintent);
                return false;
            case R.id.hostels:

                myintent= new Intent(MainActivity.this, hostels.class);
                startActivity(myintent);
                return false;
            case R.id.login:
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                if (user != null){
                    pd.setMessage("Signing In ! Please Smile");
                    pd.setCancelable(false);
                    pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    pd.show();
                    FirebaseAuth firebaseAuth1 = FirebaseAuth.getInstance();
                    ref= firebaseDatabase.getReference(firebaseAuth1.getUid()).child("Profile");
                    ref.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            String rooles = dataSnapshot.child("role").getValue().toString();
                            Intent myintent = new Intent(MainActivity.this, login.class);
                            myintent.putExtra("roless",rooles);
                            startActivity(myintent);
                            pd.dismiss();
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }else {
                    startActivity(new Intent(MainActivity.this,login.class));
                }

                return false;

            case R.id.events:
                myintent = new Intent(MainActivity.this, events.class);
                startActivity(myintent);
                return false;

            case R.id.home1:
                myintent = new Intent(MainActivity.this, home1.class);
                startActivity(myintent);
                return false;

            case R.id.website:

                Intent browsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nith.ac.in/"));
                startActivity(browsIntent);

            default:
                break;

            case R.id.aboutdevelopers:
                myintent = new Intent(MainActivity.this, aboutdevelopers.class);
                startActivity(myintent);
                return false;
        }


        return false;
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, "");
        outState.putParcelableArrayList(STATE_LIST, list1);
        outState.putInt(STATE_MODE, mode);
    }


    private void showRecyclerCardView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SimpleRecyclerAdapter cardViewAdapter1 = new SimpleRecyclerAdapter(this);
        cardViewAdapter1.setListDClubs(list1);
        recyclerView.setAdapter(cardViewAdapter1);
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
