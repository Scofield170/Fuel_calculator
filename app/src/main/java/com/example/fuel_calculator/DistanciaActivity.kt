package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fuel_calculator.databinding.ActivityDistanciaBinding
import com.google.android.material.snackbar.Snackbar

class DistanciaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDistanciaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDistanciaBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        binding.buttonDistancia.setOnClickListener {
            val distanciaStr: String = binding.distancia.text.toString()

            if (distanciaStr.isEmpty()) {

                Snackbar
                    .make(
                        binding.distancia,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val distancia = distanciaStr.toFloat()

                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra(KEY_DISTANCIA, distancia)
                startActivity(intent)
            }
        }
    }
}