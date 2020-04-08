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
import com.nopalyer.navigationdrawer.student.clubs.activities.DetailActivity1;
import com.nopalyer.navigationdrawer.student.clubs.models.TClubs;

import java.util.ArrayList;

public class ItemCardViewAdapter1 extends RecyclerView.Adapter<ItemCardViewAdapter1.CardViewHolder> {
    private Context context;
    private ArrayList<TClubs> listTClubs;

    public ItemCardViewAdapter1(Context context) {
        this.context = context;
    }

    public ArrayList<TClubs> getListTClubs() {
        return listTClubs;
    }

    public void setListTClubs(ArrayList<TClubs> listTClubs) {
        this.listTClubs = listTClubs;
    }
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview, parent, false);
        return new CardViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ItemCardViewAdapter1.CardViewHolder holder, final int position) {
        holder.tvName.setText(getListTClubs().get(position).getName());
        holder.tvDescription.setText(getListTClubs().get(position).getDescription());
        Glide.with(context).load(getListTClubs().get(position).getPhoto()).into(holder.imgPhoto);

        // intent parcel able to detail
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent detailActivity = new Intent(context, DetailActivity1.class);
                detailActivity.putExtra(DetailActivity1.EXTRA_TCLUBS, listTClubs.get(position));
                context.startActivity(detailActivity);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListTClubs().size();
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
            button = itemView.findViewById(R.id.savedetails);
        }
    }
}
