package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.nopalyer.navigationdrawer.Login.ForgotPassword;

public class login extends AppCompatActivity {

    private EditText email,password;
    private Button Login;
    private TextView ForgotPass;
    private TextView show_pass_button;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        email = (EditText)findViewById(R.id.email);
        password = (EditText)findViewById(R.id.pass);
        Login = (Button)findViewById(R.id.button);
        ForgotPass = (TextView)findViewById(R.id.textView);
        show_pass_button=(TextView)findViewById(R.id.showHide);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();

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

    private void validate(String username, String userpassword){
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
            firebaseAuth.signInWithEmailAndPassword(username, userpassword).addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(login.this, "Login successful", Toast.LENGTH_LONG).show();
                        //if (admin.equals(email))
                        //{ finish();
                        //startActivity(new Intent(login_form.this, AdminPage.class));
                        // finish();  }
                        // else
                        finish();
                        startActivity(new Intent(login.this, StudentsPage.class));
                        finish();

                    } else {
                        Toast.makeText(login.this, "Invalid Password or Email Id", Toast.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Toast.makeText(login.this, "Error Occurred", Toast.LENGTH_LONG).show();
        }
    }

    public void ShowHidePassword(View view)
    {
        if(view.getId()==R.id.showHide){
            if(password.getTransformationMethod().equals(PasswordTransformationMethod.getInstance())){
                ((ImageView)(view)).setImageResource(R.drawable.ic_remove_red_eye_black_24dp);
                password.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            }
            else{
                ((ImageView)(view)).setImageResource(R.drawable.ic_imgonline_com_ua_resize_m1azcot0r5md);
                password.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        }
    }
}
