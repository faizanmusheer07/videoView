package com.example.videoview

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.videoview.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.saveButton1.setOnClickListener {
            val editor = getSharedPreferences("my_setting", MODE_PRIVATE).edit()
            editor.putString("name", binding.usernameEditText.text.toString())
            editor.putString("email", binding.emailEditText.text.toString())
            editor.putString("password", binding.passwordEditText1.text.toString())
            editor.putString("userClass", binding.usernameEditText.toString())
                editor.apply()
            val intent= Intent(this@SignUpActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        binding.Already.setOnClickListener {
            startActivity(Intent(this@SignUpActivity, LoginActivity::class.java))
            finish()
        }


    }
}
