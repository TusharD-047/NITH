package com.nopalyer.navigationdrawer.humanities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;
import com.nopalyer.navigationdrawer.R;

public class humanities_phd extends AppCompatActivity {

    PDFView pdf_humanities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.humanities_phd);

        pdf_humanities = (PDFView) findViewById(R.id.pdf_humanities);

        pdf_humanities.fromAsset("humanitiesPhDsyllabus.pdf").load();
    }
}
