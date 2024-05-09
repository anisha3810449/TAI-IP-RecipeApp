package com.example.food_recipe_app

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class search_recipe : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_recipe)

        val recyclerView: RecyclerView = findViewById(R.id.searchrv)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val image = listOf(R.drawable.biryani, R.drawable.pizza2, R.drawable.dosa, R.drawable.cheescake, R.drawable.momos)
        val names = listOf("Hyderabad Biryani", "Vegetarian Pizza", "Ragi Dosa", "Blueberry Cheesecake", "Chicken Momos")
        val times = listOf("⌚ 1hr", "⌚ 30min", "⌚ 20min", "⌚ 45min", "⌚ 50min")

        val adapter = searchAdapter(image, names, times, this)
        recyclerView.adapter = adapter
    }
}