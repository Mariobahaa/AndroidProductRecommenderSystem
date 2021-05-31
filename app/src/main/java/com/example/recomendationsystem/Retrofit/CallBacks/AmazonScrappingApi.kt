package com.example.recomendationsystem.Retrofit.CallBacks

import com.example.recomendationsystem.Model.ResponseModel.AmazonScrappingResponseModel
import retrofit2.Call
import retrofit2.http.*

interface AmazonScrappingApi {
   @GET("AmazonScrapping/{id}")
   fun getScrapingResponse(
      @Path("id")
      producutID:String):Call<AmazonScrappingResponseModel>
}