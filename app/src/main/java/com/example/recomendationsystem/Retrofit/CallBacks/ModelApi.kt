package com.example.recomendationsystem.Retrofit.CallBacks

import com.example.recomendationsystem.Model.ResponseModel.ModelResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

@JvmSuppressWildcards
interface ModelApi {
    @GET("Model/{userID}/{userProducts}/{userCandidates}")
    fun getUserResponse(
        @Path("userID")
        userFakeID:Float,
        @Path("userProducts")
        userProducts:List<Float>,
        @Path("userCandidates")
        userCandidates: List<Float>): Call<ModelResponse>
}