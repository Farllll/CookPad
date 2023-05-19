package com.nadif.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
class Adapter3(private val Modallist3 : ArrayList<Modal3>) : RecyclerView.Adapter<Adapter3.Myviewholder>(){


    private lateinit var mListener : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener: onItemClickListener){

        mListener = listener

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_recommended,parent, false)
        return Myviewholder(itemView, mListener)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentItem = Modallist3[position]
        holder.titleImage3.setImageResource(currentItem.ImageId3)
        holder.text1.text = currentItem.text
    }

    override fun getItemCount(): Int {
        return Modallist3.size
    }

    class Myviewholder(itemView: View, listener: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage3 : ShapeableImageView = itemView.findViewById(R.id.image1)
        val text1 : TextView = itemView.findViewById(R.id.tvHeading)

        init {

            itemView.setOnClickListener {

                listener.onItemClick(adapterPosition)

            }


        }
    }

}
