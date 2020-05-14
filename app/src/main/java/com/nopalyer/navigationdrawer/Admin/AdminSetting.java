package com.nopalyer.navigationdrawer.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.R;

public class AdminSetting extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference,sref,bref;
    //private SharedPreferences sharedPreferences1,sharedPreferences2;
    ProgressDialog pd,pd1;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_setting);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Setting");
        toolbar.setTitleTextColor(Color.WHITE);
        pd =new ProgressDialog(this);
        pd1 =new ProgressDialog(this);

        final Switch switch1 = (Switch) findViewById(R.id.switchSemester);
        final Switch switch2 = (Switch) findViewById(R.id.switchBonafide);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        /*sharedPreferences1 = getSharedPreferences("",MODE_PRIVATE);
        final SharedPreferences.Editor editor1 = sharedPreferences1.edit();
        switch1.setChecked(sharedPreferences1.getBoolean("SWITCH",false));*/

        pd.setMessage("Retrieving Info ! Please Smile");
        pd.setCancelable(false);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        sref = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
        sref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String con = dataSnapshot.child("Condition").getValue().toString();
                if (con.equals("On")){
                    switch1.setChecked(true);
                }if (con.equals("Off")){
                    switch1.setChecked(false);
                }
                pd.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        pd1.setMessage("Retrieving Info ! Please Smile");
        pd1.setCancelable(false);
        pd1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd1.show();
        bref = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
        bref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String con = dataSnapshot.child("Condition").getValue().toString();
                if (con.equals("On")){
                    switch2.setChecked(true);
                }if (con.equals("Off")){
                    switch2.setChecked(false);
                }
                pd1.dismiss();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        switch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("On");
                    //editor1.putBoolean("SWITCH",true);
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Semester Switch");
                    databaseReference.child("Condition").setValue("Off");
                    //editor1.putBoolean("SWITCH",false);
                    // The toggle is disabled
                }
                //editor1.apply();
            }
        });

        /*sharedPreferences2 = getSharedPreferences("",MODE_PRIVATE);
        final SharedPreferences.Editor editor2 = sharedPreferences2.edit();
        switch2.setChecked(sharedPreferences2.getBoolean("SWITCH1",false));*/

        switch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("On");
                    //editor2.putBoolean("SWITCH1",true);
                    // The toggle is enabled
                } else {
                    databaseReference = firebaseDatabase.getReference("Admin Switch").child("Bonafide Switch");
                    databaseReference.child("Condition").setValue("Off");
                    //editor2.putBoolean("SWITCH1",false);
                    // The toggle is disabled
                }
                //editor2.apply();
            }
        });
    }
}
