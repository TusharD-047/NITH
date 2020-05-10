package com.nopalyer.navigationdrawer.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.nopalyer.navigationdrawer.R;

public class AdminSetting extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_setting);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Setting");
        toolbar.setTitleTextColor(Color.WHITE);

        Switch switch1 = (Switch) findViewById(R.id.switchSemester);
        Switch switch2 = (Switch) findViewById(R.id.switchBonafide);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("On");
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("Off");
                    // The toggle is disabled
                }
            }
        });

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("On");
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("Off");
                    // The toggle is disabled
                }
            }
        });
    }
}
