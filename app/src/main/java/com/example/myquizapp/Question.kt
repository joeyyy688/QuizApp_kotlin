package com.example.myquizapp

data class Question(
    val id: Int,
    val questionText: String,
    val questionImage: Int,
    val options: List<String>,
    val correctAnswer: Int

)
