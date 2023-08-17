package com.app.myapplication5.utilities.retrofit

import com.app.myapplication5.DataPOJO
import com.app.myapplication5.utilities.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
/*
    companion object{
        operator fun invoke() : RetrofitService {

            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
            return Retrofit.Builder()
                .baseUrl(Constants.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
                .create(RetrofitService::class.java)
        }
    }*/
/*    @GET("/api/users")
    fun getUsers(
        @Query("per_page")size : Int
    ) : Call<DataPOJO>*/


    @GET("/api/users")
    suspend fun getUsers(
        @Query("per_page")size : Int
    ) : List<DataPOJO>


    @GET("/api/users")
    suspend fun getUsers1(
        @Query("per_page")size : Int
    ) : DataPOJO

}