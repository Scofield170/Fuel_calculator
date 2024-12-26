package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.fuel_calculator.databinding.ActivityPrecoBinding
import com.google.android.material.snackbar.Snackbar

const val KEY_COMBUSTIVEL = "ConsumoActivity.KEY_COMBUSTIVEL"
const val KEY_DISTANCIA1 = "ConsumoActivity.KEY_DISTANCIA"
const val KEY_CONSUMO = "ConsumoActivity.KEY_CONSUMO"

class PrecoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPrecoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPrecoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        enableEdgeToEdge()

        val combustuivel = intent.getFloatExtra(KEY_COMBUSTIVEL, 0f)
        val distancia = intent.getFloatExtra(KEY_DISTANCIA1, 0f)
        val consumo = intent.getFloatExtra(KEY_CONSUMO, 0f)

        binding.buttonPreco.setOnClickListener {
            val precoStr: String = binding.precoCombustivel.text.toString()

            if (precoStr.isEmpty()) {

                Snackbar
                    .make(
                        binding.precoCombustivel,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val preco = precoStr.toFloat()
                val resultado = combustuivel * preco

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra(KEY_RESULTADO, resultado)
                intent.putExtra(KEY_PRECO, preco)
                intent.putExtra(KEY_DISTANCIA2, distancia)
                intent.putExtra(KEY_CONSUMO1, consumo)
                startActivity(intent)
            }
        }
    }
}