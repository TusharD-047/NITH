package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.Admin.AdminActivity;
import com.nopalyer.navigationdrawer.Login.ForgotPassword;
import com.nopalyer.navigationdrawer.Login.verification;
import com.nopalyer.navigationdrawer.student.StudentsPage;
import com.nopalyer.navigationdrawer.teacher.Tpmain;

public class login extends AppCompatActivity {

    private EditText email,password;
    private Button Login;
    private TextView ForgotPass;
    private TextView showHide;
    private FirebaseAuth firebaseAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private int ShowPass;
    Boolean isFirstRun;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true);

        email = (EditText)findViewById(R.id.email1);
        password = (EditText)findViewById(R.id.pass);
        Login = (Button)findViewById(R.id.sendmail);
        ForgotPass = (TextView)findViewById(R.id.email3);
        showHide=(TextView)findViewById(R.id.newpass1);
        pd =new ProgressDialog(this);
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();

        if(firebaseUser != null){
            String role = getIntent().getExtras().getString("roless");
            if(role.equals("teacher")){
                startActivity(new Intent(login.this,Tpmain.class));
            }if(role.equals("student")) {
                startActivity(new Intent(login.this,StudentsPage.class));
            }if(role.equals("admin")){
                startActivity(new Intent(login.this, AdminActivity.class));
            }
        }else {
            firebaseAuth = FirebaseAuth.getInstance();
            Login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    validate(email.getText().toString(),password.getText().toString());
                }
            });

            ForgotPass.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(login.this, ForgotPassword.class));
                }
            });
        }

        ShowPass = 1;
        showHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ShowPass ==1)
                {
                    ShowPass =0;
                    password.setTransformationMethod(null);
                    if(password.getText().length()>0)
                        password.setSelection(password.getText().length());
                    showHide.setBackgroundResource(R.drawable.ic_images2);

                }
                else{
                    ShowPass=1;
                    password.setTransformationMethod(new PasswordTransformationMethod());
                    if(password.getText().length()>0)
                        password.setSelection(password.getText().length());
                    showHide.setBackgroundResource(R.drawable.ic_images1);
                }
            }
        });

    }

    private void validate(final String username, String userpassword){
        if (TextUtils.isEmpty(username) && TextUtils.isEmpty(userpassword)) {
            Toast.makeText(login.this, "Please enter all fields", Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(username)) {
            Toast.makeText(login.this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        } else if (TextUtils.isEmpty(userpassword)) {
            Toast.makeText(login.this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        } else if (userpassword.length() < 6) {
            Toast.makeText(login.this, " Password Incorrect!", Toast.LENGTH_LONG).show();
        } else if (!(username.isEmpty() && userpassword.isEmpty())) {
            pd.setMessage("Signing In ! Please Smile");
            pd.setCancelable(false);
            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd.show();

            firebaseAuth.signInWithEmailAndPassword(username, userpassword).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        checkEmailVerification();
                    }else{
                        Toast.makeText(login.this, "Invalid Password or Email Id", Toast.LENGTH_LONG).show();
                        pd.dismiss();
                    }
                }
            });
        } else {
            Toast.makeText(login.this, "Error Occurred", Toast.LENGTH_LONG).show();
        }
    }


    private void checkEmailVerification(){
        FirebaseUser user = firebaseAuth.getCurrentUser();
        Boolean emailflag = user.isEmailVerified();

        if(emailflag){
            Toast.makeText(login.this, "Login successful", Toast.LENGTH_LONG).show();
            finish();
            databaseReference = firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
            databaseReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    String role = dataSnapshot.child("role").getValue().toString();

                    if(role.equals("teacher")){
                        startActivity(new Intent(login.this,Tpmain.class));
                        pd.dismiss();
                    }if(role.equals("student")) {
                        startActivity(new Intent(login.this,StudentsPage.class));
                        pd.dismiss();
                    }if(role.equals("admin")){
                        startActivity(new Intent(login.this,AdminActivity.class));
                        pd.dismiss();
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }else {
            Toast.makeText(login.this, "Verify Your Email", Toast.LENGTH_LONG).show();
            finish();
            if (isFirstRun) {

                //show start activity
                startActivity(new Intent(login.this,verification.class));
            }else{
                Toast.makeText(login.this, "Email Already Sent", Toast.LENGTH_LONG)
                        .show();
            }

            getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                    .putBoolean("isFirstRun", false).apply();
        }
    }
}
