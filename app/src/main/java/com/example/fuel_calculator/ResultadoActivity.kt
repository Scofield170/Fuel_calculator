package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.fuel_calculator.databinding.ActivityResultadoBinding

const val KEY_RESULTADO = "PrecoActivity.KEY_RESULTADO"
const val KEY_PRECO = "PrecoActivity.KEY_TVPRECO"
const val KEY_DISTANCIA2 = "PrecoActivity.KEY_DISTANCIA"
const val KEY_CONSUMO1 = "PrecoActivity.KEY_CONSUMO"

class ResultadoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultadoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultadoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val resultado = intent.getFloatExtra(KEY_RESULTADO, 0f)
        val formatacaoResultado = String.format("%.2f", resultado)

        binding.textViewResultado.text = formatacaoResultado + "€"

        val preco = intent.getFloatExtra(KEY_PRECO, 0f)

        binding.textViewPreco.text = preco.toString() +  " €"

        val distancia = intent.getFloatExtra(KEY_DISTANCIA2, 0f)

        val formatacaoDistancia = if (distancia == distancia.toInt().toFloat()) {
            String.format("%d", distancia.toInt())
        } else {
            String.format("%.3f", distancia)
        }

        binding.textViewDistancia.text = formatacaoDistancia + " Km"

        val consumo = intent.getFloatExtra(KEY_CONSUMO1, 0f)

        val formatacaoConsumo = if (consumo == consumo.toInt().toFloat()) {
            String.format("%d", consumo.toInt())
        } else {
            String.format("%.2f", consumo)
        }

        binding.textViewConsumo.text = formatacaoConsumo + " Km/l"

        binding.buttonRecomecar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}