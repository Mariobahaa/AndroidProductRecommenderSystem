package com.example.recomendationsystem.View.Activities

import android.opengl.Visibility
import android.os.Bundle
import android.service.quicksettings.Tile
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recomendationsystem.Model.Recomendations.recomend
import com.example.recomendationsystem.Model.ResponseModel.AmazonScrappingResponseModel
import com.example.recomendationsystem.Model.ResponseModel.ModelResponse
import com.example.recomendationsystem.R
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Adapters.recomend_Adapter
import com.example.recomendationsystem.View.Navigators.RecommendationNavigator
import com.example.recomendationsystem.databinding.ActivityRecommendationsBinding
import com.example.recomendationsystem.viewmodels.RecommendationsViewModel
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class RecommendationsActivity : AppCompatActivity(),RecommendationNavigator {
    lateinit var binding: ActivityRecommendationsBinding
    lateinit var viewModel: RecommendationsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: recomend_Adapter
    private lateinit var recomendList: ArrayList<recomend>
    private lateinit var collaborativeCandidates:HashMap<String,String>
   private lateinit var  categoryPath:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_recommendations
        )
        viewModel = RecommendationsViewModel(this)

//        viewModel.getModelResponse()
//        viewModel.getUserFakeID("A1118RD3AJD5KH")
//        viewModel.getUserProducts()
//        viewModel.getRecommendationData("B00006L9LC")
//        viewModel.getRecommendationData("B0000530HU")
//        viewModel.mutableLiveData.observe(this,object :Observer<AmazonScrappingResponseModel>{
//            override fun onChanged(t: AmazonScrappingResponseModel?) {
//                TODO("Not yet implemented")
//            }
//        })

        recomendList = arrayListOf()
        recyclerView = findViewById(R.id.recomend_RecyclerView)
        recyclerView.layoutManager = GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, true)

        binding.brogressBar.visibility = View.VISIBLE
        binding.shadowLayout.visibility = View.VISIBLE

//        binding.progressBar.visibility = View.VISIBLE

        categoryPath = intent.getStringExtra(VALUES.CATEGORY_Path_KEY)!!
        collaborativeCandidates = intent.getSerializableExtra(VALUES.COLLABORATIVE_RESPONSE_KEY) as HashMap<String, String>
        viewModel.getUserFakeProducts(collaborativeCandidates.keys.toList())


    }

    override fun onModelResponse(response: ModelResponse?) {

        viewModel.getUserRealProducts(response!!.idList)
    }

    override fun onScrapingResponse(scrapingResponse: AmazonScrappingResponseModel) {
        var title =  scrapingResponse.title
        var rating =  scrapingResponse.rating
        var price =  scrapingResponse.price
        var image =  scrapingResponse.image

        title = title.replace("\n","")
        rating = rating.replace("\n","")
        title = title.replace("\n","")
        price = price.replace("\n","")

        var recommendItem = recomend(title,rating,price,image)
        recomendList.add(recommendItem)
    }

    override fun onScrapingFinish() {
        adapter = recomend_Adapter(this, recomendList)
        recyclerView.setAdapter(adapter)
        binding.brogressBar.visibility = View.GONE
        binding.shadowLayout.visibility = View.GONE
    }


}