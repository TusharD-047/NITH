package com.nopalyer.navigationdrawer.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
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
    public String Department = "";
    public String FirstYearCSE = "",FirstYearECE = "",FirstYearMechanical = "";
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    ProgressDialog pd;
    private Spinner sp1,sp2;
    private Button show;
    ArrayAdapter<String> adapter_year,adapter_group,adapter_department;
    SharedPreferences sharedprefs;
    SharedPreferences.Editor editor;

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

        // SPINNER STARTS==========================================================================================================================

        sp1 = (Spinner) findViewById(R.id.sp1);
        sp2 = (Spinner) findViewById(R.id.sp2);
        show = (Button) findViewById(R.id.show);

        final String[] year = {"Choose year","1st","2nd","3rd","4th"};
        final String[] group = {"Choose group","A","B","C","D","E","F","G","H","I","J"};
        final String[] department = {"Choose department","CSE","CSE DD","ECE","ECE DD","Mechanical","Civil","Electrical","Architecture","Material Science","Chemical"};

        sharedprefs = getSharedPreferences("yash",MODE_PRIVATE);
        editor=sharedprefs.edit();

        final int lastposition_yr = sharedprefs.getInt("lastselected_yr",0);
        final int lastposition_grp = sharedprefs.getInt("lastselected_grp",0);
        final int lastposition_dep = sharedprefs.getInt("lastselected_dep",0);

        adapter_year= new ArrayAdapter<>(Spschedule.this,android.R.layout.simple_spinner_item,year);
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
                    adapter_group = new ArrayAdapter<String>(Spschedule.this,android.R.layout.simple_spinner_item,group);
                    sp2.setAdapter(adapter_group);
                    sp2.setSelection(lastposition_grp);
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
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                       Toast.makeText(Spschedule.this,"You Selected A group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==2)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected B group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==3)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected C group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==4)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected D group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==5)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==6)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==7)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==8)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==10)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected E group",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==2)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,android.R.layout.simple_spinner_item,department);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);

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
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==2)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==3)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==4)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==5)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==6)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==7)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==8)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==10)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 2nd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==3)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,android.R.layout.simple_spinner_item,department);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);

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
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==2)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==3)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==4)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==6)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==7)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==8)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==10)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 3rd year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if(position==4)
                {
                    adapter_department = new ArrayAdapter<String>(Spschedule.this,android.R.layout.simple_spinner_item,department);
                    sp2.setAdapter(adapter_department);
                    sp2.setSelection(lastposition_dep);

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
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==2)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==3)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==4)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==5)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year cse",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==6)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year cse dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==7)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==8)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                            if(position==9)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece",Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }

                            if(position==10)
                            {
                                show.setEnabled(true);
                                show.setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Toast.makeText(Spschedule.this,"You Selected 4th year ece dd",Toast.LENGTH_SHORT).show();
                                    }
                                });
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
