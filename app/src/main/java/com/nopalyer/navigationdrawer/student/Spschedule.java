package com.nopalyer.navigationdrawer.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
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
import java.util.ArrayList;

public class Spschedule extends AppCompatActivity {

    private PDFView pdfView;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ProgressDialog pd;
    private Spinner sp1,sp2;
    public static String dep,year2;
    private Button show;
    ArrayAdapter<String> adapter_year,adapter_group,adapter_department;
    SharedPreferences sharedprefs;
    SharedPreferences.Editor editor;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spschedule);
        pdfView = findViewById(R.id.kya);
        pd =new ProgressDialog(this);
        firebaseDatabase = FirebaseDatabase.getInstance();

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Schedule");
        toolbar.setTitleTextColor(Color.WHITE);

        // SPINNER STARTS==========================================================================================================================

        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);
        show = (Button) findViewById(R.id.show);

        final String[] year = {"Choose year","1st","2nd","3rd","4th"};
        final String[] group = {"Choose group","A","B","C","D","E","F","G","H","I","J"};
        final String[] department = {"Choose branch","CSE","CSE DD","ECE","ECE DD","Mechanical","Civil","Electrical","Architecture","Material Science","Chemical"};

        sharedprefs = getSharedPreferences("yash",MODE_PRIVATE);
        editor=sharedprefs.edit();

        final int lastposition_yr = sharedprefs.getInt("lastselected_yr",0);
        final int lastposition_grp = sharedprefs.getInt("lastselected_grp",0);
        final int lastposition_dep = sharedprefs.getInt("lastselected_dep",0);

        adapter_year= new ArrayAdapter<>(Spschedule.this,R.layout.colourful_spinner_items,year);
        adapter_year.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
        sp1.setAdapter(adapter_year);
        sp1.setSelection(lastposition_yr);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                editor.putInt("lastselected_yr",position).apply();

                if(position==0)
                {
                    show.setEnabled(false);
                }
                if(position==1)
                {
                    adapter_group = new ArrayAdapter<String>(Spschedule.this,R.layout.colourful_spinner_items,group);
                    adapter_group.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_group);
                    sp2.setSelection(lastposition_grp);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                        {
                            editor.putInt("lastselected_grp",position).apply();
                          if(position==0)
                          {
                           show.setEnabled(false);
                          }
                            if(position==1)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==2)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==3)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==4)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==6)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==7)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==8)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if(position==10)
                            {
                                show.setEnabled(true);
                                dep = group[position];
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==2)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,R.layout.colourful_spinner_items,department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                        {
                            editor.putInt("lastselected_dep",position).apply();

                            if(position==0)
                            {
                                show.setEnabled(false);
                            }
                            if(position==1)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==2)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==3)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==4)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==6)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==7)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==8)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==10)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==3)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,R.layout.colourful_spinner_items,department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                        {
                            editor.putInt("lastselected_dep",position).apply();
                            if(position==0)
                            {
                                show.setEnabled(false);
                            }
                            if(position==1)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==2)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==3)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==4)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==6)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==7)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==8)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==10)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==4)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,R.layout.colourful_spinner_items,department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
                        {
                            editor.putInt("lastselected_dep",position).apply();
                            if(position==0)
                            {
                                show.setEnabled(false);
                            }
                            if(position==1)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==2)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==3)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }

                            if(position==4)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==6)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==7)
                            {
                                show.setEnabled(true);
                                dep = department[position];

                            }
                            if(position==8)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if(position==10)
                            {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // SPINNER ENDS==================================================================================================================================

        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd.setMessage("Loading... ! Please Smile");
                pd.setCancelable(false);
                pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                pd.show();
                databaseReference = firebaseDatabase.getReference("Schedule");
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String FirstYearA = dataSnapshot.child("FirstYearA").getValue().toString();
                        String FirstYearB = dataSnapshot.child("FirstYearB").getValue().toString();
                        String FirstYearC = dataSnapshot.child("FirstYearC").getValue().toString();
                        String FirstYearD = dataSnapshot.child("FirstYearD").getValue().toString();
                        String FirstYearE = dataSnapshot.child("FirstYearE").getValue().toString();
                        String FirstYearF = dataSnapshot.child("FirstYearF").getValue().toString();
                        String FirstYearG = dataSnapshot.child("FirstYearG").getValue().toString();
                        String FirstYearH = dataSnapshot.child("FirstYearH").getValue().toString();
                        String FirstYearI = dataSnapshot.child("FirstYearI").getValue().toString();
                        String FirstYearJ = dataSnapshot.child("FirstYearJ").getValue().toString();
                        String url = "";
                        if(year2.equals("1st") && dep.equals("A")){
                            url = FirstYearA;
                        }if(year2.equals("1st") && dep.equals("B")){
                            url = FirstYearB;
                        }if(year2.equals("1st") && dep.equals("C")){
                            url = FirstYearC;
                        }if(year2.equals("1st") && dep.equals("D")){
                            url = FirstYearD;
                        }if(year2.equals("1st") && dep.equals("E")){
                            url = FirstYearE;
                        }if(year2.equals("1st") && dep.equals("F")){
                            url = FirstYearF;
                        }if(year2.equals("1st") && dep.equals("G")){
                            url = FirstYearG;
                        }if(year2.equals("1st") && dep.equals("H")){
                            url = FirstYearH;
                        }if(year2.equals("1st") && dep.equals("I")){
                            url = FirstYearI;
                        }if(year2.equals("1st") && dep.equals("J")){
                            url = FirstYearJ;
                        }
                        new RetrievePDFStream().execute(url);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
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
