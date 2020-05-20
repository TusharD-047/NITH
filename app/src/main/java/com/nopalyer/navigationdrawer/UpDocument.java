package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.itextpdf.xmp.impl.Utils;
import com.nopalyer.navigationdrawer.profile.studentp;
import com.nopalyer.navigationdrawer.teacher.tpassign;
import com.squareup.picasso.Picasso;
import com.theartofdev.edmodo.cropper.CropImage;

import java.io.ByteArrayOutputStream;
import java.io.File;

import static androidx.core.content.FileProvider.getUriForFile;

public class UpDocument extends AppCompatActivity {

    Button upProfile,upId;
    Button upForm;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    FirebaseStorage firebaseStorage;
    StorageReference sref,reference,reference2,reference3;
    DatabaseReference ref,mref;
    String yr = "",dep = "",roll = "",name ="";
    private static int PICK_IMAGE = 123;
    private static int PICK_IMAGE2 = 124;
    ProgressDialog pd,pd1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_up_document);

        upProfile = findViewById(R.id.upPhoto);
        upId = findViewById(R.id.upId);
        upForm = findViewById(R.id.upForm);
        pd =new ProgressDialog(this);

        pd1 =new ProgressDialog(this);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        sref =firebaseStorage.getReference("Application Form");
        mref = firebaseDatabase.getReference("Application Form");

        ref = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                yr = dataSnapshot.child("Year").getValue().toString();
                dep = dataSnapshot.child("Department").getValue().toString();
                roll = dataSnapshot.child("Roll No").getValue().toString();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpDocument.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
            }
        });

        upProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE);
            }
        });

        upId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select Image"),PICK_IMAGE2);
            }
        });

        upForm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UploadPDF();
            }
        });
    }

    private void UploadPDF() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
                    Uri.parse("package:" + getPackageName()));
            startActivity(intent);
            return;
        }

        Intent intent = new Intent();
        intent.setType("application/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Select Doocument"),1);
    }

    private void uploadPDFFile(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();
        reference = sref.child(yr).child(dep).child(roll).child("Form");
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url1 = uri.getResult();
                //uploadPDF uploadPDF = new uploadPDF("Info Form",url1.toString());
                mref.child(yr).child(dep).child(roll).child("Info Form").child("url").setValue(url1.toString());
                progressDialog.dismiss();
                Toast.makeText(UpDocument.this,"Form Uploaded",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(UpDocument.this,"Database Failed",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded:  "+(int)progress+"%");

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            uploadPDFFile(data.getData());
        }
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            Uri imagePath = data.getData();
            name = "Profile";
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
                reference2 = sref.child(yr).child(dep).child(roll).child(name);
                reference2.putFile(resultUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                        while(!uri.isComplete());
                        Uri url1 = uri.getResult();
                        //uploadPDF uploadPDF = new uploadPDF(name,url1.toString());
                        mref.child(yr).child(dep).child(roll).child(name).child("url").setValue(url1.toString());
                        pd1.dismiss();
                        Toast.makeText(UpDocument.this,"Form Uploaded",Toast.LENGTH_SHORT).show();
                    }
                });

            }

        }

        if(requestCode == PICK_IMAGE2 && resultCode == RESULT_OK && data.getData() != null){
            Uri imagePath = data.getData();
            name = "IdCard";
            CropImage.activity(imagePath)
                    .start(this);
           /* try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
                profile.setImageBitmap(bitmap);
            } catch (IOException e){
                e.printStackTrace();
            }*/
        }
    }
}
