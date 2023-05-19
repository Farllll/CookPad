package com.nadif.home

import Adapter4
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadif.home.databinding.ActivityMainBinding
import androidx.appcompat.widget.SearchView
import java.util.Locale.filter
import android.widget.Filterable
import android.widget.Filter



class MainActivity3 : AppCompatActivity() {
    lateinit var ImageId4 : Array<Int>
    lateinit var rate : Array<String>
    lateinit var heading : Array<String>
    lateinit var news : Array<String>
    private lateinit var searchView: SearchView
    lateinit var tipe3: String


    private lateinit var newrecycleview4 : RecyclerView
    private lateinit var newarraylist4 : ArrayList<Modal4>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)


        val backButton = findViewById<ImageView>(R.id.app)
        backButton.setOnClickListener {
            onBackPressed()
        }

        val tipenews = findViewById<TextView>(R.id.tipe)
        val Bundle : Bundle? = intent.extras
        val tipe = Bundle!!.getString("tipe")

        tipenews.text = tipe

        ImageId4 = arrayOf(
            R.drawable.lontong,
            R.drawable.rotipanggang,
            R.drawable.oatmeal2,
            R.drawable.teriyaki,
            R.drawable.beef,
            R.drawable.brownies,
            R.drawable.buryam,
            R.drawable.pretzel,
            R.drawable.yambar,
            R.drawable.onion,

            R.drawable.popcorn,
            R.drawable.potato,
            R.drawable.coffe,
            R.drawable.pudding,
            R.drawable.roti,
            R.drawable.seblak2,
            R.drawable.spaghetti,
            R.drawable.seblak,
            R.drawable.bubur,
            R.drawable.telurmatasapi,

            R.drawable.waffle,
            R.drawable.nasigoreng
        )
        heading = arrayOf(
            "Lontong",
            "Roti panggang",
            "Oatmeal",
            "teriyaki",
            "beef",

            "brownies",
            "buryam",
            "pretzel",
            "Ayam Bakar",
            "onion",

            "popcorn",
            "potato",
            "coffe",
            "pudding",
            "roti",

            "Seblak",
            "Spaghetti",
            "Seblak",
            "Bubur",
            "Telur mata sapi",

            "Waffle",
            "nasi goreng"
        )

        //rate


        rate = arrayOf(
            getString(R.string.ratting5),
            getString(R.string.ratting4),
            getString(R.string.ratting3),
            getString(R.string.ratting2),
            getString(R.string.ratting3),
            getString(R.string.ratting4),
            getString(R.string.ratting5),
            getString(R.string.ratting4),
            getString(R.string.ratting3),
            getString(R.string.ratting5),

            getString(R.string.ratting3),
            getString(R.string.ratting4),
            getString(R.string.ratting1),
            getString(R.string.ratting2),
            getString(R.string.ratting3),
            getString(R.string.ratting4),
            getString(R.string.ratting5),
            getString(R.string.ratting4),
            getString(R.string.ratting3),
            getString(R.string.ratting5),

            getString(R.string.ratting3),
            getString(R.string.ratting4)
        )
        news = arrayOf(
            getString(R.string.food_a),
            getString(R.string.food_b),
            getString(R.string.food_c),
            getString(R.string.food_b),
            getString(R.string.food_y),

            getString(R.string.food_z),
            getString(R.string.food_n),
            getString(R.string.food_aa),
            getString(R.string.food_v),
            getString(R.string.food_ab),

            getString(R.string.food_w),
            getString(R.string.food_x),
            getString(R.string.food_r),
            getString(R.string.food_s),
            getString(R.string.food_t),

            getString(R.string.food_u),
            getString(R.string.food_l),
            getString(R.string.food_ac),
            getString(R.string.food_ad),
            getString(R.string.food_d),

            getString(R.string.food_p),
            getString(R.string.food_q),
        )

        tipe3 = "Resep Makanan"


        newrecycleview4 = findViewById(R.id.grid)
        newrecycleview4.layoutManager = GridLayoutManager(this,2);
        newrecycleview4.setHasFixedSize(true)

        newarraylist4 = arrayListOf<Modal4>()
        getUserdata4()

    }

    private fun getUserdata4() {
        for(i in ImageId4.indices){
            val modal4 = Modal4(ImageId4[i], heading[i])
            newarraylist4.add(modal4)
        }
        val adapter = Adapter4(newarraylist4)
        newrecycleview4.adapter = adapter

        adapter.setOnItemClickListener(object : Adapter4.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(this@MainActivity3, MainActivity2::class.java)
                intent.putExtra("heading", newarraylist4[position].heading)
                intent.putExtra("imageId3", newarraylist4[position].ImageId4)
                intent.putExtra("news",news[position])
                intent.putExtra("tipe",tipe3)
                startActivity(intent)
            }
        })
    }

}