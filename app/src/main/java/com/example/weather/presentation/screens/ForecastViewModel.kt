package com.example.weather.presentation.screens

import com.example.domain.useCases.Forecast
import com.example.domain.useCases.GetForecastUseCase
import com.example.weather.presentation.common.CommonViewModel
import com.example.weather.presentation.common.CoroutineDispatchers
import com.example.weather.presentation.common.onError
import com.example.weather.presentation.common.onSuccess
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ForecastViewModel(
    private val getForecastUseCase: GetForecastUseCase,
    dispatchers: CoroutineDispatchers
) : CommonViewModel(dispatchers) {

    private val _forecastState = MutableStateFlow(ForecastState())
    val forecastState = _forecastState.asStateFlow()

    init {
        ioScope.launch {
            _forecastState.value = _forecastState.value.copy(isLoading = true)
            invokeCall {
                getForecastUseCase.invoke("London", 7)
            }.onSuccess { forecast ->
                _forecastState.value = _forecastState.value.copy(isLoading = false, forecast = forecast)
            }.onError {
                _forecastState.value = _forecastState.value.copy(isLoading = false)
            }
        }
    }
}

data class ForecastState(
    val isLoading: Boolean = true,
    val forecast: Forecast? = null
)