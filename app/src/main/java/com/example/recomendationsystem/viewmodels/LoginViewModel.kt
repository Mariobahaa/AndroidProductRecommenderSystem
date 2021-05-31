package com.example.recomendationsystem.viewmodels

import com.example.recomendationsystem.Model.ResponseModel.CollaborativeResponseModel
import com.example.recomendationsystem.Model.ResponseModel.userIdResponseModel
import com.example.recomendationsystem.Retrofit.CallBacks.CollaborativeFilteringApi
import com.example.recomendationsystem.Retrofit.CallBacks.UserApi
import com.example.recomendationsystem.Retrofit.Clients.RetrofitClient
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Navigators.CollaborativeNavigator
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.nio.channels.NonReadableChannelException

class LoginViewModel() {


    fun getUserFakeID(userID:String){
        val retrofitClient: Retrofit = RetrofitClient.getINSTANCE(VALUES.USER_PORT)
        val userApi: UserApi = retrofitClient.create(UserApi::class.java)
        userApi.getFakeUserID(userID,VALUES.ALL_BEAUTY_PATH).enqueue(object :Callback<userIdResponseModel>{
            override fun onFailure(call: Call<userIdResponseModel>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<userIdResponseModel>,
                response: Response<userIdResponseModel>
            ) {
                VALUES.USER_FAKE_ID = response.body()!!.userFakID
                print(response)
            }
        })
    }

}