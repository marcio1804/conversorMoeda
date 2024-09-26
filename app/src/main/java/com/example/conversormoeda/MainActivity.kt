package com.example.conversormoeda

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editTextValor: EditText
    private lateinit var editTextTaxa: EditText
    private lateinit var buttonConvert: Button
    private lateinit var textViewResultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextValor = findViewById(R.id.editTextValor)
        editTextTaxa = findViewById(R.id.editTextTaxa)
        buttonConvert = findViewById(R.id.buttonConvert)
        textViewResultado = findViewById(R.id.textViewResultado)

        buttonConvert.setOnClickListener { converter() }
    }

    private fun converter() {
        val valorString = editTextValor.text.toString().trim()
        val taxaString = editTextTaxa.text.toString().trim()

        when {
            valorString.isEmpty() || taxaString.isEmpty() -> {
                textViewResultado.text = "Por favor, preencha todos os campos."
            }
            else -> {
                val valor = valorString.toDoubleOrNull()
                val taxa = taxaString.toDoubleOrNull()

                if (valor != null && taxa != null) {
                    val valorConvertido = valor * taxa
                    textViewResultado.text = String.format("Valor convertido: %.2f", valorConvertido)
                } else {
                    textViewResultado.text = "Por favor, insira valores válidos."
                }
            }
        }
    }
}
