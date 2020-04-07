package com.nopalyer.navigationdrawer.student.clubs.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.models.DClubs;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_DCLUBS = "extra_dclubs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ImageView imageView = findViewById(R.id.img_detail);
        TextView name = findViewById(R.id.tv_name_detail);
        TextView description = findViewById(R.id.tv_desc_detail);

        DClubs mountain = getIntent().getParcelableExtra(EXTRA_DCLUBS);

        Glide.with(this).load(mountain.getPhoto()).into(imageView);
        name.setText(mountain.getName());
        description.setText(mountain.getDescription());


    }
}
