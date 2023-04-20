package com.example.myquizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        var textViewUserName = findViewById<TextView>(R.id.userName)
        var textViewScoreSentence = findViewById<TextView>(R.id.userScore)


        textViewUserName.text = intent.getStringExtra(Constants.userName)

        var quizScore = intent.getIntExtra(Constants.correctAnswers, 0)
        var totalQuestionsNumber = intent.getIntExtra(Constants.totalQuestions, 0)

        textViewScoreSentence.text = "Your score was $quizScore out of $totalQuestionsNumber"
    }

    fun startQuizAgain(view: View){
        startActivity(Intent(this, MainActivity::class.java))
        finish()

    }
}