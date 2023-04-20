package com.example.myquizapp

import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestionsActivity : AppCompatActivity(), OnClickListener{
    private var index: Int = 0
    private var countriesData: List<Question>? = null
    private var selectedOptionPosition: Int = 0

    private var question: TextView? = null
    private var imageView: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var questionCount: TextView? = null
    private var option1: Button? = null
    private var option2: Button? = null
    private var option3: Button? = null
    private var option4: Button? = null
    private var submitButton: Button? = null




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)

         countriesData = Constants.getQuestions()

         question = findViewById<TextView>(R.id.questionAsked)
         imageView = findViewById<ImageView>(R.id.countryImage)
         progressBar = findViewById<ProgressBar>(R.id.linearProgressBar)
         questionCount = findViewById<TextView>(R.id.questionCount)
         option1 = findViewById<Button>(R.id.option1)
         option2 = findViewById<Button>(R.id.option2)
         option3 = findViewById<Button>(R.id.option3)
         option4 = findViewById<Button>(R.id.option4)
         submitButton = findViewById<Button>(R.id.submitBtn)

        setQuestion()
        defaultOptionsView()

        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submitButton?.setOnClickListener(this)

    }

    private fun setQuestion() {
        question?.text = countriesData!![index].questionText
        imageView?.setImageResource(countriesData!![index].questionImage)
        progressBar?.progress = (index + 1)
        questionCount?.text = "${index + 1}/${countriesData!!.count()}"
        option1?.text = countriesData!![index].options[0]
        option2?.text = countriesData!![index].options[1]
        option3?.text = countriesData!![index].options[2]
        option4?.text = countriesData!![index].options[3]
    }

    private fun defaultOptionsView(){
        val options = addAllButtonsAndReturnThem()

        for (item in options){
            item.setTextColor(Color.parseColor("#7A8089"))
            item.typeface = Typeface.DEFAULT
            item?.setBackgroundColor(Color.parseColor("#ffffff"))

        }
    }

    private fun addAllButtonsAndReturnThem () : ArrayList<Button> {
        val options = ArrayList<Button>()

        option1?.let {
            options.add(0, it)
        }

        option2?.let {
            options.add(1, it)
        }

        option3?.let {
            options.add(2, it)
        }

        option4?.let {
            options.add(3, it)
        }

        return options
    }

    private fun selectedOption(buttonSelected: Button?, indexOfButtonSelected: Int){
        defaultOptionsView()
        selectedOptionPosition = indexOfButtonSelected


        buttonSelected?.setTextColor(Color.parseColor("#ffffff"))
        buttonSelected?.setTypeface(buttonSelected.typeface, Typeface.BOLD)

        buttonSelected?.setBackgroundColor(Color.parseColor("#008080"))

    }

    private fun checkAnswerValidity(){

        if (submitButton?.text == "SUBMIT"){
            val options = addAllButtonsAndReturnThem()

            if (selectedOptionPosition == countriesData!![index].correctAnswer){
                // correct answer

                options[selectedOptionPosition]?.setBackgroundColor(Color.parseColor("#00FF00"))
            }else {
                //
                options[selectedOptionPosition]?.setBackgroundColor(Color.parseColor("#ff0000"))
                //

                options[countriesData!![index].correctAnswer]?.setBackgroundColor(Color.parseColor("#00FF00"))

            }

            if (index + 1 != countriesData!!.count()){
                submitButton?.let {
                    it.text = "GO TO NEXT QUESTION"
                }
            }else {
                submitButton?.let {
                    it.text = "FINISH"
                }
            }

        }else if (submitButton?.text == "FINISH"){
            // Navigate to the new screen and show results
        }
        else {
            index += 1
            setQuestion()
            submitButton?.let {
                it.text = "SUBMIT"
            }
            defaultOptionsView()
        }


    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option1 ->{
                option1?.let {
                    selectedOption(it, 0)
                }
            }
            R.id.option2 ->{
                option2?.let {
                    selectedOption(it, 1)
                }
            }
            R.id.option3 ->{
                option3?.let {
                    selectedOption(it, 2)
                }
            }
            R.id.option4 ->{
                option4?.let {
                    selectedOption(it, 3)
                }
            }
            R.id.submitBtn -> {
                submitButton?.let {
                    checkAnswerValidity()
                }
            }
        }

    }

}