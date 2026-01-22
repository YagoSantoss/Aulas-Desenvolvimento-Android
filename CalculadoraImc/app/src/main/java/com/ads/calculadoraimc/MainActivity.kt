package com.ads.calculadoraimc

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val campoPeso: EditText = findViewById(R.id.editTextPeso)
        val campoAltura: EditText = findViewById(R.id.editTextAltura)
        val botaoParaImc: Button = findViewById(R.id.buttonCalcular)

        val textoResultado: TextView = findViewById(R.id.editTextResultado)

        botaoParaImc.setOnClickListener{
            val altura = campoAltura.text.toString()
            val peso = campoPeso.text.toString()
            if(peso.isNotEmpty()  && altura.isNotEmpty()){
                val alturaM = altura.toDouble()
                val pesoKg = peso.toDouble()

                val valorImc = pesoKg / (alturaM * alturaM)

                val resultado = when {
                    valorImc < 18.5 -> "Baixo Peso"
                    valorImc in 18.5 .. 24.9 -> "Peso Normal"
                    valorImc in 25.0 .. 29.9 -> "SobrePeso"
                    valorImc in 30.0 .. 34.9 -> "Obesidade Grau I"
                    valorImc in 35.0 .. 39.9 -> "Obesidade Grau II"
                    else -> "Obesidade Grau III"
                }

                textoResultado.text = "Seu IMC é: ${"%.2f".format(valorImc)} - $resultado"

            }
        }

    }
}