package com.nopalyer.navigationdrawer.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.Clu;

public class StudentsPage extends AppCompatActivity {

    CardView faculty_card,clubs_card;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students_page);

        faculty_card=(CardView) findViewById(R.id.faculty_card);
        clubs_card = (CardView) findViewById(R.id.club);

        faculty_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this,"Faculties Of NITH",Toast.LENGTH_SHORT);
                startActivity(new Intent(StudentsPage.this, com.nopalyer.navigationdrawer.student.branchfaculty.faculty2.class));
            }
        });
        clubs_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(StudentsPage.this,"Clubs Of NITH",Toast.LENGTH_SHORT);
                startActivity(new Intent(StudentsPage.this,com.nopalyer.navigationdrawer.student.clubs.Clu.class));
            }
        });

    }
}
