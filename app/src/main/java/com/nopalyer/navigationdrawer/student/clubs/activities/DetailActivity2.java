package com.nopalyer.navigationdrawer.student.clubs.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.models.CClubs;

public class DetailActivity2 extends AppCompatActivity {
    public static final String EXTRA_CCLUBS = "extra_cclubs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail2);
        ImageView imageView = findViewById(R.id.img_detail2);
        TextView name = findViewById(R.id.tv_name_detail2);
        TextView description = findViewById(R.id.tv_desc_detail2);

        CClubs mountain = getIntent().getParcelableExtra(EXTRA_CCLUBS);

        Glide.with(this).load(mountain.getPhoto()).into(imageView);
        name.setText(mountain.getName());
        description.setText(mountain.getDescription());

    }
}