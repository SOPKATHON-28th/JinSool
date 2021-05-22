package com.example.jinsool.api
import response.ResponseData
import retrofit2.Call
import retrofit2.http.GET

interface PenalityService {
    @GET("/api/penalty")
    fun getRequest() : Call<ResponseData>
}