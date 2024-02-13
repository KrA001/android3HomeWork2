package com.example.android3homework2.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3homework2.data.model.Car
import com.example.android3homework2.data.repository.Car3Repository
import com.example.android3homework2.utils.UiuState

class Car3ViewModel : ViewModel() {

    private val _carsLiveData = MutableLiveData<UiuState<List<Car>>>()
    val carLiveData: LiveData<UiuState<List<Car>>> = _carsLiveData
    private val car3Repository =  Car3Repository()

    init {
        getCars()
    }

    fun getCars() {
        _carsLiveData.value = UiuState(isLoading = false, success =  car3Repository.getCar())

    }

    fun addBleach(car: Car) {
        car3Repository.addCar(car)
    }

}