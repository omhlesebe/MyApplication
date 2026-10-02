package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuizActivity : AppCompatActivity() {

    private var currentIndex = 0
    private var score = 0
    private var answered = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        showQuestion()

        findViewById<Button>(R.id.btnHack).setOnClickListener {
            checkAnswer(true)
        }

        findViewById<Button>(R.id.btnMyth).setOnClickListener {
            checkAnswer(false)
        }

        findViewById<Button>(R.id.btnNext).setOnClickListener {
            currentIndex++
            if (currentIndex < questions.size) {
                showQuestion()
            } else {
                val intent = Intent(this, ScoreActivity::class.java)
                intent.putExtra("SCORE", score)
                intent.putExtra("TOTAL", questions.size)
                startActivity(intent)
                finish()
            }
        }
    }

    private fun showQuestion() {
        val q = questions[currentIndex]
        findViewById<TextView>(R.id.txtQuestion).text = q.statement
        findViewById<TextView>(R.id.txtFeedback).text = ""
        findViewById<TextView>(R.id.txtProgress).text = "Question ${currentIndex + 1}/${questions.size}"
        answered = false
        findViewById<Button>(R.id.btnNext).isEnabled = false
        findViewById<Button>(R.id.btnHack).isEnabled = true
        findViewById<Button>(R.id.btnMyth).isEnabled = true
    }

    private fun checkAnswer(userPickedHack: Boolean) {
        if (answered) return
        answered = true
        val correct = questions[currentIndex].isHack
        if (correct == userPickedHack) {
            score++
            findViewById<TextView>(R.id.txtFeedback).text = "Correct!"
        } else {
            findViewById<TextView>(R.id.txtFeedback).text = "Wrong!"
        }
        findViewById<Button>(R.id.btnNext).isEnabled = true
        findViewById<Button>(R.id.btnHack).isEnabled = false
        findViewById<Button>(R.id.btnMyth).isEnabled = false
    }
}