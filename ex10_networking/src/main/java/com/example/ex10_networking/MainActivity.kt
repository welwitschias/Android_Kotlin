package com.example.ex10_networking

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.bumptech.glide.Glide
import com.example.ex10_networking.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.getReq.setOnClickListener {
            var userListCall = MyApplication.networkService.doGetUserList("1")
            userListCall.enqueue(object : Callback<UserListModel> {
                override fun onResponse(
                    call: Call<UserListModel>,
                    response: Response<UserListModel>
                ) {
                    // 통신이 성공했을 때 호출
                    if (response.isSuccessful) {
                        Log.d("myLog", "get request success .raw: ${response.raw()}")
                        Log.d("myLog", "get request success .body: ${response.body()}")
//                        var userList = response.body()
//                        Log.d("myLog", "userList : $userList")
                    }
                }

                override fun onFailure(call: Call<UserListModel>, t: Throwable) {
                    // 통신이 실패했을 때 호출
                    Log.d("myLog", "get request failure")
                }
            })
        }

        binding.getPath.setOnClickListener {
            var userModel = MyApplication.networkService.test2(1)
            userModel.enqueue(object : Callback<ResponseData> {
                override fun onResponse(
                    call: Call<ResponseData>,
                    response: Response<ResponseData>
                ) {
                    Log.d("myLog", "get path success .raw: ${response.raw()}")
                    Log.d("myLog", "get path success .body: ${response.body()}")
                }

                override fun onFailure(call: Call<ResponseData>, t: Throwable) {
                    Log.d("myLog", "get path failure")
                }
            })
        }

        binding.getQueryMap.setOnClickListener {
            var userModel = MyApplication.networkService.test3(
                mapOf("one" to "android", "two" to "studio"), "name"
            )
            userModel.enqueue(object : Callback<UserModel> {
                override fun onResponse(
                    call: Call<UserModel>,
                    response: Response<UserModel>
                ) {
                    Log.d("myLog", "get queryMap success .raw: ${response.raw()}")
                    Log.d("myLog", "get queryMap success .body: ${response.body()}")
                }

                override fun onFailure(call: Call<UserModel>, t: Throwable) {
                    Log.d("myLog", "get queryMap failure")
                }
            })
        }

        binding.glideTest.setOnClickListener {
            Glide.with(this)
                .load("https://reqres.in/img/faces/1-image.jpg")
                .override(500, 500) // 크기 조절
                .placeholder(R.mipmap.ic_launcher_round) // 이미지 로딩을 시작하기 전에 보여줄 이미지
                .error(R.drawable.todo) // 에러가 발생했을 때 보여줄 이미지
                .into(binding.glideImage)
        }
    }
}

class MyApplication : Application() {
    companion object {
        var retrofit: Retrofit
        var networkService: INetworkService

        init {
            retrofit = Retrofit.Builder()
                .baseUrl("https://reqres.in/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            networkService = retrofit.create(INetworkService::class.java)
        }
    }
}