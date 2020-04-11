package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.github.barteksc.pdfviewer.PDFView;

public class fees extends AppCompatActivity {
    PDFView View;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees);
        View = (PDFView)findViewById(R.id.fees2019);
        View.fromAsset("feestructure.pdf").load();
    }
}
