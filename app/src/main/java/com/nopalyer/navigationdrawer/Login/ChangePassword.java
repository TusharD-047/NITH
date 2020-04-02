package com.nopalyer.navigationdrawer.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nopalyer.navigationdrawer.R;

public class ChangePassword extends AppCompatActivity {
    private EditText Remail;
    private Button Changepassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Remail = (EditText) findViewById(R.id.editText5);
        Changepassword = (Button) findViewById(R.id.passchange);
        firebaseAuth = FirebaseAuth.getInstance();

    }
}