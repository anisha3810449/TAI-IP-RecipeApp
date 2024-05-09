package com.example.food_recipe_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class signup : AppCompatActivity() {
    lateinit var already : Button
    lateinit var signup: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        already = findViewById(R.id.already)
        signup = findViewById(R.id.signup)

        already.setOnClickListener(){
            val i = Intent(this, login::class.java)
            startActivity(i)
        }

        signup.setOnClickListener(){
            val i = Intent(this, main_page::class.java)
            startActivity(i)
        }
    }
}