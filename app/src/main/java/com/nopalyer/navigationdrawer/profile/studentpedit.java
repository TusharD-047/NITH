package com.nopalyer.navigationdrawer.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.StudentsPage;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class studentpedit extends AppCompatActivity {
    private TextView nametop,email;
    private EditText name,rollno,contact;
    private Button save;
    private String department;
    private ImageView Picture;
    Spinner s1;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;
    private FirebaseDatabase firebaseDatabase;
    private static int PICK_IMAGE = 123;
    private StorageReference storageReference;
    Uri imagePath;
    Map<String, Object> bd = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studentpedit);
        s1 = (Spinner)findViewById(R.id.spinner1);
        final String departments[] = {"NO OPTION SELECTED","CSE","CSE DUAL","ECE","ECE DUAL","CHEMICAL ENGG.","MECHANICAL ENGG.","CIVIL ENGG.","MATERIAL SCIENCE ENGG.","ELECTRICAL ENGG.","ARCHITECTURE","MNC"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,R.layout.colour_spinner,departments);
        s1.setAdapter(adapter);

        nametop = findViewById(R.id.nametop);
        email = findViewById(R.id.emailadd);
        name = findViewById(R.id.naam);
        save = findViewById(R.id.savedetails);
        rollno = findViewById(R.id.rollnbr);
        contact = findViewById(R.id.contact);
        Picture = findViewById(R.id.editpp);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        FirebaseStorage firebaseStorage = FirebaseStorage.getInstance();

        storageReference = firebaseStorage.getReference();

        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                department = s1.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        Boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);
        if(isFirstRun){
            name.setText("");
            rollno.setText("");
            contact.setText("");
            email.setText(user.getEmail());
            nametop.setText("");
        }else{
            StoredData();
            StorageReference storageReference = firebaseStorage.getReference();
            storageReference.child(firebaseAuth.getUid()).child("Profile").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).fit().centerCrop().into(Picture);
                }
            });
        }
        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).apply();


        Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);
            }
        });

        UploadInfo();
        UploadImage();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getText().toString().isEmpty() || rollno.getText().toString().isEmpty() || contact.getText().toString().isEmpty()
                        || department.isEmpty()){
                    Toast.makeText(studentpedit.this,"Please fill all Details",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(studentpedit.this,studentp.class));
                }
            }
        });
    }

    private void UploadInfo() {
        DatabaseReference databaseReference1 = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile Info");
        bd.put("Name", name.getText().toString());
        bd.put("Roll Number", rollno.getText().toString());
        bd.put("Contact", contact.getText().toString());
        bd.put("Department", department);

    }
    private void StoredData(){
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile Info");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                name.setText(dataSnapshot.child("Name").getValue().toString().trim());
                rollno.setText(dataSnapshot.child("Roll Number").getValue().toString().trim());
                contact.setText(dataSnapshot.child("Contact").getValue().toString().trim());
                email.setText(user.getEmail());
                nametop.setText(name.getText().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(studentpedit.this,"Data not Updated ! Try Again",Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void UploadImage(){
        StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("Profile");
        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(studentpedit.this,"Image Upload Failed",Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(studentpedit.this,"Uploaded Image Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                Picture.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
