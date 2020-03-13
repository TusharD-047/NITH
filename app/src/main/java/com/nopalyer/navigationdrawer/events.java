package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class events extends AppCompatActivity {
    private CardView hf_card,nim_card,ncc_card,sp_card,fresh_card,prayas_card,alu_card,sm_card,convo_card, nss_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events);
        hf_card=(CardView) findViewById(R.id.hf_card);
        nim_card=(CardView) findViewById(R.id.nim_card);
        ncc_card=(CardView) findViewById(R.id.ncc_card);
        sp_card=(CardView) findViewById(R.id.sp_card);
        fresh_card=(CardView) findViewById(R.id.fresh_card);
        prayas_card=(CardView) findViewById(R.id.prayas_card);
        alu_card=(CardView) findViewById(R.id.alu_card);
        sm_card=(CardView) findViewById(R.id.sm_card);
        convo_card=(CardView) findViewById(R.id.convo_card);
        nss_card=(CardView) findViewById(R.id.nss_card);

        hf_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(events.this,"Na Ho Paega",Toast.LENGTH_SHORT);
                startActivity(new Intent(events.this,hf.class));
            }
        });
        nim_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,nim.class));

            }
        });
        ncc_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,ncc.class));

            }
        });
        sp_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,sp.class));

            }
        });
        fresh_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,fresh.class));

            }
        });

        alu_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,alu.class));

            }
        });
        sm_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,sm.class));

            }
        });
        convo_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,convo.class));

            }
        });
        nss_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,nss.class));

            }
        });
        prayas_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(events.this,prayas.class));

            }
        });

    }
}
