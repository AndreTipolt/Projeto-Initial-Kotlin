package com.example.projeto1

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class IMCActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalcularIMC: Button = findViewById(R.id.btnCalcularIMC);

        btnCalcularIMC.setOnClickListener {

            calcularIMC();
        }
    }

    fun calcularIMC() {

        val txtResultado: TextView = findViewById(R.id.txtResultadoIMC);

        val txtAltura = findViewById<TextInputEditText>(R.id.txtAltura);
        val txtPeso = findViewById<TextInputEditText>(R.id.txtPeso);

        val altura = txtAltura.text?.toString()?.toFloatOrNull();
        val peso = txtPeso.text?.toString()?.toFloatOrNull();

        if(altura == null || peso == null) {

            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(altura == 0F || peso == 0F) {
            Toast.makeText(this, "Campos não podem ser 0", Toast.LENGTH_SHORT).show();
            return;
        }

        val valorIMC: Float = peso / (altura * altura);

        when (valorIMC) {
            in 0.0..18.4 -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_blue_dark))
                txtResultado.text = "Você está abaixo do peso"
            }
            in 18.5..24.9 -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
                txtResultado.text = "Você está com um IMC normal"
            }
            in 25.0..29.9 -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_orange_dark))
                txtResultado.text = "Você está com sobrepeso"
            }
            in 30.0..34.9 -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_light))
                txtResultado.text = "Obesidade Grau I"
            }
            in 35.0..39.9 -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
                txtResultado.text = "Obesidade Grau II (severa)"
            }
            else -> {
                txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.black))
                txtResultado.text = "Obesidade Grau III (mórbida)"
            }
        }
    }
}