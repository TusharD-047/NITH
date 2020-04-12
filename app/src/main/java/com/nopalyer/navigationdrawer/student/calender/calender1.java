package com.nopalyer.navigationdrawer.student.calender;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.nopalyer.navigationdrawer.R;

public class calender1 extends AppCompatActivity {

     Button btn_odd,btn_even;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calender);


    btn_odd=(Button)  findViewById(R.id.odd);
    btn_even=(Button)  findViewById(R.id.even);

        btn_odd.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(calender1.this,oddcalender.class);
            startActivity(i);
        }
    });
        btn_even.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent i=new Intent(calender1.this,evencalender.class);
            startActivity(i);
        }
    });
}}
