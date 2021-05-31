package com.example.recomendationsystem.Model.ResponseModel

import com.google.gson.annotations.SerializedName

data class UserRealProductsResponseModel(
    @SerializedName("userPrducts")
    var userPrductsList:Map<Float,String>) {
}