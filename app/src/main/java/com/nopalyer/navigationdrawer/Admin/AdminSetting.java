package com.nopalyer.navigationdrawer.Admin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.SharedPreferences;
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
    private SharedPreferences sharedPreferences1,sharedPreferences2;

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

        sharedPreferences1 = getSharedPreferences("",MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        switch1.setChecked(sharedPreferences1.getBoolean("SWITCH",false));


        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("On");
                    editor1.putBoolean("SWITCH",true);
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("Off");
                    editor1.putBoolean("SWITCH",false);
                    // The toggle is disabled
                }
                editor1.apply();
            }
        });

        sharedPreferences2 = getSharedPreferences("",MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        switch2.setChecked(sharedPreferences2.getBoolean("SWITCH1",false));

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("On");
                    editor2.putBoolean("SWITCH1",true);
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("Off");
                    editor2.putBoolean("SWITCH1",false);
                    // The toggle is disabled
                }
                editor2.apply();
            }
        });
    }
}
