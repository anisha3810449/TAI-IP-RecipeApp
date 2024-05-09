package com.example.food_recipe_app

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class popularAdapter(
    private val img1: List<Int>,
    private val img2: List<Int>,
    private val name: List<String>,
    private val time: List<String>,
    private val videoUrls: List<String>,
    private val requireContext: Context
): RecyclerView.Adapter<popularAdapter.PopularViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.popular_item, parent, false)
        return PopularViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    override fun onBindViewHolder(holder: PopularViewHolder, position: Int) {
        holder.bind(img1[position], img2[position], name[position], time[position], videoUrls[position], requireContext)
        holder.itemView.setOnClickListener()
        {
        }
    }

    inner class PopularViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val image1: ImageView = itemView.findViewById(R.id.popular_img)
        private val image2: ImageView = itemView.findViewById(R.id.img_gradient)
        private val txt: TextView = itemView.findViewById(R.id.popular_nm)
        private val time_txt: TextView = itemView.findViewById(R.id.time)

        fun bind(img1: Int, img2: Int, name: String, time: String, videoUrl: String,requireContext: Context) {

            image1.setImageResource(img1)
            image2.setImageResource(img2)
            txt.text= name
            time_txt.text=time

            image1.setOnClickListener(){
                val i = Intent(Intent.ACTION_VIEW, Uri.parse(videoUrl))
                requireContext.startActivity(i)
            }
        }

    }

}