package com.example.jinsool.api

import com.example.jinsool.response.ResponsePlayerData
import retrofit2.Call
import retrofit2.http.GET

interface penalityService {
    @GET("/api/penalty")
    fun getRequest() : Call<Int>
    @GET("/api/player")
    fun getQuestion() : Call<ResponsePlayerData>
}