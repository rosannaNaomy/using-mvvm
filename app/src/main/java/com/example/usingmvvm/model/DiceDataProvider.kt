package com.example.usingmvvm.model


import usingmvvm.R

class DiceDataProvider {

    private val dices = arrayListOf<Dice>()

    init {
        dices.add(Dice("Dice One", R.drawable.dice_1, 1))
        dices.add(Dice("Dice Two", R.drawable.dice_2, 2))
        dices.add(Dice("Dice Three", R.drawable.dice_3, 3))
        dices.add(Dice("Dice Four", R.drawable.dice_4, 4))
        dices.add(Dice("Dice Five", R.drawable.dice_5, 5))
        dices.add(Dice("Dice Six", R.drawable.dice_6, 6))
    }

    fun getDices() = dices
}