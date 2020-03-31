package com.nopalyer.navigationdrawer.cse;

import android.os.Bundle;
import android.widget.ViewFlipper;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nopalyer.navigationdrawer.R;

public class cseprogrammes extends AppCompatActivity {

    ViewFlipper slider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cse_cseprogrammes);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Programmes Offered");

    }

}
