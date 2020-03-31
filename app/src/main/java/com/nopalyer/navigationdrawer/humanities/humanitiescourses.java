package com.nopalyer.navigationdrawer.humanities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.nopalyer.navigationdrawer.R;

public class humanitiescourses extends AppCompatActivity {

    private Button b1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humanities_humanitiescourses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Programmes Offered");
        toolbar.setTitleTextColor(Color.WHITE);

         b1 = (Button) findViewById(R.id.humanities_syllabus_btn);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(humanitiescourses.this,humanities_phd.class);
                startActivity(intent);

            }
        });

    }
}
