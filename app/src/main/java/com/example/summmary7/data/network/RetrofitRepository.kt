package com.example.summmary7.data.network

import com.example.summmary7.data.network.models.ResultModel
import retrofit2.Response
import retrofit2.http.GET

interface RetrofitRepository {

    @GET("48bb936e-261a-4471-a362-3bbb3b9a2a58")
    suspend fun getData(): Response<ResultModel>
}