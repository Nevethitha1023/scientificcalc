package com.example.scientificcalculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.view.View
import android.widget.Button
import android.widget.EditText

import kotlin.math.*
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.scientificcalculator.ui.theme.ScientificCalculatorTheme


class MainActivity : ComponentActivity() {
    private lateinit var editTextResult: EditText
    private var operand1: Double = 0.0
    private var operand2: Double = Double.NaN
    private var operation: String = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextResult = findViewById(R.id.editTextResult)
    }

    fun onNumberClick(view: View) {
        val button = view as Button
        val currentText = editTextResult.text.toString()
        val newText = currentText + button.text.toString()
        editTextResult.setText(newText)
    }

    fun onOperationClick(view: View) {
        val button = view as Button
        val operationSymbol = button.text.toString()

        if (operand2.isNaN()) {
            operand1 = editTextResult.text.toString().toDouble()
            operation = operationSymbol
            editTextResult.setText("")
        } else {
            calculateResult()
            operation = operationSymbol
        }
    }

    fun onEqualClick(view: View) {
        calculateResult()
    }

    private fun calculateResult() {
        operand2 = editTextResult.text.toString().toDouble()
        val result = when (operation) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            "cos" -> cos(operand1)
            "sin" -> sin(operand1)
            "tan" -> tan(operand1)
            "pow" -> Math.pow(operand1, operand2)
            "sqrt" -> sqrt(operand1)
            "log" -> ln(operand1)
            "mod" -> operand1 % operand2
            else -> 0.0
        }

        editTextResult.setText(result.toString())
        operand1 = result
        operand2 = Double.NaN
    }

    }
}