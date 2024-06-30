package com.example.introduction

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var signUpResult: ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val editTextId = findViewById<EditText>(R.id.editTextId)
        val editTextPw = findViewById<EditText>(R.id.editTextPw)

        val loginButton = findViewById<Button>(R.id.loginButton)
        val signUpButton = findViewById<Button>(R.id.signUpButton)

        signUpResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { it ->
            if (it.resultCode == RESULT_OK) {
                val id = it.data?.getStringExtra("id")?:""
                val pw = it.data?.getStringExtra("pw")?:""
                editTextId.setText(id)
                editTextPw.setText(pw)
            }
        }

        loginButton.setOnClickListener {
            if (editTextId.text.isBlank() || editTextPw.text.isBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("id", editTextId.text.toString())
                startActivity(intent)
            }
        }

        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpResult.launch(intent)
        }
    }
}