package com.example.food_recipe_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class login : AppCompatActivity() {
    lateinit var dont: Button
    lateinit var login: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dont = findViewById(R.id.dont)
        login = findViewById(R.id.login)

        dont.setOnClickListener(){
            val i = Intent(this, signup::class.java)
            startActivity(i)
        }

        login.setOnClickListener(){
            val i = Intent(this, main_page::class.java)
            startActivity(i)
        }
    }
}