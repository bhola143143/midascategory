package com.example.midascategory.retrofit


import com.example.midascategory.model.UserProduct
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    @POST("productdetails?")
    fun userProduct(
        @Query("storeId") storeId: Int = 1,
        @Query("sku") sku: Int = 118499,
    ): Call<UserProduct>



}