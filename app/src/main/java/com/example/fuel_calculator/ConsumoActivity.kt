package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar

const val KEY_DISTANCIA = "ConsumoActivity.KEY_DISTANCIA"

class ConsumoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_consumo)

        val distancia = intent.getFloatExtra(KEY_DISTANCIA, 0f)
        val edtConsumo = findViewById<EditText>(R.id.consumo_veiculo)

        val buttonConsumo = findViewById<Button>(R.id.button_consumo)

        buttonConsumo.setOnClickListener {
            val consumoStr: String = edtConsumo.text.toString()

            if (consumoStr.isEmpty()) {

                Snackbar
                    .make(
                        edtConsumo,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val consumo = consumoStr.toFloat()
                val combustivel = distancia / consumo

                val intent = Intent(this, PrecoActivity::class.java)
                intent.putExtra(KEY_COMBUSTIVEL, combustivel)
                intent.putExtra(KEY_DISTANCIA1, distancia)
                intent.putExtra(KEY_CONSUMO, consumo)
                startActivity(intent)
            }
        }
    }
}