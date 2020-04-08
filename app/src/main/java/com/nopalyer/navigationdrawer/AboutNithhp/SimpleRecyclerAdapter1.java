package com.nopalyer.navigationdrawer.AboutNithhp;

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
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.about_city;
import com.nopalyer.navigationdrawer.about_college;
import com.nopalyer.navigationdrawer.srijan;
import com.nopalyer.navigationdrawer.vision;

import java.util.ArrayList;

public class SimpleRecyclerAdapter1 extends RecyclerView.Adapter<SimpleRecyclerAdapter1.SimpleViewHolder> {
    private Context context;
    private ArrayList<Abnith> listAbnith;

    public SimpleRecyclerAdapter1(ArrayList<Abnith> listAbnith) {
        this.listAbnith = listAbnith;
    }

    public SimpleRecyclerAdapter1(Context context) {
        this.context = context;
    }

    public ArrayList<Abnith> getListAbnith() {
        return listAbnith;
    }

    public void setListAbnith(ArrayList<Abnith> listAbnith) {
        this.listAbnith = listAbnith;
    }

    @NonNull
    @Override
    public SimpleRecyclerAdapter1.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item1,parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleRecyclerAdapter1.SimpleViewHolder holder, final int position) {
        holder.textView.setText(getListAbnith().get(position).getName());
        Glide.with(context).load(getListAbnith().get(position).getPhoto()).into(holder.imageView);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intent;
                switch (position){
                    case 0:
                            intent= new Intent(context, about_city.class);
                            break;
                    case 1:
                        intent= new Intent(context, about_college.class);
                        break;
                    case 2:
                        intent= new Intent(context, srijan.class);
                        break;
                    case 3:
                        intent= new Intent(context, vision.class);
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
        return listAbnith.size();
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
