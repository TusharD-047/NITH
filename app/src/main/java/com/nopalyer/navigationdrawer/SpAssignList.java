package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.student.spassign;

import java.util.ArrayList;
import java.util.List;

public class SpAssignList extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference,ref2;
    private ListView ListForm;
    List<uploadPDF> uploadPDFS;
    ProgressDialog pd2;
    String year = "";
    String branch = "";
    String group,teacher;
    List<String> listDataHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sp_assign_list);

        Bundle bundle = getIntent().getExtras();
        year = bundle.getString("yr");
        branch = bundle.getString("branch");
        group = bundle.getString("group");
        teacher = bundle.getString("teacher");

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        ListForm = (ListView)findViewById(R.id.ListassignList);
        pd2 =new ProgressDialog(this);
        uploadPDFS = new ArrayList<>();
        ref2 = firebaseDatabase.getReference("Group").child(firebaseAuth.getUid());

        viewAllFiles();

        ListForm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listDataHeader.get(position);
                Intent i = new Intent(SpAssignList.this, SpAssignOpen.class);
                i.putExtra("title", item);
                i.putExtra("teacher", teacher);
                i.putExtra("yr",year);
                i.putExtra("group", group);
                i.putExtra("branch", branch);
                startActivity(i);
            }
        });
    }

    private void viewAllFiles() {

        listDataHeader = new ArrayList<>();
        if(year.equals("1st year")){
            pd2.setMessage("Loading Deprt... ! Please Smile");
            pd2.setCancelable(false);
            pd2.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            pd2.show();

            ref2.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    group = dataSnapshot.child("group").getValue().toString();
                    pd2.dismiss();
                    databaseReference = FirebaseDatabase.getInstance().getReference("Assignment").child(year).child(group).child(teacher);
                    databaseReference.addChildEventListener(new ChildEventListener() {
                        @Override
                        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                            final String headertitile = dataSnapshot.getKey();
                            listDataHeader.add(headertitile);

                            String[] uploads = new String[listDataHeader.size()];
                            for(int i=0; i<uploads.length;i++){
                                uploads[i] = listDataHeader.get(i);
                            }
                            ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                                @Override
                                public View getView(int position, View convertView, ViewGroup parent) {

                                    View view = super.getView(position, convertView, parent);

                                    TextView myText = (TextView)view.findViewById(android.R.id.text1);
                                    myText.setTextColor(Color.BLACK);
                                    myText.setTextSize(20);

                                    return view;
                                }
                            };
                            ListForm.setAdapter(adapter);
                        }

                        @Override
                        public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                        }

                        @Override
                        public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(SpAssignList.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                }
            });
        }else {
            databaseReference = FirebaseDatabase.getInstance().getReference("Assignment").child(year).child(branch).child(teacher);
            databaseReference.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                    final String headertitile = dataSnapshot.getKey();
                    listDataHeader.add(headertitile);

                    String[] uploads = new String[listDataHeader.size()];
                    for(int i=0; i<uploads.length;i++){
                        uploads[i] = listDataHeader.get(i);
                    }
                    ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                        @Override
                        public View getView(int position, View convertView, ViewGroup parent) {

                            View view = super.getView(position, convertView, parent);

                            TextView myText = (TextView)view.findViewById(android.R.id.text1);
                            myText.setTextColor(Color.BLACK);
                            myText.setTextSize(20);

                            return view;
                        }
                    };
                    ListForm.setAdapter(adapter);
                }

                @Override
                public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

    }
}
