package com.example.weather.presentation.common

sealed class Either<out L, out R> {

    /** * Represents the left side of [Either] class which by convention is a "Failure". */
    data class Left<out L>(val a: L) : Either<L, Nothing>()

    /** * Represents the right side of [Either] class which by convention is a "Success". */
    data class Right<out R>(val b: R) : Either<Nothing, R>()

    val isRight get() = this is Right<R>
    val isLeft get() = this is Left<L>

    fun left(): L {
        return (this as Left<L>).a
    }

    fun right(): R {
        return (this as Right<R>).b
    }
}

fun <L, R> Either<L, R>.getOrElse(value: R): R =
    when (this) {
        is Either.Left -> value
        is Either.Right -> b
    }


inline fun <T : Any, E : Any> Either<T, E>.onSuccess(action: (E) -> Unit): Either<T, E> {
    if (this is Either.Right) action(this.right())
    return this
}

inline fun <T : Any, E : Any> Either<T, E>.onError(action: (T) -> Unit): Either<T, E> {
    if (this is Either.Left) action(this.left())
    return this
}