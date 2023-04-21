package com.example.midascategory.repositotry

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.midascategory.model.UserProduct
import com.example.midascategory.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

object MainActivityRepository {

    val serviceSetterGetter = MutableLiveData<UserProduct>()

    fun userProduct( ): MutableLiveData<UserProduct> {


        val call = RetrofitClient.apiInterface.userProduct(
            storeId = 1,
            sku = 118499
        )

        call.enqueue(object : Callback<UserProduct> {
            override fun onFailure(call: Call<UserProduct>, t: Throwable) {

                Log.v("DEBUG : ", t.toString())

            }

            override fun onResponse(
                call: Call<UserProduct>,
                response: Response<UserProduct>
            ) {

                println("@@@ DEBUG : " + response.body().toString())

                val data = response.body()
                val responseData = data?.response_data
                val responseSettings = data?.settings



                serviceSetterGetter.value = UserProduct(responseData,responseSettings)


            }
        })




        return serviceSetterGetter
    }
}