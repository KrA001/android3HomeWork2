package com.example.android3homework2.data.model

import androidx.annotation.DrawableRes

data class Car(
    @DrawableRes
    val image: Int,
    val name: String,
    val riderNumber: String
)
