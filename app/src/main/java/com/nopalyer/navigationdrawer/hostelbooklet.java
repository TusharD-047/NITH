package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class hostelbooklet extends AppCompatActivity {
    PDFView hostelbooklet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hostelbooklet);

        hostelbooklet=(PDFView) findViewById(R.id.pdfhostelbooklet);
        hostelbooklet.fromAsset("hostelbooklet.pdf").load();
    }
}
