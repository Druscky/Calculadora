package com.example.myfirstcalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.myfirstcalculadora.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding
    private var n1 = 0
    private var n2 = 0
    private var op = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
        b.tvPantalla.text = "0"

//        binding.btn0.setOnClickListener { pressNum("0") }
//        binding.btn1.setOnClickListener { pressNum("1") }
//        binding.btn2.setOnClickListener { pressNum("2") }
//        binding.btn3.setOnClickListener { pressNum("3") }
//        binding.btn4.setOnClickListener { pressNum("4") }
//        binding.btn5.setOnClickListener { pressNum("5") }
//        binding.btn6.setOnClickListener { pressNum("6") }
//        binding.btn7.setOnClickListener { pressNum("7") }
//        binding.btn8.setOnClickListener { pressNum("8") }
//        binding.btn9.setOnClickListener { pressNum("9") }
//        binding.opPunto.setOnClickListener { pressOp(".") }

        b.btnClear.setOnClickListener {
            b.tvPantalla.text = "0"
            n1 = 0
            n2 = 0
            op = ""
        }
        b.opPunto.setOnClickListener {
            if (!b.tvPantalla.text.toString().contains('.'))
                b.tvPantalla.text = b.tvPantalla.text.toString().plus(".")
        }
//        binding.opDiv.setOnClickListener {
//            n1 = binding.tvPantalla.text.toString().toInt()
//            op = DIVISION
//            binding.tvPantalla.text = "0"
//        }
//        binding.opMult.setOnClickListener {
//            n1 = binding.tvPantalla.text.toString().toInt()
//            op = MULT
//            binding.tvPantalla.text = "0"
//        }
//        binding.opSum.setOnClickListener {
//            n1 = binding.tvPantalla.text.toString().toInt()
//            op = SUMA
//            binding.tvPantalla.text = "0"
//        }
//        binding.opRest.setOnClickListener {
//            n1 = binding.tvPantalla.text.toString().toInt()
//            op = RESTA
//            binding.tvPantalla.text = "0"
//        }
        b.opIgual.setOnClickListener {
            n2 = b.tvPantalla.text.toString().toInt()
            var result = when (op) {
                SUMA -> n1 + n2
                RESTA -> n1 - n2
                MULT -> n1 * n2
                DIVISION -> n1 / n2
                else -> 0
            }
            b.tvPantalla.text = result.toString()
        }

    }

    companion object{
        const val SUMA = "+"
        const val RESTA = "-"
        const val DIVISION = "/"
        const val MULT = "*"
    }

//    fun pressNum(n:String){
//        if (b.tvPantalla.text.length < 10)
//            b.tvPantalla.text =
//                b.tvPantalla.text.toString().plus(n).toInt().toString()
//    }

    fun onClickNumber(view:View){
        if (view is Button) {
            val textBtn = view.text.toString()
            if (b.tvPantalla.text.toString() != "0") {
                b.tvPantalla.text = b.tvPantalla.text.toString().plus(textBtn)
            } else {
                b.tvPantalla.text = textBtn
            }
        }
    }

    fun onClickOp (view:View) {
        if (view is Button) {
            n1 = b.tvPantalla.text.toString().toInt()
            op = view.text.toString()
            b.tvPantalla.text = "0"
        }
    }
}


//binding.opRest.setOnClickListener {
//            n1 = binding.tvPantalla.text.toString().toInt()
//            op = RESTA
//            binding.tvPantalla.text = "0"
//        }
