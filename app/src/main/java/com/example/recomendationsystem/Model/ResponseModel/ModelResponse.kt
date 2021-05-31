package com.example.recomendationsystem.Model.ResponseModel

import com.google.gson.annotations.SerializedName

data class ModelResponse(
    @SerializedName("prediction")
    var idList:List<String>)