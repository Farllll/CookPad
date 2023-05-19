package com.nadif.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Myadapter(private val Modallist : ArrayList<Modal>) :
    RecyclerView.Adapter<Myadapter.Myviewholder>() {

    private lateinit var mListener3 : Myadapter.onItemClickListener
    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener3: Myadapter.onItemClickListener){

        mListener3 = listener3

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_box1,parent, false)
        return Myviewholder(itemView,mListener3)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentItem = Modallist[position]
        holder.titleImage.setImageResource(currentItem.titleimage)
        holder.titlename.text = currentItem.heading
    }

    override fun getItemCount(): Int {
        return Modallist.size
    }

    class Myviewholder(itemView: View,listener2 : onItemClickListener) : RecyclerView.ViewHolder(itemView){

        val titleImage : ImageView = itemView.findViewById(R.id.titleImage)
        val titlename : TextView =itemView.findViewById(R.id.titlename)

        init {

            itemView.setOnClickListener {

                listener2.onItemClick(adapterPosition)
            }
        }
    }
}