package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    private DatabaseReference ref,bref;
    String titlevalue,name,yr,group;
    String url = "";
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_assign_open);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Assignment");
        toolbar.setTitleTextColor(Color.WHITE);

        titlevalue = getIntent().getExtras().getString("title111");
        name = getIntent().getExtras().getString("teacher111");
        yr = getIntent().getExtras().getString("yr111");
        group = getIntent().getExtras().getString("group111");

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
            bref = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
            bref.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String branch = dataSnapshot.child("Department").getValue().toString();
                    ref = firebaseDatabase.getReference("Assignment").child(yr).child(branch).child(name).child(titlevalue);
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
