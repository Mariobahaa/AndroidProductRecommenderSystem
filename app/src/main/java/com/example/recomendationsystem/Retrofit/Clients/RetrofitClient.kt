package com.example.recomendationsystem.Retrofit.Clients

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class RetrofitClient {
//    private var amazonScrappingCallBack:AmazonScrappingCallBack

    companion object{
        private val BASE_URL:String = "http://192.168.1.4:"
//        private var INSTANCE: AmazonScrapingClient = AmazonScrapingClient()
        fun getINSTANCE(portNumber:Int):Retrofit{
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .build()
            val retrofit:Retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL+portNumber.toString()+"/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
            return retrofit
        }
    }


}