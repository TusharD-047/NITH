package com.nopalyer.navigationdrawer.student;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import com.google.firebase.auth.FirebaseAuth;
import com.nopalyer.navigationdrawer.Login.ChangePassword;
import com.nopalyer.navigationdrawer.MainActivity;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.login;
import com.nopalyer.navigationdrawer.student.clubs.Clu;

public class StudentsPage extends AppCompatActivity {

    CardView faculty_card,clubs_card,myProfile,website;
    private FirebaseAuth firebaseAuth;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);

        faculty_card = (CardView) findViewById(R.id.faculty_card);
        clubs_card = (CardView) findViewById(R.id.club);
        myProfile = (CardView) findViewById(R.id.pro) ;
        website = (CardView) findViewById(R.id.website1);
        toolbar = (Toolbar)findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        firebaseAuth = FirebaseAuth.getInstance();

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
                Toast.makeText(StudentsPage.this, "Nith Website", Toast.LENGTH_SHORT);
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://nith.ac.in/")));
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

