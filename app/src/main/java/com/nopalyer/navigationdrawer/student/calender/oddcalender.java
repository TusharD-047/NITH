package com.nopalyer.navigationdrawer.student.calender;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.nopalyer.navigationdrawer.R;

public class oddcalender extends AppCompatActivity {
    PDFView oddcalender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oddcalender);
        oddcalender=(PDFView) findViewById(R.id.pdfoddcalender);
       oddcalender.fromAsset("oddcalender.pdf").load();
    }
}
