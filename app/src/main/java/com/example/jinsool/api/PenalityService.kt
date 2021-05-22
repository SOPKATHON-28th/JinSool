package com.example.jinsool.api
import retrofit2.Call
import retrofit2.http.GET

interface PenalityService {
    @GET("/api/penalty")
    fun getRequest() : Call<Int>
}