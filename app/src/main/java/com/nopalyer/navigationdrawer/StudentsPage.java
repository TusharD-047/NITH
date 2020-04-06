package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;

public class StudentsPage extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);
        firebaseAuth = FirebaseAuth.getInstance();
    }

    public void signout(View v){
        firebaseAuth.signOut();
        finish();
        startActivity(new Intent(StudentsPage.this,login.class));
    }
}
