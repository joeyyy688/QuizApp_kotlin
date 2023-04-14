package com.example.myquizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView

class QuizQuestionsActivity : AppCompatActivity() {
    private var index: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

        val countriesData = Constants.getQuestions()

        val question = findViewById<TextView>(R.id.questionAsked)
        val imageView = findViewById<ImageView>(R.id.countryImage)
        val progressBar = findViewById<ProgressBar>(R.id.linearProgressBar)
        val questionCount = findViewById<TextView>(R.id.questionCount)
        val option1 = findViewById<Button>(R.id.option1)
        val option2 = findViewById<Button>(R.id.option2)
        val option3 = findViewById<Button>(R.id.option3)
        val option4 = findViewById<Button>(R.id.option4)
        val submitButton = findViewById<Button>(R.id.submitBtn)

        question.text = countriesData[index].questionText
        imageView.setImageResource(countriesData[index].questionImage)
        progressBar.progress = (index + 1)
        questionCount.text = "${index + 1}/${countriesData.count()}"
        option1.text = countriesData[index].options[0]
        option2.text = countriesData[index].options[1]
        option3.text = countriesData[index].options[2]
        option4.text = countriesData[index].options[3]


        option1.setOnClickListener{

            checkAnswerValidity(0)
        }

        option2.setOnClickListener{
            checkAnswerValidity(1)
        }

        option3.setOnClickListener{
            checkAnswerValidity(2)
        }

        option4.setOnClickListener{
            checkAnswerValidity(3)
        }

    }

    private fun checkAnswerValidity(indexOfAnswerSelected: Int){

    }

}