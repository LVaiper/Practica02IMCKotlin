package com.example.practica02imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    // Creación de variables
    private lateinit var lblAltura: TextView
    private lateinit var txtAltura: EditText
    private lateinit var lblPeso: TextView
    private lateinit var txtPeso: EditText
    private lateinit var lblResultado: TextView
    private lateinit var btnCalcular: Button
    private lateinit var btnLimpiar: Button
    private lateinit var btnCerrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Relacionando los componentes
        lblAltura = findViewById(R.id.lblAltura);
        txtAltura = findViewById(R.id.txtAltura);
        lblPeso = findViewById(R.id.lblPeso);
        txtPeso = findViewById(R.id.txtPeso);
        lblResultado = findViewById(R.id.lblResultado);
        btnCalcular = findViewById(R.id.btnCalcular);
        btnLimpiar = findViewById(R.id.btnLimpiar);
        btnCerrar = findViewById(R.id.btnCerrar);

        // Evento Click del botón Calcular
        btnCalcular.setOnClickListener {
            // Validar
            if (txtAltura.text.toString().isEmpty() || txtPeso.text.toString().isEmpty()) {
                Toast.makeText(this@MainActivity, "Falta Capturar Información", Toast.LENGTH_SHORT)
                    .show()
            } else {
                var altura = txtAltura.text.toString().toDouble()
                val peso = txtPeso.text.toString().toDouble()
                altura /= 100
                val resultado = peso / (altura * altura)
                val str = "Su IMC es: %.2f".format(resultado)
                lblResultado.text = str
            }
        }

        // Evento Click del botón Limpiar
        btnLimpiar.setOnClickListener {
            txtPeso.text.clear()
            txtAltura.text.clear()
            lblResultado.text = ""
        }

        // Evento Click del botón Cerrar
        btnCerrar.setOnClickListener {
            finish()
        }
    }
}