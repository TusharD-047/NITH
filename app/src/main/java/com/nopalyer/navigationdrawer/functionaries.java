package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class functionaries extends AppCompatActivity {
    PDFView functionaries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_functionaries);
        functionaries=(PDFView) findViewById(R.id.pdffunctionaries);
        functionaries.fromAsset("functionaries.pdf").load();
    }
}
