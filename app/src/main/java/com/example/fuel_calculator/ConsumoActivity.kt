package com.example.fuel_calculator

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

const val KEY_COMBUSTIVEL = "ConsumoActivity.KEY_COMBUSTIVEL"

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val valorCombustivel = intent.getFloatExtra(KEY_COMBUSTIVEL, 0f)

    }
}