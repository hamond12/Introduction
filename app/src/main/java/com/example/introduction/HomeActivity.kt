package com.example.introduction

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val textViewId = findViewById<TextView>(R.id.textViewId)
        textViewId.text = intent.getStringExtra("id")

        val profileImage = findViewById<ImageView>(R.id.profileImage)
        when(Random.nextInt(5)){
            0 -> profileImage.setImageResource(R.drawable.profile1)
            1 -> profileImage.setImageResource(R.drawable.profile2)
            2 -> profileImage.setImageResource(R.drawable.profile3)
            3 -> profileImage.setImageResource(R.drawable.profile4)
            4 -> profileImage.setImageResource(R.drawable.profile5)
        }


        val finishButton = findViewById<Button>(R.id.finishButton)

        finishButton.setOnClickListener {
            finish()
        }
    }
}