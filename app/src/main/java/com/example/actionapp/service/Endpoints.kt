package com.example.actionapp.service
import com.example.actionapp.module.Action
import retrofit2.Call
import retrofit2.http.GET

interface Endpoints {

    // If I were to implement http request it would look somewhat like this -


    @GET("......")
    fun retrieveActions(): Call<Action>
}