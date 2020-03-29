package com.nopalyer.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class fresh extends AppCompatActivity {
    ArrayList<Integer> mImageIds = new ArrayList<>(Arrays.asList(
            R.drawable.aag1,R.drawable.aag2, R.drawable.aag3,R.drawable.aag4, R.drawable.aag5,R.drawable.aag6,
            R.drawable.aag7,R.drawable.aag8, R.drawable.aag9,R.drawable.aag10, R.drawable.aag11,R.drawable.aag12
    ));


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fresh);
        GridView gridView = findViewById(R.id.myGrid);
        gridView.setAdapter(new ImageAdaptor(mImageIds, this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int item_pos = mImageIds.get(position);

                ShowDialogBox(item_pos);

            }
        });
    }
    public void ShowDialogBox(final int item_pos){
        final Dialog dialog = new Dialog(this);

        dialog.setContentView(R.layout.custom_dialog);
        TextView Image_name = dialog.findViewById(R.id.txt_Image_name);
        ImageView Image = dialog.findViewById(R.id.img);
        Button btn_Full = dialog.findViewById(R.id.btn_full);
        Button btn_Close = dialog.findViewById(R.id.btn_close);

        String title = getResources().getResourceName(item_pos);

        int index = title.indexOf("/");
        String name = title.substring(index+1,title.length());
        Image_name.setText(name);

        Image.setImageResource(item_pos);

        btn_Close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        btn_Full.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(fresh.this,FullView.class);
                i.putExtra("img_id",item_pos);
                startActivity(i);

            }
        });

        dialog.show();

    }

}

