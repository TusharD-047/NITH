package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SpAssignOpen extends AppCompatActivity {

    private Button show;
    private TextView title,duedate;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ref;
    String titlevalue,name,yr,dep,group;
    String url;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_assign_open);

        titlevalue = getIntent().getExtras().getString("title");
        name = getIntent().getExtras().getString("teacher");
        yr = getIntent().getExtras().getString("yr");
        dep = getIntent().getExtras().getString("dep");
        group = getIntent().getExtras().getString("group");

        show = findViewById(R.id.spDeleteShow);
        title = findViewById(R.id.spDeleteTitle);
        duedate = findViewById(R.id.spDeleteDueDate);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        title.setText(titlevalue);
        if (yr.equals("1st year")){
            ref = firebaseDatabase.getReference("Assignment").child(yr).child(group).child(name).child(titlevalue);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String dd = dataSnapshot.child("DueDate").getValue().toString();
                    url = dataSnapshot.child("Url").getValue().toString();
                    duedate.setText(dd);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else{
            ref = firebaseDatabase.getReference("Assignment").child(yr).child(dep).child(name).child(titlevalue);
            ref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String dd = dataSnapshot.child("DueDate").getValue().toString();
                    url = dataSnapshot.child("Url").getValue().toString();
                    duedate.setText(dd);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Intent newIntent = Intent.createChooser(intent,"Open File");
                startActivity(newIntent);
            }
        });
    }
}
