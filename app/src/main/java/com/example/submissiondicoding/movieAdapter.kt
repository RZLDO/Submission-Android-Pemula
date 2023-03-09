package com.example.submissiondicoding

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class movieAdapter(private val MovieList:ArrayList<moviesData>): RecyclerView.Adapter<movieAdapter.ListViewHolder>(){
    private lateinit var onItemClickCallback: OnItemClickCallback
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageData:ImageView=itemView.findViewById(R.id.iv_imageData)
        val name: TextView = itemView.findViewById(R.id.tv_name)
        val desc: TextView = itemView.findViewById(R.id.tv_desc)
    }
    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback){
        this.onItemClickCallback = onItemClickCallback
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View= LayoutInflater.from(parent.context).inflate(R.layout.item_row,parent,false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = MovieList.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name,desc,imageData) = MovieList[position]
        Glide.with(holder.itemView.context)
            .load(imageData)
            .into(holder.imageData)
        holder.name.text = name
        holder.desc.text = desc
        holder.itemView.setOnClickListener{
            onItemClickCallback.onItemClicked(MovieList[holder.adapterPosition])
        }
    }
    interface OnItemClickCallback{
        fun onItemClicked(data:moviesData)
    }

}