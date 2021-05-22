package api

import retrofit2.Call
import retrofit2.http.GET

interface penalityService {
    @GET("/api/penalty")
    fun getRequest() : Call<Int>
}