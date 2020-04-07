package com.nopalyer.navigationdrawer.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.login;

public class verification extends AppCompatActivity {

    private TextView mail;
    private Button sendmail;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification);

        mail = findViewById(R.id.email);
        sendmail = findViewById(R.id.sendmail);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseUser = firebaseAuth.getCurrentUser();

        mail.setText(firebaseUser.getEmail());
    }
    public void sendEmailVerification(View v){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        if(user!= null){
            user.sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(verification.this, "Verification Mail Sent!", Toast.LENGTH_LONG).show();
                        firebaseAuth.signOut();
                        startActivity(new Intent(verification.this,login.class));
                    }else {
                        Toast.makeText(verification.this, "Verification Email not sent, Try Again1", Toast.LENGTH_LONG).show();
                    }
                }
            });
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        firebaseAuth.signOut();
        startActivity(new Intent(verification.this,login.class));
    }
}
