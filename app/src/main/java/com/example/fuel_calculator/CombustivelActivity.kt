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

class CombustivelActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_combustivel)
        enableEdgeToEdge()

        val button2 = findViewById<Button>(R.id.button2)
        val edtCombustivel = findViewById<EditText>(R.id.preco_combustivel)

        button2.setOnClickListener {
            val combustivelStr: String = edtCombustivel.text.toString()

            if (combustivelStr.isEmpty()) {

                Snackbar
                    .make(
                        edtCombustivel,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val combustivel = combustivelStr.toFloat()

                val intent = Intent(this, ConsumoActivity::class.java)
                intent.putExtra(KEY_COMBUSTIVEL, combustivel)
                startActivity(intent)
            }
        }
    }
}