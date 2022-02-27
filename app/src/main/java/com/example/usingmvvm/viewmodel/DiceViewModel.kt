package com.example.usingmvvm.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.usingmvvm.model.Dice
import com.example.usingmvvm.model.DiceDataProvider


class DiceViewModel: ViewModel() {

    private val diceData = MutableLiveData<Dice>()
    private val dices = DiceDataProvider().getDices()
    private var currentIndex = 0
    private val delay = 2000L

    init {
        loop()
    }

    fun getDiceData(): LiveData<Dice> = diceData

    private fun loop(){
        Handler(Looper.getMainLooper()).postDelayed({updateDice()}, delay)
    }

    private fun updateDice(){
        currentIndex++
        currentIndex %= dices.size

        diceData.value = dices[currentIndex]

        loop()
    }
}