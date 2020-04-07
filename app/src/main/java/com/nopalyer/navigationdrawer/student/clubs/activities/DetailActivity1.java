package com.nopalyer.navigationdrawer.student.clubs.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.models.TClubs;

public class DetailActivity1 extends AppCompatActivity {

    public static final String EXTRA_TCLUBS = "extra_tclubs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail1);

        ImageView imageView = findViewById(R.id.img_detail1);
        TextView name = findViewById(R.id.tv_name_detail1);
        TextView description = findViewById(R.id.tv_desc_detail1);


        TClubs mountain = getIntent().getParcelableExtra(EXTRA_TCLUBS);

        Glide.with(this).load(mountain.getPhoto()).into(imageView);
        name.setText(mountain.getName());
        description.setText(mountain.getDescription());

    }
}
