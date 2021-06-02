package com.example.testapp.user

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.testapp.data.api.APIClient
import com.example.testapp.data.base.BaseResponse
import com.example.testapp.data.base.BaseViewModel
import com.example.testapp.data.model.UserData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel(application: Application) : BaseViewModel(application){
    var context: Context = application.applicationContext
    val listUser = MutableLiveData<List<UserData>>()

    private val apiService = APIClient.getClient(context)

    fun getUser() {
        apiService?.getUser()?.enqueue(object : Callback<BaseResponse<List<UserData>>> {
            override fun onResponse(
                call: Call<BaseResponse<List<UserData>>>,
                response: Response<BaseResponse<List<UserData>>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    listUser.value = response.body().data
                }
            }

            override fun onFailure(call: Call<BaseResponse<List<UserData>>>, t: Throwable) {
            }
        })
    }
}