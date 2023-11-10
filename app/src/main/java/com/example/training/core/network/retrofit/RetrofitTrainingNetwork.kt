package com.example.training.core.network.retrofit

import com.example.training.core.model.User
import com.example.training.core.network.UserDataSource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RetrofitTrainingNetwork @Inject constructor(private val apiService: ApiService) : UserDataSource {
    override suspend fun getUsers(): List<User> {
        return apiService.getUsers()
    }
}