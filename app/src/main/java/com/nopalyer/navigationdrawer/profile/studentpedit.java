package com.nopalyer.navigationdrawer.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.nopalyer.navigationdrawer.R;

public class studentpedit extends AppCompatActivity {

    Spinner s1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpedit);
        s1 = (Spinner)findViewById(R.id.spinner1);
        final String departments[] = {"NO OPTION SELECTED","CSE","CSE DUAL","ECE","ECE DUAL","CHEMICAL ENGG.","MECHANICAL ENGG.","CIVIL ENGG.","MATERIAL SCIENCE ENGG.","ELECTRICAL ENGG.","ARCHITECTURE","MNC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.colour_spinner,departments);
        s1.setAdapter(adapter);
    }
}
