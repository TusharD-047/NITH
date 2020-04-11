package com.nopalyer.navigationdrawer.Login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.login;

public class ChangePassword extends AppCompatActivity {
    private TextView Remail;
    private Button Changepassword;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        Remail = (TextView) findViewById(R.id.Email);
        Changepassword = (Button) findViewById(R.id.passchange);
        firebaseAuth = FirebaseAuth.getInstance();
        user = firebaseAuth.getCurrentUser();
        Remail.setText(user.getEmail());

        Changepassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailw = Remail.getText().toString();
                firebaseAuth.sendPasswordResetEmail(emailw).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(ChangePassword.this, "Password Send to your Email", Toast.LENGTH_LONG).show();
                            firebaseAuth.signOut();
                            finish();
                            startActivity(new Intent(ChangePassword.this, login.class));
                        }else {
                            Toast.makeText(ChangePassword.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}