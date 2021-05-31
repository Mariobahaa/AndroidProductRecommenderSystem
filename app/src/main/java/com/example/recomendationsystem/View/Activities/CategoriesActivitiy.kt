package com.example.recomendationsystem.View.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recomendationsystem.R
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Adapters.Categories_Adapter
import com.example.recomendationsystem.View.Adapters.Categories_Adapter.OnRecomendListener
import com.example.recomendationsystem.View.Navigators.CollaborativeNavigator
import com.example.recomendationsystem.databinding.ActivityCategoriesBinding
import com.example.recomendationsystem.viewmodels.CategoriesViewmodel
import java.io.Serializable

class CategoriesActivitiy : AppCompatActivity(),CollaborativeNavigator, OnRecomendListener{
    lateinit var binding: ActivityCategoriesBinding
    lateinit var viewModel: CategoriesViewmodel
    private lateinit var adapter: Categories_Adapter
    private lateinit var recyclerView: RecyclerView
    private val images = intArrayOf(
        R.drawable.beauty,
        R.drawable.art,
        R.drawable.electronics,
        R.drawable.software
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_categories
        )
        viewModel = CategoriesViewmodel(this)


        recyclerView = findViewById(R.id.re)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false)
        adapter = Categories_Adapter(this, images, VALUES.CATEGORY_TITLES, this)
        recyclerView.adapter = adapter

    }

    override fun onRecomendClick(position: Int) {
        intent = Intent(this, RecommendationsActivity::class.java)
        intent.putExtra(VALUES.CATEGORY_Path_KEY,  VALUES.CATEGORY_PATHES[position])
        viewModel.getUserProductsScores(VALUES.USER_REAL_ID, VALUES.CATEGORY_PATHES[position] )

    }

    override fun collaborativeResponse(response: HashMap<String, String>?) {
            intent.putExtra(VALUES.COLLABORATIVE_RESPONSE_KEY,response)
            startActivity(intent)
    }
}