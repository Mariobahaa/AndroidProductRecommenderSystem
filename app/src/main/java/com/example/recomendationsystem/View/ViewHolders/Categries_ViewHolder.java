package com.example.recomendationsystem.View.ViewHolders;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recomendationsystem.R;
import com.example.recomendationsystem.View.Adapters.Categories_Adapter;

public class Categries_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    public TextView cat_tittle;
    public ImageView imageView;
    Categories_Adapter.OnRecomendListener onRecomendListener;
    public Categries_ViewHolder(@NonNull View itemView, Categories_Adapter.OnRecomendListener onRecomendListener) {
        super(itemView);
        imageView = itemView.findViewById(R.id.cat_image);
        cat_tittle = itemView.findViewById(R.id.cat_tittle);
        itemView.setClickable(true);
        this.onRecomendListener = onRecomendListener;
        itemView.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        onRecomendListener.onRecomendClick(getAdapterPosition());
    }
}
