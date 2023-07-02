package com.example.weather.presentation.common

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.withContext

open class CommonViewModel(
    dispatchers: CoroutineDispatchers,
    private val errorReporter: ThrowableReporter = defaultReporter
) : ViewModel() {

    private val errorHandler = CoroutineExceptionHandler { _, throwable ->
        handleException(throwable)
    }

    private val job = SupervisorJob()

    protected val ioScope = CoroutineScope(
        dispatchers.io() + job + errorHandler
    )
    protected val uiScope = CoroutineScope(
        dispatchers.main() + job + errorHandler
    )

    private fun handleException(throwable: Throwable) {
        errorReporter.invoke(throwable)
    }

    @CallSuper
    override fun onCleared() {
        ioScope.cancel()
        uiScope.cancel()
    }

    suspend fun <T> invokeCall(call: suspend () -> T): Either<Throwable, T> {
        return withContext(ioScope.coroutineContext) {
            try {
                Either.Right(call.invoke())
            } catch (throwable: Throwable) {
                handleException(throwable)
                Either.Left(throwable)
            }
        }
    }
}

typealias ThrowableReporter = (throwable: Throwable) -> Unit

val defaultReporter: ThrowableReporter = { throwable ->
    //TODO: report to crashlytics as non-fatal
    Log.e("exception", "Default coroutine exception handler", throwable)
}
