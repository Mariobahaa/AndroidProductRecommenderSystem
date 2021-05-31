package com.example.recomendationsystem.View.Adapters;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recomendationsystem.R;
import com.example.recomendationsystem.View.ViewHolders.Categries_ViewHolder;

import java.util.List;
public class Categories_Adapter extends RecyclerView.Adapter<Categries_ViewHolder> {
    private Context context;
    private int [] images;
    private String [] tittles;
    private OnRecomendListener rOnRecomendListener;

    public Categories_Adapter(Context context, int []images, String []tittles, OnRecomendListener rOnRecomendListener) {
        this.context =context;
        this.images = images;
        this.tittles = tittles;
        this.rOnRecomendListener = rOnRecomendListener;
    }

    @NonNull
    @Override
    public Categries_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.categorycard,parent,false);
        GridLayoutManager.LayoutParams lp = (GridLayoutManager.LayoutParams) view.getLayoutParams();
        lp.height = parent.getMeasuredHeight() / 2;
        view.setLayoutParams(lp);
        return new Categries_ViewHolder(view,rOnRecomendListener);
    }

    @Override
    public void onBindViewHolder(@NonNull Categries_ViewHolder holder, int position) {
        holder.cat_tittle.setText(tittles[position] +"");
        holder.imageView.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return images.length;
    }

    public interface OnRecomendListener{
        void onRecomendClick(int position);
    }
}
