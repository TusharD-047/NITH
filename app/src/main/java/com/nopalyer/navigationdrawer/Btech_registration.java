package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class Btech_registration extends AppCompatActivity {

    private EditText dob,name,fname,roll,sem,cat;
    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech_registration);

        Button submit = (Button) findViewById(R.id.Image);
        name = (EditText) findViewById(R.id.editText26);
        fname = (EditText) findViewById(R.id.editText27);
        roll = (EditText) findViewById(R.id.editText28);
        dob = (EditText) findViewById(R.id.editText29);
        dob.setKeyListener(null);
        sem = (EditText) findViewById(R.id.editText30);
        cat = (EditText) findViewById(R.id.editText31);


        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear,
                                  int dayOfMonth) {
                // TODO Auto-generated method stub
                myCalendar.set(Calendar.YEAR, year);
                myCalendar.set(Calendar.MONTH, monthOfYear);
                myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                updateLabel();
            }

        };

        dob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(Btech_registration.this, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bd = new Bundle();
                bd.putString("Name", name.getText().toString());
                bd.putString("Father's Name", fname.getText().toString());
                bd.putString("Roll Number", roll.getText().toString());
                bd.putString("Date Of Birth", dob.getText().toString());
                bd.putString("Semester", sem.getText().toString());
                bd.putString("Category", cat.getText().toString());
                Intent it = new Intent(Btech_registration.this,ViewActivity.class);
                it.putExtras(bd);
                startActivity(it);
            }
        });
    }

    private void updateLabel() {
        String myFormat = "dd/MM/yyyy"; //In which you need put here
        SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);

        dob.setText(sdf.format(myCalendar.getTime()));
    }
}
