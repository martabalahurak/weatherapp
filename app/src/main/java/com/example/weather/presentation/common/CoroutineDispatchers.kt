package com.example.weather.presentation.common

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

interface CoroutineDispatchers {
    fun io(): CoroutineDispatcher
    fun main(): CoroutineDispatcher
}

class CoroutineDispatchersImpl : CoroutineDispatchers {

    override fun io() = Dispatchers.IO

    override fun main() = Dispatchers.Main
}
