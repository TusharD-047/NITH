package com.nopalyer.navigationdrawer.student;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.Login.ChangePassword;
import com.nopalyer.navigationdrawer.MainActivity;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.login;
import com.nopalyer.navigationdrawer.profile.studentp;
import com.nopalyer.navigationdrawer.student.Register.Register;
import com.nopalyer.navigationdrawer.student.calender.calender1;
import com.nopalyer.navigationdrawer.student.help.help;

import java.util.HashMap;


public class StudentsPage extends AppCompatActivity {

    CardView faculty_card,clubs_card,myProfile,website,aboutdev,calender,help,schedule,assignm,registration;
    private FirebaseAuth firebaseAuth;
    Toolbar toolbar;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference ref;
    HashMap<String, Object> student = new HashMap<>();
    SharedPreferences spyr;

;    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);
        faculty_card = (CardView) findViewById(R.id.faculty_card);
        clubs_card = (CardView) findViewById(R.id.club);
        myProfile = (CardView) findViewById(R.id.pro) ;
        website = (CardView) findViewById(R.id.website1);
        aboutdev = (CardView) findViewById(R.id.au);
        calender = (CardView) findViewById(R.id.cal);
        help = (CardView) findViewById(R.id.help);
        schedule = (CardView)findViewById(R.id.spsch);
        assignm = (CardView)findViewById(R.id.assign);
        registration= (CardView)findViewById(R.id.registration);


        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

        faculty_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this, "Faculties Of NITH", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StudentsPage.this, com.nopalyer.navigationdrawer.student.branchfaculty.faculty2.class));
            }
        });
        clubs_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this, "Clubs Of NITH", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StudentsPage.this, com.nopalyer.navigationdrawer.student.clubs.Clu.class));
            }
        });
        myProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(StudentsPage.this,com.nopalyer.navigationdrawer.profile.studentp.class));
            }
        });
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this, "Nith Website", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://nith.ac.in/")));
            }
        });
        aboutdev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPage.this, com.nopalyer.navigationdrawer.student.aboutus21.aboutdev.class));
            }
        });
        calender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPage.this, calender1.class));
            }
        });
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPage.this, com.nopalyer.navigationdrawer.student.help.help.class));
            }
        });
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPage.this, Spschedule.class));
            }
        });
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(StudentsPage.this, Register.class));
            }
        });
        assignm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Bundle bundle = getIntent().getExtras();
                //updateYear = bundle.getString("yearupdate");
                spyr = getSharedPreferences("shree",MODE_PRIVATE);
                final String updtyear = spyr.getString("yearupdate","");

                ref =firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
                ref.child("Year").setValue(updtyear);
                ref.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        student = (HashMap<String, Object>) dataSnapshot.getValue();
                        String year = student.get("Year").toString();
                        String branch = student.get("Department").toString();
                        Intent i = new Intent(StudentsPage.this,spassign.class);
                        i.putExtra("year",year);
                        i.putExtra("dep",branch);
                        startActivity(i);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(StudentsPage.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(StudentsPage.this, MainActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.spmenu_item,menu);

        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id= item.getItemId();

        switch (id)
        {
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(StudentsPage.this, login.class));
                break;


            case R.id.changepass:
               startActivity(new Intent(StudentsPage.this,ChangePassword.class));
               break;

        }


        return true;
    }
}

