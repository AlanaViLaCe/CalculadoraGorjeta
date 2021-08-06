package com.example.deneros

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.deneros.databinding.ActivityMainBinding
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calcular.setOnClickListener{ calculateTip() }
    }

    fun calculateTip() {
        val stringInTextField = binding.custoService.text.toString()
        val cost = stringInTextField.toDouble()
        val selectedId = binding.opcoes.checkedRadioButtonId
        val tipPercentage = when (selectedId) {
            R.id.vintepct -> 0.20
            R.id.dezoitopct -> 0.18
            else -> 0.15
        }
                var tip = tipPercentage * cost
                val roundUp = binding.switch1.isChecked
            if (roundUp) {
                tip = kotlin.math.ceil(tip)
            }
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.resultado.text = tip.toString().format(formattedTip)
    }
}
