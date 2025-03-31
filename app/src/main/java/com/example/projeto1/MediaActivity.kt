package com.example.projeto1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MediaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_media)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnCalcular: Button = findViewById(R.id.btnCalcular)

        val btnHome: Button = findViewById(R.id.btnHome);

        btnCalcular.setOnClickListener {
            calcularMedia()
        };

        btnHome.setOnClickListener {
            voltarHome()
        }


    }

    fun calcularMedia() {

        val txtResultado: TextView = findViewById(R.id.txtResultado);

        txtResultado.text = null;

        val txtNota1 = findViewById<TextInputEditText>(R.id.txtNota1);
        val txtNota2  = findViewById<TextInputEditText>(R.id.txtNota2);
        val txtNota3 = findViewById<TextInputEditText>(R.id.txtNota3);

        val nota1 = txtNota1.text?.toString()?.toFloatOrNull()
        val nota2 = txtNota2.text?.toString()?.toFloatOrNull()
        val nota3 = txtNota3.text?.toString()?.toFloatOrNull()

        if(nota1 == null || nota2 == null || nota3 == null) {

            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
            return;
        }

        if(nota1 > 10 || nota1 < 0) {
            Toast.makeText(this, "Nota 1 Inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if(nota2 > 10 || nota2 < 0) {
            Toast.makeText(this, "Nota 2 Inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        if(nota3 > 10 || nota3 < 0) {
            Toast.makeText(this, "Nota 3 Inválida", Toast.LENGTH_SHORT).show();
            return;
        }

        val list = listOf(nota1, nota2, nota3);

        val resultado: Float = list.sum() / list.size;

        if(resultado >= 6){

            txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_green_dark))
            txtResultado.text = "Você está Aprovado. Parabéns!"
        }
         else{
            txtResultado.setTextColor(ContextCompat.getColor(this, android.R.color.holo_red_dark))
             txtResultado.text = "Você está reprovado."
        }
    }

    fun voltarHome() {

        val intent = Intent(this, MainActivity::class.java);

        startActivity(intent);
    }
}