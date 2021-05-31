package com.example.recomendationsystem.Retrofit.CallBacks

import com.example.recomendationsystem.Model.ResponseModel.UserBehaviourResponseModel
import com.example.recomendationsystem.Model.ResponseModel.UserFakeProductsResponseModel
import com.example.recomendationsystem.Model.ResponseModel.UserRealProductsResponseModel
import com.example.recomendationsystem.Model.ResponseModel.userIdResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

@JvmSuppressWildcards
interface UserApi {
    @GET("UserBehaviour/{userID}/{categoryPath}")
    fun getUserBehaviour(
        @Path("userID")
        userFakeID:Float,
        @Path("categoryPath")
        categoryPath:String
    ):Call<UserBehaviourResponseModel>


    @GET("UserID/{userID}/{categoryPath}")
    fun getFakeUserID(
        @Path("userID")
        userRealID:String,
        @Path("categoryPath")
        categoryPath:String
    ):Call<userIdResponseModel>

    @GET("getUserFakeProducts/{productList}/{categoryPath}")
    fun getUserFakeProducts(
        @Path("productList")
        productList:List<String>,
        @Path("categoryPath")
        categoryPath:String
    ):Call<UserFakeProductsResponseModel>


    @GET("getUserRealProducts/{productList}/{categoryPath}")
    fun getUserRealProducts(
        @Path("productList")
        productList:List<String>,
        @Path("categoryPath")
        categoryPath:String
    ):Call<UserRealProductsResponseModel>

}


