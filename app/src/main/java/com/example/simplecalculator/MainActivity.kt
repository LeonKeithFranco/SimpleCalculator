package com.example.simplecalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    // HELPER CLASS //
    private enum class CalcMode {
        ADD,
        SUBTRACT,
        MULTIPLY,
        NONE
    } // calcMode


    // ATTRIBUTES //
    private var mode = CalcMode.NONE
    private var modePressed = false
    private val output = StringBuilder()


    // METHODS //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainTextView.text = "0"

        val numButtons = arrayOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)
        initializeNumberButtons(numButtons)

        buttonClear.setOnClickListener { clear() }

    } // onCreate

    private fun initializeNumberButtons(numButtons: Array<Button>) {
        for (button in numButtons) {
            button.setOnClickListener {
                val tempString = StringBuilder(mainTextView.text)

                when (tempString.toString()) {
                    "0" -> tempString[0] = button.text[0]
                    else -> tempString.append(button.text)
                }

                mainTextView.text = tempString.toString()
                output.append(button.text)
                modePressed = false
            } // setOnClickListener
        } // for
    } // initializeNumberButtons

    private fun initializeModeButtons(modeButtons: Array<Button>) {

    } // initializeModeButtons

    private fun clear() {
        output.clear()
        mainTextView.text = "0"
        modePressed = false
    } // clear

} // MainActivity
