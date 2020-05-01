package com.nopalyer.navigationdrawer.student.Register;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nopalyer.navigationdrawer.Bonafide_Application;
import com.nopalyer.navigationdrawer.Btech_registration;
import com.nopalyer.navigationdrawer.R;

import java.util.ArrayList;

public class SimpleRecyclerAdapter2 extends RecyclerView.Adapter<SimpleRecyclerAdapter2.SimpleViewHolder> {

    private Context context;
    private ArrayList<reg> listreg;

    public SimpleRecyclerAdapter2(Context context) {
        this.context = context;
        this.listreg = listreg;
    }


    public ArrayList<reg> getListreg() {
        return listreg;
    }

    public void setListreg(ArrayList<reg> listreg) {
        this.listreg = listreg;
    }

    @NonNull
    @Override
    public SimpleRecyclerAdapter2.SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item2,parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleRecyclerAdapter2.SimpleViewHolder holder, final int position) {
        holder.textView.setText(getListreg().get(position).getName());
        Glide.with(context).load(getListreg().get(position).getPhoto()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                switch (position){
                    case 0:
                        intent= new Intent(context, Btech_registration.class);
                        break;
                    case 1:
                        intent= new Intent(context, Bonafide_Application.class);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listreg.size();
    }
    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;
        public ImageView imageView;
        public CardView cardView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textViewka);
            imageView = (ImageView) itemView.findViewById(R.id.imageka);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
        }
    }
}
