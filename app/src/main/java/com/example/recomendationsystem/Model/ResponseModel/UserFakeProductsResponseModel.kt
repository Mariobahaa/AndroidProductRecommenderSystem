package com.example.recomendationsystem.Model.ResponseModel

import com.google.gson.annotations.SerializedName

data class UserFakeProductsResponseModel(
    @SerializedName("userPrducts")
    var userPrductsList:Map<String,Float>) {
}