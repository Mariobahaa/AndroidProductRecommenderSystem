package com.example.recomendationsystem.View.Navigators

import com.example.recomendationsystem.Model.ResponseModel.AmazonScrappingResponseModel
import com.example.recomendationsystem.Model.ResponseModel.ModelResponse
import com.example.recomendationsystem.Model.ResponseModel.UserBehaviourResponseModel

interface RecommendationNavigator {
    fun onModelResponse(response:ModelResponse?)
    fun onScrapingResponse(scrapingResponse: AmazonScrappingResponseModel)
    fun onScrapingFinish()

}