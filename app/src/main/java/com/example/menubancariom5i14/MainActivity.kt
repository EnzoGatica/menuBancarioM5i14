package com.example.menubancariom5i14

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.menubancariom5i14.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var saldo = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{v ->
            when (binding.radioGroup.checkedRadioButtonId){
                R.id.radioVerSaldo ->
                    binding.editTextDos.setText("Saldo: " + saldo.toString())
                R.id.radioIngresar ->
                    ingresarSaldo()
                R.id.radioRetirar ->
                    retirarSaldo()
                R.id.radioSalir ->
                    salir()
            }
        }

    }

    fun ingresarSaldo(){
        saldo += binding.editTextUno.text.toString().toInt()
        binding.editTextDos.setText("Saldo: " + saldo.toString())
        Toast.makeText(applicationContext,"Su saldo ha sido ingresado correctamente", Toast.LENGTH_LONG).show()
    }

    fun retirarSaldo(){
        val monto = binding.editTextUno.text.toString().toInt()
        if(monto <= saldo){
            saldo -= monto
            binding.editTextUno.text.clear()
            Toast.makeText(applicationContext,"Su saldo ha sido retirado correctamente", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(applicationContext,"no tiene saldo suficiente", Toast.LENGTH_LONG).show()
        }
    }


    private fun salir() {
        System.exit(0)
    }
}