package com.example.actionapp.service

import com.example.actionapp.module.Action
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    // If I were to implement http request it would look somewhat like this -


    private val service: Endpoints

    companion object {
        private const val BASE_URL = "https:/........."
    }

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        service = retrofit.create(Endpoints::class.java)
    }

    fun getActions(callback: Callback<Action>) {
        service.retrieveActions().enqueue(callback)
    }

}