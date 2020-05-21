package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nopalyer.navigationdrawer.teacher.tpassign;
import com.stripe.android.model.Card;

public class tpassignHome extends AppCompatActivity {

    CardView cv1,cv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tp_assign_home);

        cv1 = (CardView)findViewById(R.id.tpassign1);
        cv2 = (CardView)findViewById(R.id.tpassign2);

        cv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tpassignHome.this, tpassign.class));
            }
        });

        cv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(tpassignHome.this, UploadedAssignment.class));
            }
        });
    }
}
