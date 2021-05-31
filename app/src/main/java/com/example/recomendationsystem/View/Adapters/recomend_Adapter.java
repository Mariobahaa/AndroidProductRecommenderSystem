package com.example.recomendationsystem.View.Adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recomendationsystem.Model.Recomendations.recomend;
import com.example.recomendationsystem.R;
import com.example.recomendationsystem.View.ViewHolders.recomend_ViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class recomend_Adapter extends RecyclerView.Adapter<recomend_ViewHolder> {
    private Context context;
    private ArrayList<recomend> recomendList;

    public recomend_Adapter(Context context, ArrayList<recomend> recomendList) {
        this.context = context;
        this.recomendList = recomendList;
    }

    @NonNull
    @Override
    public recomend_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recomend_card,parent,false);
        return new recomend_ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull recomend_ViewHolder holder, int position) {
        Picasso.get().load(recomendList.get(position).getPhoto()).into(holder.imageView);
        //holder.imageView.setImageURI(recomendList.get(position).getPhoto());
        holder.textView1.setText(recomendList.get(position).getTittle());
        holder.textView2.setText(recomendList.get(position).getPrice() +"");
        holder.rateView.setText(recomendList.get(position).getRate());

    }

    @Override
    public int getItemCount() {
        return recomendList.size();
    }

}
