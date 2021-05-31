package com.example.recomendationsystem.Model.ResponseModel

import com.google.gson.annotations.SerializedName

data class UserBehaviourResponseModel(
    @SerializedName("userBehaviour")
    var userBehaviourList:List<Float>) {}