package com.example.food_recipe_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class saved : AppCompatActivity() {
    lateinit var back: Button
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saved)

        back = findViewById(R.id.back)

        back.setOnClickListener(){
            finish()
        }
    }
}