package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class website extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_website);

        Intent browsIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://nith.ac.in/"));
        startActivity(browsIntent);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(website.this,MainActivity.class));
    }
}
