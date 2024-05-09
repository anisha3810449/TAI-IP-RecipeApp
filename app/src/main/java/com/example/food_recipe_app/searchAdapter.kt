package com.example.food_recipe_app

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class searchAdapter(private val image: List<Int>,
                    private val name:List<String>,
                    private val time:List<String>,
                    private val requireContext: Context ): RecyclerView.Adapter<searchAdapter.searchViewHolder>(){
    private val filterFoodnm= mutableListOf<String>()
    private val filterFoodImage= mutableListOf<Int>()
    private val filterFoodtime= mutableListOf<String>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): searchViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.search_item, parent, false)
        return searchViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return name.size
    }

    private fun setupSearchView(view: View){
        val searchView = view?.findViewById<SearchView>(R.id.searchrecipe)
        searchView?.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                query.let { filterList(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText.let { filterList(newText) }
                return true
            }
        })
    }

    fun filterList(query: String?)
    {
        filterFoodnm.clear()
        filterFoodImage.clear()
        filterFoodtime.clear()

        name.forEachIndexed { index, s ->
            if (s.contains(query.toString(), ignoreCase = true))
            {
                filterFoodnm.add(s)
                filterFoodImage.add(image[index])
                filterFoodtime.add(s)
            }
        }

    }

    override fun onBindViewHolder(holder: searchViewHolder, position: Int) {
        holder.bind(image[position], name[position], time[position], requireContext)
    }

    inner class searchViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val img: ImageView = itemView.findViewById(R.id.searchImg)
        private val nm: TextView = itemView.findViewById(R.id.searchtxt)
        private val tm: TextView = itemView.findViewById(R.id.searchtime)

        fun bind(image: Int, name: String, time: String, requireContext: Context) {

            nm.text= name.toString()
            tm.text= time.toString()
            img.setImageResource(image)
        }

    }

}

