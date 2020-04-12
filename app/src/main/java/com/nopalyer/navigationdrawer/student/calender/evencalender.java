package com.nopalyer.navigationdrawer.student.calender;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;
import com.nopalyer.navigationdrawer.R;

public class evencalender extends AppCompatActivity {
    PDFView evencalender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evencalender);

        evencalender=(PDFView) findViewById(R.id.pdfevencalender);
        evencalender.fromAsset("evencalender.pdf").load();
    }
}
