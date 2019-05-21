package com.wtm.kotlin.development.network

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

// https://wtm-singapore.free.beeceptor.com/user
class MainActivity : AppCompatActivity() {

    private val api by lazy {
        Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://wtm-singapore.free.beeceptor.com")
                .build()
                .create(Api::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            api.getUser()
                    .enqueue(object: Callback<User?> {
                        override fun onFailure(call: Call<User?>, t: Throwable) {
                            Log.e("ERROR", "network error", t)
                        }

                        override fun onResponse(call: Call<User?>, response: Response<User?>) {
                            response.body()?.let { user ->
                                name.text = user.name
                                age.text = user.age.toString()
                            }
                        }
                    })
        }


    }
}


interface Api {
    @GET("user")
    fun getUser(): Call<User>
}

data class User(val name: String, val age: Int)