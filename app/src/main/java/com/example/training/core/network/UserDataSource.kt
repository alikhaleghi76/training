package com.example.training.core.network

import com.example.training.core.model.User

interface UserDataSource {
    suspend fun getUsers(): List<User>
}