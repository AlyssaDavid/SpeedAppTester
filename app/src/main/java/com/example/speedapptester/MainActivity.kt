package com.example.speedapptester

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        // Link layout elements to variables
        val speedInput: EditText = findViewById(+R.id.speedInput)


        val checkSpeedButton: Button = findViewById(+R.id.checkSpeedButton)


        val resultTextView: TextView = findViewById(+R.id.resultTextView)

        // Set button click listener
        checkSpeedButton.setOnClickListener {
            val enteredSpeed = speedInput.text.toString()

            // Validate and handle input
            val speed = enteredSpeed.toIntOrNull()

            if (speed != null) {

                val message = when {
                    speed < 60 -> "You are driving safely!" //Safe speed

                    speed in 60..80 -> "Warning! Drive carefully!" //Warning

                    speed in 81..100 -> "Fine: R500" // Fine

                    speed > 100 -> "Fine: R2000" // Fine

                    else -> "Please enter a valid speed." // Invalid input
                }
                resultTextView.text = message
            } else {
                resultTextView.text = "Invalid input! Please enter a numeric speed." // Invalid input
            }
        }
    }
}
