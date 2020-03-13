package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class mag extends AppCompatActivity {
    PDFView feestructure;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mag);
        feestructure=(PDFView) findViewById(R.id.pdffeesstructure);
        feestructure.fromAsset("feestructure.pdf").load();
    }
}
