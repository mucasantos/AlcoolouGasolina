package com.example.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcValor(view: View){
        val precoAlcool = findViewById<EditText>(R.id.editPrecoAlcool)
        val precoGasolina = findViewById<EditText>(R.id.editPrecoGasolina)
        val textResultado = findViewById<TextView>(R.id.textResultado)

        val validaCampos = validarCampos(precoAlcool.text.toString(), precoGasolina.text.toString())

        if (validaCampos){

            calcularMelhorPreco(precoAlcool.text.toString(), precoGasolina.text.toString())
        }else {
            textResultado.text = "Por favor digite um valor"

        }

    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        val valAlcool = precoAlcool.toDouble()
        val valGasolina = precoGasolina.toDouble()
        val textResultado = findViewById<TextView>(R.id.textResultado)


        val resultadoPreco = valAlcool / valGasolina

        if(resultadoPreco >= 0.7){

            textResultado.text = "Melhor usar gasolina"

        }else {
            textResultado.text = "Melhor usar alcool"

        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String) : Boolean{

        var camposValidados: Boolean = true;

        if( precoAlcool == null || precoAlcool ==""){
            camposValidados = false
        }else  if( precoGasolina == null || precoGasolina ==""){
            camposValidados = false
        }

        return camposValidados
    }
}