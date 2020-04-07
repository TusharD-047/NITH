package com.nopalyer.navigationdrawer.student.clubs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.nopalyer.navigationdrawer.R;
import com.nopalyer.navigationdrawer.student.clubs.activities.DetailActivity;
import com.nopalyer.navigationdrawer.student.clubs.models.DClubs;

import java.util.ArrayList;

public class ItemCardViewAdapter extends RecyclerView.Adapter<ItemCardViewAdapter.CardViewHolder> {
    private Context context;
    private ArrayList<DClubs> listDClubs;

    public ItemCardViewAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<DClubs> getListDClubs() {
        return listDClubs;
    }

    public void setListDClubs(ArrayList<DClubs> listDClubs) {
        this.listDClubs = listDClubs;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, final int position) {
        holder.tvName.setText(getListDClubs().get(position).getName());
        holder.tvDescription.setText(getListDClubs().get(position).getDescription());
        Glide.with(context).load(getListDClubs().get(position).getPhoto()).into(holder.imgPhoto);

        // intent parcel able to detail
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(context, DetailActivity.class);
                detailActivity.putExtra(DetailActivity.EXTRA_DCLUBS, listDClubs.get(position));
                context.startActivity(detailActivity);
            }
        });
    }


    @Override
    public int getItemCount() {
        return getListDClubs().size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView tvName, tvDescription;
        Button button;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_card);
            tvName = itemView.findViewById(R.id.tv_name_card);
            tvDescription = itemView.findViewById(R.id.tv_desc_card);
            button = itemView.findViewById(R.id.button);
        }
    }
}
