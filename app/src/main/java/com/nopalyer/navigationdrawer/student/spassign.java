package com.nopalyer.navigationdrawer.student;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.nopalyer.navigationdrawer.R;

import static com.nopalyer.navigationdrawer.profile.studentp.save;

public class spassign extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spassign);
        TextView textView = findViewById(R.id.tre);
        textView.setText(save);
    }
}
