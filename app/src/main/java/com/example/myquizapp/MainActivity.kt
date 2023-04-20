package com.example.myquizapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coordinatorLayout = findViewById<LinearLayout>(R.id.mainLayout);

        val startButton = findViewById<Button>(R.id.startBtn)
        val textInput = findViewById<EditText>(R.id.nameTextInput)

        startButton.setOnClickListener {
            if (textInput.text.isNotEmpty()){
                // Navigate to quiz screen
                val intent = Intent(this, QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.userName, textInput.text.toString())
                startActivity(intent)
                finish()
            }else {
                val snackBar = Snackbar.make(coordinatorLayout, "Please make sure to enter your name before starting", Snackbar.LENGTH_LONG)
                snackBar.show()

            }
        }
    }


}