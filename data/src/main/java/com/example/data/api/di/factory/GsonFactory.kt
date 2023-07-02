package com.example.data.api.di.factory

import com.google.gson.Gson
import com.google.gson.GsonBuilder

object GsonFactory {

    fun buildGson(): Gson {
        return GsonBuilder().setLenient().create()
    }
}