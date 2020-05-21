package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.nopalyer.navigationdrawer.teacher.tpassign;

public class UploadedAssignment extends AppCompatActivity {

    Toolbar toolbar;
    Spinner sp1,sp2;
    Button show;
    ArrayAdapter<String> adapter_year,adapter_group,adapter_department;
    public static String dep,year2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploaded_assignment);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Uploaded Assignment");
        toolbar.setTitleTextColor(Color.WHITE);

        sp1 = (Spinner) findViewById(R.id.uploadassignsp3);
        sp2 = (Spinner) findViewById(R.id.uploadassignsp4);
        show = (Button) findViewById(R.id.tpassignshow);

        final String[] year = {"Choose year", "1st year", "2nd year", "3rd year", "4th year"};
        final String[] group = {"Choose group", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        final String[] department = {"Choose branch", "CSE", "CSE DD", "ECE", "ECE DD", "Mechanical", "Civil", "Electrical", "Architecture", "Material Science", "Chemical"};

        adapter_year = new ArrayAdapter<>(UploadedAssignment.this, R.layout.colourful_spinner_items, year);
        adapter_year.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
        sp1.setAdapter(adapter_year);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    show.setEnabled(false);
                }
                if (position == 1) {
                    adapter_group = new ArrayAdapter<String>(UploadedAssignment.this, R.layout.colourful_spinner_items, group);
                    adapter_group.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_group);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = group[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = group[position];
                            }

                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 2) {
                    adapter_department = new ArrayAdapter<String>(UploadedAssignment.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 3) {
                    adapter_department = new ArrayAdapter<String>(UploadedAssignment.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> parent) {

                        }
                    });
                }

                if (position == 4) {
                    adapter_department = new ArrayAdapter<String>(UploadedAssignment.this, R.layout.colourful_spinner_items, department);
                    adapter_department.setDropDownViewResource(R.layout.colourful_spinner_dropdown);
                    sp2.setAdapter(adapter_department);
                    year2 = year[position];
                    sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                            if (position == 0) {
                                show.setEnabled(false);
                            }
                            if (position == 1) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 2) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 3) {
                                show.setEnabled(true);
                                dep = department[position];
                            }

                            if (position == 4) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 5) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 6) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 7) {
                                show.setEnabled(true);
                                dep = department[position];

                            }
                            if (position == 8) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 9) {
                                show.setEnabled(true);
                                dep = department[position];
                            }
                            if (position == 10) {
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
    }
}
