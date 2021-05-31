package com.example.recomendationsystem.Retrofit.CallBacks

import com.example.recomendationsystem.Model.ResponseModel.AmazonScrappingResponseModel
import com.example.recomendationsystem.Model.ResponseModel.CollaborativeResponseModel
import retrofit2.Call
import retrofit2.http.*

interface CollaborativeFilteringApi {
   @GET("Collaborative/{UserId}/{categoryPath}")
   fun getUserResponse(
      @Path("UserId")
      userRealID:String,
      @Path("categoryPath")
      categoryPath:String):Call<HashMap<String,String>>
}