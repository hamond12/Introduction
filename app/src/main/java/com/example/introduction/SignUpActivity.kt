package com.example.introduction

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val editTextName = findViewById<EditText>(R.id.editTextName)
        val editTextId = findViewById<EditText>(R.id.editTextId)
        val editTextPw = findViewById<EditText>(R.id.editTextPw)

        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            if(editTextName.text.isBlank() || editTextId.text.isBlank() || editTextPw.text.isBlank()){
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }else{
                intent.putExtra("id", editTextId.text.toString())
                intent.putExtra("pw", editTextPw.text.toString())
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }
}