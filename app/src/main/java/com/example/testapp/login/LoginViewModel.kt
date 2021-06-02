package com.example.testapp.login

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.example.testapp.data.api.APIClient
import com.example.testapp.data.base.BaseViewModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel (application: Application) : BaseViewModel(application){
    var context: Context = application.applicationContext
    val responseCode = MutableLiveData<Int>()

    private val apiService = APIClient.getClient(context)

    fun register(email: String, password: String) {
        apiService?.login(email, password)?.enqueue(object : Callback<ResponseBody> {
                override fun onResponse(
                    call: Call<ResponseBody>,
                    response: Response<ResponseBody>
                ) {
                    if (response.isSuccessful) {
                        responseCode.value = response.code()
                    } else {
                        responseCode.value = response.code()
                    }

                }

                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    t.printStackTrace()
                }

            })
    }
}