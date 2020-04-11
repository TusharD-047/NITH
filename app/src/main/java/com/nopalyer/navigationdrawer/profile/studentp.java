package com.nopalyer.navigationdrawer.profile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.IOException;

public class studentp extends AppCompatActivity {
    private ImageView profile;
    private TextView name,roll,department,contact,email,name1;
    ProgressDialog pd,pd1;
    private static int PICK_IMAGE = 123;
    StorageReference storageReference;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;

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
        pd =new ProgressDialog(this);
        pd1 =new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        pd.setMessage("Retrieving Info ! Please Smile");
        pd.setCancelable(false);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        DatabaseReference databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
        storageReference = firebaseStorage.getReference();
        storageReference.child(firebaseAuth.getUid()).child("image").child("Profile").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
                pd.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(studentp.this, databaseError.getCode(),Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);
            }
        });

       /* add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadImage();
            }
        });*/

    }
   /* private void UploadImage(){

        UploadTask uploadTask = imageReference.putFile(imagePath);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(studentp.this,"Upload Failed",Toast.LENGTH_SHORT).show();
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(studentp.this,"Uploaded Image Successfully",Toast.LENGTH_SHORT).show();
            }
        });
    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            Uri imagePath = data.getData();
            CropImage.activity(imagePath)
                    .start(this);
           /* try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                profile.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }*/
        }
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);

            if(resultCode == RESULT_OK){
                Uri resultUri = result.getUri();
                pd1.setMessage("Uploading Image ! Please Smile");
                pd1.setCancelable(false);
                pd1.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd1.show();
                StorageReference imageReference = storageReference.child(firebaseAuth.getUid()).child("image").child("Profile");
                imageReference.putFile(resultUri).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {

                        if(task.isSuccessful()){
                            Toast.makeText(studentp.this, "Upload Image Successfully",Toast.LENGTH_SHORT).show();
                            storageReference = firebaseStorage.getReference();
                            storageReference.child(firebaseAuth.getUid()).child("image").child("Profile").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                @Override
                                public void onSuccess(Uri uri) {
                                    Picasso.get().load(uri).fit().centerCrop().into(profile);
                                }
                            });
                            pd1.dismiss();
                        }else {
                            Toast.makeText(studentp.this, "Image not Uploaded",Toast.LENGTH_SHORT).show();
                            pd1.dismiss();
                        }
                    }
                });

            }

        }
    }
}
