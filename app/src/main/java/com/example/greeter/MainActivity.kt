package com.example.greeter

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    var words: String = "Hello, "
    private var nameEditText: EditText? = null
    private var greetTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nameEditText = findViewById(R.id.nameEditText)
        greetTextView = findViewById(R.id.helloTextView)

    }

    fun onGreetClicked(view: View) {
        if (nameEditText!!.text.toString() != "")
            words = "Hello, " + nameEditText!!.text.toString().capitalizeWords() + "!"
        else
            words = "Hello"
            nameEditText!!.setHintTextColor(Color.parseColor("#FF03DAC5"))

        greetTextView!!.text = words
    }

    fun String.capitalizeWords(): String = split(" ").map { it.capitalize() }.joinToString(" ")


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("words", words)

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        words = savedInstanceState.getString("words").toString()
        greetTextView!!.text = words

    }
}