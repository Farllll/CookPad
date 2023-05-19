package com.nadif.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView

class Adapter2(private val Modallist2 : ArrayList<Modal2>) :
    RecyclerView.Adapter<Adapter2.Myviewholder>() {
    private lateinit var mListener2 : onItemClickListener

    interface onItemClickListener{

        fun onItemClick(position : Int)

    }

    fun setOnItemClickListener(listener2: onItemClickListener){

        mListener2 = listener2

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myviewholder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.list_box2,parent, false)
        return Myviewholder(itemView,mListener2)
    }

    override fun onBindViewHolder(holder: Myviewholder, position: Int) {
        val currentItem = Modallist2[position]
        holder.titleImage2.setImageResource(currentItem.ImageId2)
        holder.text2.text = currentItem.text2
    }

    override fun getItemCount(): Int {
        return Modallist2.size
    }

    class Myviewholder(itemView: View,listener2: onItemClickListener) : RecyclerView.ViewHolder(itemView){
        val titleImage2 : ShapeableImageView = itemView.findViewById(R.id.title_image)
        val text2 : TextView = itemView.findViewById(R.id.tvHeading)

        init {

            itemView.setOnClickListener {

                listener2.onItemClick(adapterPosition)

            }


        }
    }

}