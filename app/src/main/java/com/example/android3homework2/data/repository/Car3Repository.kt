package com.example.android3homework2.data.repository

import com.example.android3homework2.R
import com.example.android3homework2.data.model.Car

class Car3Repository {

    private val cars = mutableListOf(
        Car(R.drawable.ferrari,"Шторм", "20"),
        Car(R.drawable.bugati,"Маквин","95")
    )

    fun addCar(car: Car){
        cars.add(car)
    }

    fun getCar() = cars

}