package api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PenalityCreater {

    private const val BASE_URL ="13.59.52.111"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val penalityService : penalityService = retrofit.create(api.penalityService::class.java)
}