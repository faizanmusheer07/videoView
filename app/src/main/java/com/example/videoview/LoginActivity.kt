package com.example.videoview

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.videoview.databinding.ActivityLoginBinding


class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.saveButton1.setOnClickListener {
            val editor = getSharedPreferences("my_setting", MODE_PRIVATE).edit()
            editor.putString("email", binding.emailEditText1.text.toString())
            editor.putString("password", binding.passwordEditText1.text.toString())
            editor.apply()
            val intent= Intent(this@LoginActivity, ChapterActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.signupText.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
            finish()
        }
    }
}