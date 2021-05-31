package com.example.recomendationsystem.viewmodels

import com.example.recomendationsystem.Retrofit.CallBacks.CollaborativeFilteringApi
import com.example.recomendationsystem.Retrofit.Clients.RetrofitClient
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Navigators.CollaborativeNavigator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

class CategoriesViewmodel(var navigator: CollaborativeNavigator){
    fun getUserProductsScores(userID:String,categoryPath:String){
        var retrofit: Retrofit = RetrofitClient.getINSTANCE(VALUES.COLLABORATIVE_PORT)
        var collaborativeFilteringApi: CollaborativeFilteringApi = retrofit.create(
            CollaborativeFilteringApi::class.java)
        collaborativeFilteringApi.getUserResponse(userID,categoryPath).enqueue(object :
            Callback<HashMap<String, String>> {
            override fun onFailure(call: Call<HashMap<String, String>>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<HashMap<String, String>>,
                response: Response<HashMap<String, String>>
            ) {

                var body = response.body()

                navigator.collaborativeResponse(body)
            }
        })
    }
}