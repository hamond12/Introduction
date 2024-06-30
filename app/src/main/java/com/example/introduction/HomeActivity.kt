package com.example.introduction

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textViewId = findViewById<TextView>(R.id.textViewId)
        textViewId.text = intent.getStringExtra("id")

        val finishButton = findViewById<Button>(R.id.finishButton)

        finishButton.setOnClickListener {
            finish()
        }
    }
}