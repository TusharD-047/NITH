package com.nopalyer.navigationdrawer.student;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.nopalyer.navigationdrawer.R;

public class StudentsPage extends AppCompatActivity {

    CardView faculty_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);

        faculty_card=(CardView) findViewById(R.id.faculty_card);

        faculty_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this,"Faculties Of NITH",Toast.LENGTH_SHORT);
                startActivity(new Intent(StudentsPage.this, faculty2.class));
            }
        });

    }
}
