package com.nadif.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.google.android.material.imageview.ShapeableImageView

class ManuDessert : AppCompatActivity() {
    lateinit var news: Array<String>
    lateinit var ImageId3: Array<Int>
    lateinit var heading: Array<String>
    lateinit var tipe : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_manu_dessert)

        news = arrayOf(
            getString(R.string.food_f),
            getString(R.string.food_h),
            getString(R.string.food_g),
            getString(R.string.food_i),
            getString(R.string.food_s),
            getString(R.string.food_k)
        )

        heading = arrayOf(
            "Fluffy Soufflé Pancakes",
            "Nutella Brownies",
            "Strawberry Sando",
            "Chocolate Chip Cookies",
            "Custard Pudding",
            "Mini Cheesecakes"
        )
        tipe = "Menu Dessert"
        ImageId3 = arrayOf(
            R.drawable.pancakes,
            R.drawable.brownies,
            R.drawable.sando,
            R.drawable.cookies,
            R.drawable.pudding,
            R.drawable.cheese
        )

        val pancakes = findViewById<ShapeableImageView>(R.id.pancakes)
        val brownies = findViewById<ShapeableImageView>(R.id.brownies)
        val sando = findViewById<ShapeableImageView>(R.id.sando)
        val cookies = findViewById<ShapeableImageView>(R.id.cookies)
        val pudding = findViewById<ShapeableImageView>(R.id.pudding)
        val cheese = findViewById<ShapeableImageView>(R.id.cheese)

        pancakes.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[0])
            intent.putExtra("imageId3",ImageId3[0])
            intent.putExtra("news",news[0])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }

        brownies.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[1])
            intent.putExtra("imageId3",ImageId3[1])
            intent.putExtra("news",news[1])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }
        sando.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[2])
            intent.putExtra("imageId3",ImageId3[2])
            intent.putExtra("news",news[2])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }
        cookies.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[3])
            intent.putExtra("imageId3",ImageId3[3])
            intent.putExtra("news",news[3])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }
        pudding.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[4])
            intent.putExtra("imageId3",ImageId3[4])
            intent.putExtra("news",news[4])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }
        cheese.setOnClickListener(){
            val intent = Intent(this@ManuDessert, MainActivity2::class.java)
            intent.putExtra("heading",heading[5])
            intent.putExtra("imageId3",ImageId3[5])
            intent.putExtra("news",news[5])
            intent.putExtra("tipe",tipe)
            startActivity(intent)
        }
    }
}