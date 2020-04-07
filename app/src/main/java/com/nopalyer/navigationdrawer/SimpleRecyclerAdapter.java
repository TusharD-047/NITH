package com.nopalyer.navigationdrawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class SimpleRecyclerAdapter extends RecyclerView.Adapter<SimpleRecyclerAdapter.SimpleViewHolder> {

    private ArrayList<hme> homepage;
    private Context context;

    public SimpleRecyclerAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<hme> getListhme() {
        return homepage;
    }

    public void setListDClubs(ArrayList<hme> homepage) {
        this.homepage = homepage;
    }

    @NonNull
    @Override
    public SimpleRecyclerAdapter.SimpleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item,parent, false);

        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SimpleViewHolder holder, final int position) {
        holder.textView.setText(getListhme().get(position).getName());
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Intent intentu;
                switch (position){
                    case 0:
                        intentu = new Intent(context,news.class);
                        break;
                    case 1:
                        intentu = new Intent(context,achievement.class);
                        break;
                    case 2:
                        intentu = new Intent(context,campus.class);
                        break;
                    case 3:
                        intentu = new Intent(context,tender.class);
                        break;
                    default:
                        throw new IllegalStateException("Unexpected value: " + position);
                }
                context.startActivity(intentu);
            }
        });

    }


    @Override
    public int getItemCount() {
        return getListhme().size();
    }

    public static class SimpleViewHolder extends RecyclerView.ViewHolder {

        public TextView textView;

        public SimpleViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.textView);
        }
    }

}
