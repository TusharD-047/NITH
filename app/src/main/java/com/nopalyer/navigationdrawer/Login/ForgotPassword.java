package com.nopalyer.navigationdrawer.Login;

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
import com.nopalyer.navigationdrawer.R;

public class ForgotPassword extends AppCompatActivity {

    private EditText email;
    private Button sendemail;
    private FirebaseAuth firebaseAuth5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        email = (EditText) findViewById(R.id.editText5);
        sendemail = (Button)findViewById(R.id.button3);

        firebaseAuth5 = FirebaseAuth.getInstance();

        sendemail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth5.sendPasswordResetEmail(email.getText().toString()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(ForgotPassword.this,"Password Send to your Email", Toast.LENGTH_LONG).show();

                        }else{
                            Toast.makeText(ForgotPassword.this,task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });
    }
}
