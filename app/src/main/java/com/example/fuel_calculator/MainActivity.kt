package com.example.fuel_calculator

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enableEdgeToEdge()

            val button = findViewById<Button>(R.id.vamos_la)

            button.setOnClickListener {
                val intent = Intent(this, DistanciaActivity::class.java)
                startActivity(intent)
        }
    }
}