package com.nopalyer.navigationdrawer.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.R;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Spschedule extends AppCompatActivity {

    private PDFView pdfView;
    public String Department = "";
    public String FirstYearCSE = "",FirstYearECE = "",FirstYearMechanical = "";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spschedule);
        pdfView = findViewById(R.id.kya);
        pd =new ProgressDialog(this);
        pd.setMessage("Loading... ! Please Smile");
        pd.setCancelable(false);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Schedule");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                FirstYearCSE = dataSnapshot.child("FirstYearCSE").getValue().toString();
                FirstYearECE = dataSnapshot.child("FirstYearECE").getValue().toString();
                FirstYearMechanical = dataSnapshot.child("FirstYearMechanical").getValue().toString();
                Intent intent = getIntent();
                Department = intent.getStringExtra("Department");
                String url = "";
                if(Department.equals("Electronics And Communication Engineering")){
                    url = FirstYearECE;
                }if(Department.equals("Mechanical Engineering")){
                    url = FirstYearMechanical;
                }if(Department.equals("Computer Science and Engineering")){
                    url = FirstYearCSE;
                }
                new RetrievePDFStream().execute(url);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
    class RetrievePDFStream extends AsyncTask<String,Void,InputStream>
    {
        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection urlConnection = (HttpURLConnection)url.openConnection();
                if(urlConnection.getResponseCode() == 200){
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                }
            }catch (IOException e)
            {
                return null;

            }
            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
            pd.dismiss();
        }

    }
}
