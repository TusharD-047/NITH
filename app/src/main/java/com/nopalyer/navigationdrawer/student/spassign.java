package com.nopalyer.navigationdrawer.student;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.uploadPDF;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class spassign extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference,ref,ref2;
    private ListView ListForm;
    List<uploadPDF> uploadPDFS;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spassign);

        firebaseAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance();
        ListForm = (ListView)findViewById(R.id.ListPDF);
        pd =new ProgressDialog(this);
        uploadPDFS = new ArrayList<>();

        ref =firebaseDatabase.getReference(firebaseAuth.getUid()).child("Profile");
        ref2 = firebaseDatabase.getReference("Group").child(firebaseAuth.getUid());

        pd.setMessage("Loading... ! Please Smile");
        pd.setCancelable(false);
        pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        pd.show();
        viewAllFiles();

        ListForm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                uploadPDF uploadPDF = uploadPDFS.get(position);

                Intent intent = new Intent();
                intent.setType(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(uploadPDF.getUrl()));
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Intent newIntent = Intent.createChooser(intent,"Open File");
                startActivity(newIntent);
            }
        });
    }

    private void viewAllFiles() {

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String year = dataSnapshot.child("name").getValue().toString();

                ref2.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String branch = dataSnapshot.child("group").getValue().toString();
                        databaseReference = FirebaseDatabase.getInstance().getReference("Assignment").child(year).child(branch);
                        databaseReference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot postSnapshot: dataSnapshot.getChildren()){

                                    uploadPDF uploadPDF = postSnapshot.getValue(com.nopalyer.navigationdrawer.uploadPDF.class);
                                    uploadPDFS.add(uploadPDF);
                                }
                                String[] uploads = new String[uploadPDFS.size()];
                                for(int i=0; i<uploads.length;i++){
                                    uploads[i] = uploadPDFS.get(i).getNaMe();
                                }
                                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,uploads){

                                    @Override
                                    public View getView(int position, View convertView, ViewGroup parent) {

                                        View view = super.getView(position, convertView, parent);

                                        TextView myText = (TextView)view.findViewById(android.R.id.text1);
                                        myText.setTextColor(Color.BLACK);

                                        return view;
                                    }
                                };
                                ListForm.setAdapter(adapter);
                                pd.dismiss();
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Toast.makeText(spassign.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                                pd.dismiss();
                            }
                        });
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(spassign.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                        pd.dismiss();
                    }
                });
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(spassign.this,databaseError.getCode(),Toast.LENGTH_SHORT).show();
                pd.dismiss();
            }
        });
    }
}
