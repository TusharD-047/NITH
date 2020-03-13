package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class info extends AppCompatActivity {
    Button btn_hostelbooklet,btn_functionaries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        btn_hostelbooklet=(Button)  findViewById(R.id.pdffeesstructure);
        btn_functionaries=(Button)  findViewById(R.id.pdffunctionaries);

        btn_hostelbooklet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(info.this,hostelbooklet.class);
                startActivity(i);
            }
        });
        btn_functionaries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(info.this,functionaries.class);
                startActivity(i);
            }
        });
    }
}
