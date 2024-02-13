package com.example.android3homework2.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android3homework2.data.model.Car
import com.example.android3homework2.databinding.ItemCarBinding

class CarAdapter : RecyclerView.Adapter<CarAdapter.CarViewHolder>() {

    private var carList = mutableListOf<Car>()
    fun setCar(carList: MutableList<Car>) {
        this.carList = carList
        notifyDataSetChanged()
    }

    inner class CarViewHolder(private val binding: ItemCarBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(car: Car) = with(binding) {
            ivCarThree.setImageResource(car.image)
            tvName.text = car.name
            tvNumber.text = car.riderNumber
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarAdapter.CarViewHolder {
        val binding = ItemCarBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CarViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CarAdapter.CarViewHolder, position: Int) {
        holder.onBind(carList[position])
    }

    override fun getItemCount(): Int = carList.size
}