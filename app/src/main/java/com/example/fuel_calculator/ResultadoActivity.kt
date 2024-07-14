package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

const val KEY_RESULTADO = "PrecoActivity.KEY_RESULTADO"
const val KEY_PRECO = "PrecoActivity.KEY_TVPRECO"
const val KEY_DISTANCIA2 = "PrecoActivity.KEY_DISTANCIA"
const val KEY_CONSUMO1 = "PrecoActivity.KEY_CONSUMO"

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_resultado)

        val resultado = intent.getFloatExtra(KEY_RESULTADO, 0f)
        val tvResultado = findViewById<TextView>(R.id.textView_resultado)

        tvResultado.text = resultado.toString()

        val preco = intent.getFloatExtra(KEY_PRECO, 0f)
        val tvPreco = findViewById<TextView>(R.id.textView_preco)

        tvPreco.text = preco.toString()

        val distancia = intent.getFloatExtra(KEY_DISTANCIA2, 0f)
        val tvDistancia = findViewById<TextView>(R.id.textView_distancia)

        tvDistancia.text = distancia.toString()

        val consumo = intent.getFloatExtra(KEY_CONSUMO1, 0f)
        val tvConsumo = findViewById<TextView>(R.id.textView_consumo)

        tvConsumo.text = consumo.toString()

        val buttonRecomecar = findViewById<Button>(R.id.button_recomecar)

        buttonRecomecar.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}