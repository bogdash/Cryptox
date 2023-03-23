package com.example.cryptox

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class SignUpActivity: AppCompatActivity() {

    private lateinit var buttonSignUp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sign_up)
        buttonSignUp = findViewById(R.id.buttonSignUp)

        buttonSignUp.setOnClickListener {
            val intent = Intent(this@SignUpActivity, MarketActivity::class.java)
            startActivity(intent)
        }
    }
}