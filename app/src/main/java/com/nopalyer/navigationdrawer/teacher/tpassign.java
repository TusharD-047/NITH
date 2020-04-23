package com.nopalyer.navigationdrawer.teacher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.uploadPDF;

public class tpassign extends AppCompatActivity {

    Toolbar toolbar;
    private Spinner sp1,sp2;
    private Button show;
    private EditText title;
    ArrayAdapter<String> adapter_year,adapter_group,adapter_department;
    public static String dep,year2;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference kref;
    private FirebaseStorage firebaseStorage;
    private StorageReference mref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tpassign);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Assignment");
        toolbar.setTitleTextColor(Color.WHITE);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        firebaseStorage = FirebaseStorage.getInstance();
        kref = firebaseDatabase.getReference("Assignment");
        mref = firebaseStorage.getReference("Assignment");


        sp1 = (Spinner) findViewById(R.id.assignsp1);
        sp2 = (Spinner) findViewById(R.id.assignsp2);
        show = (Button) findViewById(R.id.upassign);
        title = findViewById(R.id.title123);

        final String[] year = {"Choose year", "1st year", "2nd year", "3rd year", "4th year"};
        final String[] group = {"Choose group", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        final String[] department = {"Choose branch", "CSE", "CSE DD", "ECE", "ECE DD", "Mechanical", "Civil", "Electrical", "Architecture", "Material Science", "Chemical"};


        adapter_year = new ArrayAdapter<>(tpassign.this, R.layout.colourful_spinner_items, year);
        adapter_year.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
        sp1.setAdapter(adapter_year);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    show.setEnabled(false);
                }
                if (position == 1) {
                    adapter_group = new ArrayAdapter<String>(tpassign.this, R.layout.colourful_spinner_items, group);
                    adapter_group.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_group);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = group[position];
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 2) {
                    adapter_department = new ArrayAdapter<String>(tpassign.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 3) {
                    adapter_department = new ArrayAdapter<String>(tpassign.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 4) {
                    adapter_department = new ArrayAdapter<String>(tpassign.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }

                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];

                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        show.setOnClickListener(new View.OnClickListener() {
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == RESULT_OK && data != null && data.getData() != null){
            uploadPDFFile(data.getData());
        }
    }

    private void uploadPDFFile(Uri data) {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();
        StorageReference reference = mref.child(year2).child(dep).child(title.getText().toString());
        reference.putFile(data).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Task<Uri> uri = taskSnapshot.getStorage().getDownloadUrl();
                while(!uri.isComplete());
                Uri url1 = uri.getResult();
                uploadPDF uploadPDF = new uploadPDF(title.getText().toString(),url1.toString());
                kref.child(year2).child(dep).child(kref.push().getKey()).setValue(uploadPDF);
                progressDialog.dismiss();
                Toast.makeText(tpassign.this,"Database Success",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(tpassign.this,"Database Failed",Toast.LENGTH_SHORT).show();
            }
        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onProgress(UploadTask.TaskSnapshot taskSnapshot) {
                double progress = (100.0*taskSnapshot.getBytesTransferred())/taskSnapshot.getTotalByteCount();
                progressDialog.setMessage("Uploaded:  "+(int)progress+"%");

            }
        });
    }
}
