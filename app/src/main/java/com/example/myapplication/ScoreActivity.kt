package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ScoreActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.ActivityScore)

        val score = intent.getIntExtra("SCORE", 0)
        val total = intent.getIntExtra("TOTAL", 5)

        findViewById<TextView>(R.id.txtScore).text = "You scored $score / $total"

        val msg = when {
            score == total -> "Master Hacker! You know your hacks!"
            score >= 3 -> "Great job! Good common sense!"
            else -> "Stay Safe Online! Keep practicing!"
        }
        findViewById<TextView>(R.id.txtMessage).text = msg

        findViewById<Button>(R.id.btnReview).setOnClickListener {
            startActivity(Intent(this, ReviewActivity::class.java))
        }
        findViewById<Button>(R.id.btnRestart).setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}