package com.example.kla.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kla.Model.Topic
import com.example.kla.R


class TopicAdapter (private val topicText : List<Topic>):
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>(){

    private lateinit var mListener: onItemClickedListener
    interface onItemClickedListener{
        fun onItemClick(position: Int)
    }
    fun setOnItemClickListener(listener: onItemClickedListener){
        mListener =listener
    }

    class TopicViewHolder(itemView: View, listener: onItemClickedListener) : RecyclerView.ViewHolder(itemView){

        val topicText = itemView.findViewById<TextView>(R.id.topicText)
        val topicImage = itemView.findViewById<ImageView>(R.id.imageView)

        init {
            itemView.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_items, parent, false)
        return TopicViewHolder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        val item = topicText[position]
        holder.topicImage.setImageResource(item.imageId)
        holder.topicText.text = item.textLine 

    }

    override fun getItemCount()= topicText.size
}