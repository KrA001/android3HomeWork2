package com.example.android3homework2.utils

data class UiuState<T>(
    val isLoading: Boolean = true,
    val error: String? = null,
    val success: T? = null
)