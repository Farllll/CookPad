package com.nadif.home

import Adapter5
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity4 : AppCompatActivity() {
//    lateinit var ImageId5 : Array<Array<List<Int>>>
    private lateinit var newrecycleview5 : RecyclerView
    private lateinit var newarraylist5 : ArrayList<Modal5>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)


        val backButton = findViewById<ImageView>(R.id.app2)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val tipenews1 : TextView = findViewById(R.id.tipe2)
//        val gridnews1 : TextView = findViewById(R.id.grid)
        val Bundle : Bundle? = intent.extras
        val tipe = Bundle!!.getString("tipe")
//        ImageId5 = Bundle!!.getSerializable("gridimage") as Array<Array<List<Int>>>
        tipenews1.text = tipe
//
//        newrecycleview5 = findViewById(R.id.grid)
//        newrecycleview5.layoutManager = GridLayoutManager(this,2);
//        newrecycleview5.setHasFixedSize(true)
//
//        newarraylist5 = arrayListOf<Modal5>()
//        getUserdata5()
//    }
//
//    private fun getUserdata5() {
//        for(i in ImageId5.indices){
//            val modal5 = Modal5(ImageId5[i])
//            newarraylist5.add(modal5)
//        }
//        newrecycleview5.adapter = Adapter5(newarraylist5)
//        val adapter = Adapter5(newarraylist5)
//        newrecycleview5.adapter = adapter
//
    }
}