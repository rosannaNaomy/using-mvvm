package com.example.usingmvvm.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import usingmvvm.databinding.ActivityMainBinding
import com.example.usingmvvm.viewmodel.DiceViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: DiceViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        model.getDiceData().observe(this, Observer { dice -> binding.diceImageView.setImageDrawable(
            ResourcesCompat.getDrawable(resources, dice.img, applicationContext.theme)
        )
        binding.nameTextview.text = dice.name
        binding.numberTextView.text = dice.number.toString()
        })
    }
}