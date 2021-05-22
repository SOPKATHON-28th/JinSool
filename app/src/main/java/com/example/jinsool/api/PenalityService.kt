package com.example.jinsool.api

import com.example.jinsool.request.RequestData
import com.example.jinsool.response.ResponseData
import com.example.jinsool.response.ResponsePlayerData
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PenalityService {
    @GET("/api/penalty")
    fun getRequest() : Call<ResponseData>
    @POST("/api/player")
    fun getQuestion(
//        @Query("player") player: Int,
//        @Query("level") level: Int
        @Body body: RequestData
    ) : Call<ResponsePlayerData>
}