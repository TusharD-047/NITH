package com.nopalyer.navigationdrawer.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.login;

public class AdminHome extends AppCompatActivity {

    Toolbar toolbar;
    CardView btechreg;
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

        btechreg = (CardView)findViewById(R.id.adminbtechreg);

        btechreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AdminHome.this, AdminBtechReg.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.adminmenu_item,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        switch(id)
        {
            case R.id.adminlogout:

                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(AdminHome.this, login.class));
                break;

            case R.id.setting:

                startActivity(new Intent(AdminHome.this, AdminSetting.class));
                break;


        }

        return true;

    }
}
