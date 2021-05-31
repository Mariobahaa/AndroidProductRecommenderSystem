package com.example.recomendationsystem.View.ViewHolders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recomendationsystem.R;

public class recomend_ViewHolder extends RecyclerView.ViewHolder {
   public ImageView imageView;
    public TextView textView1,textView2,rateView;
    public recomend_ViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.image);
        textView1 = itemView.findViewById(R.id.tittle);
        textView2 = itemView.findViewById(R.id.price);
        rateView = itemView.findViewById(R.id.rateView);
    }
}
