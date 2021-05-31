package com.example.recomendationsystem.View.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.recomendationsystem.R
import com.example.recomendationsystem.Values.VALUES
import com.example.recomendationsystem.View.Navigators.CollaborativeNavigator
import com.example.recomendationsystem.databinding.ActivityMainBinding
import com.example.recomendationsystem.viewmodels.LoginViewModel
import java.io.Serializable

class MainLoginActivity : AppCompatActivity()  {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )
        viewModel = LoginViewModel()



//        VALUES.USER_REAL_ID = "AEY5YWIVK33SE"
        VALUES.USER_REAL_ID = "ASFHTW5SP4QQR"



        //AEY5YWIVK33SE
        //A24HQ2N7332W7W

        viewModel.getUserFakeID(VALUES.USER_REAL_ID)

        binding.login.setOnClickListener {
            val intent = Intent(this, CategoriesActivitiy::class.java)
            startActivity(intent)
        }

    }

}