package com.example.data.api.di.factory

import com.example.data.api.di.CONNECT_TIMEOUT
import com.example.data.api.di.READ_WRITE_TIMEOUT
import com.example.data.api.interceptors.HeaderInterceptor
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class WeatherRetrofitFactory(
    private val gson: Gson,
    private val loggingInterceptor: HttpLoggingInterceptor,
    private val headerInterceptor: HeaderInterceptor
) {

    fun build(
        baseUrl: String,
        connectTimeout: Long = CONNECT_TIMEOUT,
        readTimeout: Long = READ_WRITE_TIMEOUT
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .client(okHttpClient(connectTimeout, readTimeout))
            .build()
    }

    private fun okHttpClient(connectTimeout: Long, readTimeout: Long): OkHttpClient {
        val builder = OkHttpClient.Builder()
            .connectTimeout(connectTimeout, TimeUnit.SECONDS)
            .readTimeout(readTimeout, TimeUnit.SECONDS)

        builder.addInterceptor(loggingInterceptor)
        builder.addInterceptor(headerInterceptor)
        return builder.build()
    }
}