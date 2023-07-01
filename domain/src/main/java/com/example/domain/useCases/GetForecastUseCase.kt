package com.example.domain.useCases

fun interface GetForecastUseCase {
    suspend fun invoke(): String
}