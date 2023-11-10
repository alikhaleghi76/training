package com.example.training.feature.users.presentaion.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.training.core.model.User
import com.example.training.core.network.retrofit.RetrofitTrainingNetwork
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val networkTrainingNetwork: RetrofitTrainingNetwork) : ViewModel() {
    val users = MutableStateFlow<ApiState<List<User>>>(ApiState.Loading)

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = networkTrainingNetwork.getUsers()
                users.value = ApiState.Success(response)
            } catch (e: Exception) {
                users.value = ApiState.Error("Failed to fetch data")
            }
        }
    }
}

sealed class ApiState<out T> {
    object Loading : ApiState<Nothing>()
    data class Success<T>(val data: T) : ApiState<T>()
    data class Error(val message: String) : ApiState<Nothing>()
}