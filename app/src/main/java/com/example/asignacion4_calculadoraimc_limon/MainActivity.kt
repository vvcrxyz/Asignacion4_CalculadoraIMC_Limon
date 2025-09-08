package com.example.asignacion4_calculadoraimc_limon

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class Asignacion4_CalculadoraIMC_Limon : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // esto es para vincular el layout con la activity
        setContentView(R.layout.activity_main)

        // declaracion de variavbles que usamos en la interdaz
        val weight: EditText = findViewById(R.id.weight) as EditText   // campo de texto para capturar el peso
        val height: EditText = findViewById(R.id.height) as EditText   // campo de texto para capturar la altura
        val btnCalcular: Button = findViewById(R.id.btnCalcular) as Button // boton que hará el cálculo
        val imc: TextView = findViewById(R.id.imc) as TextView         // textView donde se mostrará el IMC
        val range: TextView = findViewById(R.id.range) as TextView     // textView donde se mostrará la categoría

        // Esto es lo que se ejecuta una vez el usuario de click al boton Calcular
        btnCalcular.setOnClickListener {
            // Convertimos los valores ingresados en numeros decimales
            val peso = weight.text.toString().toDoubleOrNull()
            val estatura = height.text.toString().toDoubleOrNull()

            // Aqui validamos que los datos no esten nulls y que la estatura sea mayor a 0
            if (peso != null && estatura != null && estatura > 0) {

                // Formula del IMC = peso / (altura * altura)
                val resultado = peso / (estatura * estatura)

                // Aqui se mostrara el IMC que salio con dos decimales
                imc.text = "IMC: %.2f".format(resultado)

                // Aqui determinaremos el rango segun el IMC que salio
                when {
                    resultado < 18.5 -> {
                        range.text = "Bajo peso"
                        range.setBackgroundResource(R.color.colorBlueish)
                    }
                    resultado in 18.5..24.9 -> {
                        range.text = "Normal"
                        range.setBackgroundResource(R.color.colorGreenish)
                    }
                    resultado in 25.0..29.9 -> {
                        range.text = "Sobrepeso"
                        range.setBackgroundResource(R.color.colorYellowish)
                    }
                    resultado in 30.0..34.9 -> {
                        range.text = "Obesidad grado 1"
                        range.setBackgroundResource(R.color.colorOrange)
                    }
                    resultado in 35.0..39.9 -> {
                        range.text = "Obesidad grado 2"
                        range.setBackgroundResource(R.color.colorRed)
                    }
                    else -> {
                        range.text = "Obesidad grado 3"
                        range.setBackgroundResource(R.color.colorDarkRed)
                    }
                }
            } else {
                // Si el usuario no mete datos, arrojara un texto con datos invalidos
                imc.text = "Datos inválidos"
                range.text = ""
            }
        }
    }
}
