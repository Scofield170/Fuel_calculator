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

const val KEY_COMBUSTIVEL = "PrecoActivity.KEY_PRECO"

class PrecoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_preco)

        val combustuivel = intent.getFloatExtra(KEY_COMBUSTIVEL, 0f)
        val edtPreco = findViewById<EditText>(R.id.preco_combustivel)

        val buttonPreco = findViewById<Button>(R.id.button_preco)

        buttonPreco.setOnClickListener {
            val precoStr: String = edtPreco.text.toString()

            if (precoStr.isEmpty()) {

                Snackbar
                    .make(
                        edtPreco,
                        "Preencha todos os campos",
                        Snackbar.LENGTH_LONG
                    )
                    .show()

            } else {
                val preco = precoStr.toFloat()
                val resultado = combustuivel * preco

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra(KEY_PRECO, resultado)
                startActivity(intent)
            }
        }
    }
}