package com.nadif.home

import android.content.Context
import android.content.SharedPreferences
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text

class MainActivity2 : AppCompatActivity() {
    private val sp: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val backButton = findViewById<ImageView>(R.id.app)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val headingnews : TextView =findViewById(R.id.heading)
        val imagenews : ImageView = findViewById(R.id.image_heading)
        val newsnews : TextView = findViewById(R.id.news)
        val tipenews : TextView = findViewById(R.id.tipe)

        val btn_favo : ImageView = findViewById(R.id.btn_favo)
        val Bundle : Bundle? = intent.extras
        val heading = Bundle!!.getString("heading")
        val image = Bundle!!.getInt("imageId3")
        val news = Bundle!!.getString("news")
        val tipe = Bundle!!.getString("tipe")

        headingnews.text = heading
        imagenews.setImageResource(image)
        newsnews.text = news
        tipenews.text = tipe

        // save
        val sp = getSharedPreferences("user", Context.MODE_PRIVATE)
        val editor = sp.edit()

        //fitur save
        var isSaved = false
        var counter: Int = sp.getInt("count", 0)
        btn_favo.setColorFilter(ContextCompat.getColor(this, R.color.abu))
        btn_favo.setOnClickListener{
            val titles = headingnews.text.toString()
            for (i in 0 until counter) {
                val savedTitle = sp.getString("title"+i, "") ?: ""
                if (savedTitle == titles) {
                    isSaved = true
                    break
                }
            }

            // MENGECEK AGAR TAK ADA DUPLIKAT DATA
            if(!isSaved) {
                editor.putString("title"+counter, titles)
                editor.putInt("count", counter+1)
                editor.apply()
                btn_favo.setColorFilter(ContextCompat.getColor(this, R.color.berem))

                Toast.makeText(
                    applicationContext,
                    "Resep ditambahkan ke daftar favorite",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                btn_favo.setColorFilter(ContextCompat.getColor(this, R.color.berem))
                Toast.makeText(
                    applicationContext,
                    "Resep sudah ada didaftar favorite",
                    Toast.LENGTH_SHORT
                ).show()
            }

            isSaved = false
        }
    }
}