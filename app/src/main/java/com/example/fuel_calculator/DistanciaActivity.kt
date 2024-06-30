package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class DistanciaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_distancia)
        enableEdgeToEdge()

        val buttonDistancia = findViewById<Button>(R.id.button_distancia)
        val edtDistancia = findViewById<EditText>(R.id.distancia)

        buttonDistancia.setOnClickListener {
            val distanciaStr: String = edtDistancia.text.toString()

            if (distanciaStr.isEmpty()) {

                Snackbar
                    .make(
                        edtDistancia,
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