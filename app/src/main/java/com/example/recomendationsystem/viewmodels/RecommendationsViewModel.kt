package com.example.recomendationsystem.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.recomendationsystem.Model.ResponseModel.*
import com.example.recomendationsystem.Retrofit.CallBacks.AmazonScrappingApi
import com.example.recomendationsystem.Retrofit.CallBacks.ModelApi
import com.example.recomendationsystem.Retrofit.CallBacks.UserApi
import com.example.recomendationsystem.Retrofit.Clients.RetrofitClient
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Navigators.RecommendationNavigator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class RecommendationsViewModel(var navigator:RecommendationNavigator) {
//    lateinit var mutableLiveData:MutableLiveData<AmazonScrappingResponseModel>
    var scrapingItems = 0
    companion object{
        var scrapingItemCounter = 0
    }
    fun getRecommendationData(productID:String){
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.AMAZON_PORT)
        val amazonScrapingApi:AmazonScrappingApi = retrofitClient.create(AmazonScrappingApi::class.java)

        amazonScrapingApi.getScrapingResponse(productID).enqueue(object : retrofit2.Callback<AmazonScrappingResponseModel>{
            override fun onFailure(call: Call<AmazonScrappingResponseModel>, t: Throwable) {

            }

            override fun onResponse(call: Call<AmazonScrappingResponseModel>, response: Response<AmazonScrappingResponseModel>) {
                if (scrapingItemCounter != scrapingItems-1)
                {
                    scrapingItemCounter+=1
                    navigator.onScrapingResponse(response.body()!!)
                }
                else
                {
                    navigator.onScrapingResponse(response.body()!!)
                    navigator.onScrapingFinish()
                }

//
//                navigator.onScrapingResponse(response.body()!!)
//                RecommendationsViewModel.scrapingItemCounter+=1
            }

        })
    }


    fun getModelResponse(userFakeID:Float,userFakeCandidates: Map<String, Float>,userFakeProducts:List<Float>){

//        var userFakeProducts:List<List<Float>>  = mutableListOf(mutableListOf(12.2f,13f),mutableListOf(12f,13f))
//        [[12, 13], [12, 13], [12, 13]]
//        var userFakeCandidates:List<Float>  = mutableListOf(1f,2f)
//        var userFakeID:Float  = 5.2f
//        userCandidates = [1, 2, 3]
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.MODEL_PORT)
        val model:ModelApi = retrofitClient.create(ModelApi::class.java)

        model.getUserResponse(userFakeID,userFakeProducts,userFakeCandidates.values.toList()).enqueue(object : Callback<ModelResponse>{
            override fun onFailure(call: Call<ModelResponse>, t: Throwable) {

            }

            override fun onResponse(call: Call<ModelResponse>, response: Response<ModelResponse>) {
                     print(response.body())
                     navigator.onModelResponse(response.body())

            }

        })
    }



    private fun getUserBehaviour(userFakeID:Float,fakeProducts: Map<String, Float>){
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.USER_PORT)
        val userApi:UserApi = retrofitClient.create(UserApi::class.java)
        userApi.getUserBehaviour(userFakeID,VALUES.ALL_BEAUTY_PATH).enqueue(object :Callback<UserBehaviourResponseModel>{
            override fun onFailure(call: Call<UserBehaviourResponseModel>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<UserBehaviourResponseModel>,
                response: Response<UserBehaviourResponseModel>
            ) {
//                navigator.onBehaviourResponse(response.body()!!.userBehaviourList)
//                print(response.body()!!.userBehaviourList)
                getModelResponse(VALUES.USER_FAKE_ID,fakeProducts,response.body()!!.userBehaviourList)

            }
        })
    }

//    private fun addingQuotationtoItems(prodList:List<String>){
//        for ( )
//    }
    fun getUserFakeProducts(prodList:List<String>){
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.USER_PORT)
        val userApi:UserApi = retrofitClient.create(UserApi::class.java)
//        var prodList:List<String> = listOf(0f,1f,2f,3f)
        userApi.getUserFakeProducts(prodList,VALUES.ALL_BEAUTY_PATH).enqueue(object :Callback<UserFakeProductsResponseModel>{
            override fun onFailure(call: Call<UserFakeProductsResponseModel>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<UserFakeProductsResponseModel>,
                response: Response<UserFakeProductsResponseModel>
            ) {
//                navigator.onFakeProductResponse(response.body()!!.userPrductsList)
                getUserBehaviour(VALUES.USER_FAKE_ID,response.body()!!.userPrductsList)
//                print(response.body()!!.userPrductsList)
            }
        })
    }



    fun getUserRealProducts(prodList:List<String>){
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.USER_PORT)
        val userApi:UserApi = retrofitClient.create(UserApi::class.java)
//        var prodList:List<String> = listOf(0f,1f,2f,3f)
        userApi.getUserRealProducts(prodList,VALUES.ALL_BEAUTY_PATH).enqueue(object :Callback<UserRealProductsResponseModel>{
            override fun onFailure(call: Call<UserRealProductsResponseModel>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<UserRealProductsResponseModel>,
                response: Response<UserRealProductsResponseModel>
            ) {
//                navigator.onFakeProductResponse(response.body()!!.userPrductsList)
//                getUserBehaviour(VALUES.USER_FAKE_ID,response.body()!!.userPrductsList)
                scrapingItems = response.body()!!.userPrductsList.size
                for (i in response.body()!!.userPrductsList)
                    getRecommendationData(i.value)
//                print(response.body()!!.userPrductsList)
            }
        })
    }


}