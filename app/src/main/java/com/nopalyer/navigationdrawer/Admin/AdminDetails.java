package com.nopalyer.navigationdrawer.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.uploadPDF;

import java.util.ArrayList;
import java.util.List;

public class AdminDetails extends AppCompatActivity {

    private ListView ListForm;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    List<uploadPDF> uploadPDFS;
    String yr,dep,roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_details);

        yr = getIntent().getExtras().getString("yr");
        dep = getIntent().getExtras().getString("dep");
        roll = getIntent().getExtras().getString("roll");

        firebaseAuth = FirebaseAuth.getInstance();
        ListForm = (ListView)findViewById(R.id.ListDetails);
        uploadPDFS = new ArrayList<>();

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
        databaseReference = FirebaseDatabase.getInstance().getReference("Application Form").child(yr).child(dep).child(roll);
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
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
