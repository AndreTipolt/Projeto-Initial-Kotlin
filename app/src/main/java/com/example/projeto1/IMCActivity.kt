package com.example.projeto1

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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
    }
}