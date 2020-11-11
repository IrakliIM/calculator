package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.red
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var resultTextView: TextView

    private var operand: Double = 0.0
    private var operation: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    resultTextView = findViewById(R.id.resultTextView)


    findViewById<TextView>(R.id.clearButton).setOnClickListener {
            operand = 0.0
            operation = ""
            resultTextView.text = ""
        }

        findViewById<TextView>(R.id.backSpace).setOnClickListener {
            val backspace = resultTextView.text.toString()
            resultTextView.text = backspace.dropLast(1)
        }

    }

    fun clickOnNumber(view: View){

        if(view is TextView) {

            val number: String = view.text.toString()
            var result: String = resultTextView.text.toString()

            if(result == "0") {
                result = ""
            }

            resultTextView.text = result + number

        }

    }

    fun operationOnClick(view: View){

        if(view is TextView){

            if(!TextUtils.isEmpty(resultTextView.text)){
                operand = resultTextView.text.toString().toDouble()
            }

            resultTextView.text = ""
            operation = view.text.toString()

        }

    }

    fun equalsClick(view: View){
        val secondOperand: String = resultTextView.text.toString()
        var secOperand: Double = 0.0

        if(!TextUtils.isEmpty(secondOperand)){
            secOperand = secondOperand.toDouble()
        }

        when (operation) {
            "+" -> resultTextView.text = (operand + secOperand).toString()
            "-" -> resultTextView.text = (operand - secOperand).toString()
            "*" -> resultTextView.text = (operand * secOperand).toString()
            "/" -> resultTextView.text = (operand / secOperand).toString()
            "%" -> resultTextView.text = ((operand * secOperand)/100).toString()
        }
    }

}