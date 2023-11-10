package com.example.training.core.network.retrofit

import com.example.training.core.model.User
import retrofit2.http.GET

interface ApiService {

    @GET(value = "users")
    suspend fun getUsers(
    ): List<User>

}