package com.example.greeter

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private var nameEditText: EditText? = null
    private var greetTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.nameEditText)
        greetTextView = findViewById(R.id.helloTextView)

        nameEditText!!.setOnClickListener { nameEditText!!.text.clear() }
    }

    fun onGreetClicked(view: View) {
        if (nameEditText!!.text.toString() != "")
            greetTextView!!.text = "Hello, "+ nameEditText!!.text.toString().capitalizeWords() + "!"
        else
            nameEditText!!.setHintTextColor(Color.parseColor("#FF03DAC5"))

    }
    fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")

}