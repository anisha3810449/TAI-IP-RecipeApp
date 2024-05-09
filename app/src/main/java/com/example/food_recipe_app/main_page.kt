package com.example.food_recipe_app

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.navigation.NavigationView

class main_page : AppCompatActivity() {
    lateinit var menu_btn: ImageButton
    lateinit var drawer: DrawerLayout
    lateinit var nav: NavigationView
    lateinit var search: EditText
    //change1
    @SuppressLint("MissingInflatedId", "ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_page)

        menu_btn = findViewById(R.id.menu_btn)
        drawer = findViewById(R.id.drawer)
        nav = findViewById(R.id.nav)
        search  = findViewById(R.id.search)

        menu_btn.setOnClickListener()
        {
            drawer.open()
        }

        nav.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.home -> {
                    drawer.close()
                }
                R.id.saved -> {
                    val i = Intent(this,saved::class.java)
                    startActivity(i)
                }
            }
            true
        }

        search.setOnClickListener()
        {
            val i = Intent(this, search_recipe::class.java)
            startActivity(i)
        }

        val recyclerView: RecyclerView = findViewById(R.id.popular)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        // Prepare data for the adapter
        val image1 = listOf(R.drawable.biryani, R.drawable.pizza2, R.drawable.dosa, R.drawable.cheescake, R.drawable.momos)
        val image2 = listOf(R.drawable.gradient, R.drawable.gradient, R.drawable.gradient, R.drawable.gradient, R.drawable.gradient)
        val names = listOf("Hyderabad Biryani", "Vegetarian Pizza", "Ragi Dosa", "Blueberry Cheesecake", "Chicken Momos")
        val times = listOf("⌚ 1hr", "⌚ 30min", "⌚ 20min", "⌚ 45min", "⌚ 50min")
        val videoUrlList = listOf(
            "https://www.youtube.com/watch?v=uygb9O-MDPw",
            "https://www.youtube.com/watch?v=yJM15eBfgrU",
            "https://www.youtube.com/watch?v=jEOtna3oZLo",
            "https://www.youtube.com/watch?v=UrHfKRbyJ_s",
            "https://www.youtube.com/watch?v=8jHu5X_KgjY"
        )

        // Create and set the adapter
        val adapter = popularAdapter(image1, image2, names, times, videoUrlList,this)
        recyclerView.adapter = adapter

    }
}