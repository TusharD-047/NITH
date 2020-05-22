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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nopalyer.navigationdrawer.student.spassign;

public class DeleteAssignment extends AppCompatActivity {

    private Button show,delete;
    private TextView title,duedate;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ref;
    private StorageReference sref;
    String titlevalue,name,yr,dep;
    String url;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_assignment);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Uploaded Assignment");
        toolbar.setTitleTextColor(Color.WHITE);


        titlevalue = getIntent().getExtras().getString("title");
        name = getIntent().getExtras().getString("name");
        yr = getIntent().getExtras().getString("yr");
        dep = getIntent().getExtras().getString("dep");

        show = findViewById(R.id.tpDeleteShow);
        delete = findViewById(R.id.tpDeleteDelete);
        title = findViewById(R.id.tpDeleteTitle);
        duedate = findViewById(R.id.tpDeleteDueDate);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        title.setText(titlevalue);
        ref = firebaseDatabase.getReference("Assignment").child(yr).child(dep).child(name).child(titlevalue);
        sref = FirebaseStorage.getInstance().getReference("Assignment").child(yr).child(dep).child(name).child(titlevalue);
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

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sref.delete();
                ref.removeValue();
                startActivity(new Intent(DeleteAssignment.this,tpassignHome.class));
            }
        });
    }
}
