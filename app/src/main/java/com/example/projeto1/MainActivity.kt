package com.example.projeto1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnNomes: Button = findViewById(R.id.btnNomes)
        val btnIMC: Button = findViewById(R.id.btnIMC)
        val btnMedia: Button = findViewById(R.id.btnMedia)

        btnNomes.setOnClickListener {
            abrirTela("NomesActivity")
        }
        btnIMC.setOnClickListener {
            abrirTela("IMCActivity")
        }
        btnMedia.setOnClickListener {
            abrirTela("MediaActivity")
        }
    }

    private fun abrirTela(nomeTela: String) {
        val activityClass = when (nomeTela) {
            "NomesActivity" -> NomesActivity::class.java
            "IMCActivity" -> IMCActivity::class.java
            "MediaActivity" -> MediaActivity::class.java
            else -> return
        }

        val intent = Intent(this, activityClass)
        startActivity(intent)
    }
}
