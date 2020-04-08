package com.nopalyer.navigationdrawer.profile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.StudentsPage;
import com.squareup.picasso.Picasso;

public class studentp extends AppCompatActivity {
    private ImageView profile;
    private TextView name,roll,department,contact,email,name1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentp);

        profile = (ImageView)findViewById(R.id.profilep);
        name = (TextView)findViewById(R.id.name123);
        roll = (TextView)findViewById(R.id.roll123);
        name1 = (TextView)findViewById(R.id.name1);
        department = (TextView)findViewById(R.id.department123);
        contact = (TextView)findViewById(R.id.contact123);
        email = (TextView)findViewById(R.id.email123);
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
        StorageReference storageReference = firebaseStorage.getReference();
        storageReference.child("Profile").child(firebaseAuth.getUid()).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
            @Override
            public void onSuccess(Uri uri) {
                Picasso.get().load(uri).fit().centerCrop().into(profile);

            }
        });

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name.setText(dataSnapshot.child("Name").getValue().toString().trim());
                name1.setText(dataSnapshot.child("Name").getValue().toString().trim());
                roll.setText(dataSnapshot.child("Roll No").getValue().toString().trim());
                department.setText(dataSnapshot.child("Department").getValue().toString().trim());
                email.setText(firebaseUser.getEmail());
                contact.setText(dataSnapshot.child("Contact").getValue().toString().trim());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(studentp.this, databaseError.getCode(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
