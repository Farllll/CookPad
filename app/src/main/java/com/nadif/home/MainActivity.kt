package com.nadif.home

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var newrecycleview : RecyclerView
    private lateinit var newarraylist : ArrayList<Modal>
    private lateinit var newrecycleview2 : RecyclerView
    private lateinit var newarraylist2 : ArrayList<Modal2>
    private lateinit var newrecycleview3 : RecyclerView
    private lateinit var newarraylist3 : ArrayList<Modal3>
    lateinit var ImageId : Array<Int>
    lateinit var ImageId2 : Array<Int>
    lateinit var ImageId3 : Array<Int>
    lateinit var name : Array<String>
    lateinit var text : Array<String>
    lateinit var text2 : Array<String>
    lateinit var news : Array<String>
    lateinit var news2 : Array<String>
    lateinit var news1: Array<Array<List<Int>>>
    lateinit var tipe1 : String
    lateinit var tipe : Array<String>
    lateinit var tipe2 : String
    lateinit var tipe3 : String
    lateinit var handler: Handler
    lateinit var runnable: Runnable


    private lateinit var vpslider : ViewPager2
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val box1self : RelativeLayout = findViewById(R.id.box1self)
        val box2self : RelativeLayout = findViewById(R.id.box2self)
        val box3self : RelativeLayout = findViewById(R.id.box3self)
        val box4self : RelativeLayout = findViewById(R.id.box4self)
        val all : TextView =findViewById(R.id.all)

        all.setOnClickListener(){
            val intent = Intent(this, MainActivity3::class.java)
                intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

//        val sett : ImageView =findViewById(R.id.settings)
//
//        sett.setOnClickListener(){
//            val intent = Intent(this, setting::class.java);
//            startActivity(intent)
//        }

        box1self.setOnClickListener(){
            val intent = Intent(this, MenuUtama::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box2self.setOnClickListener(){
            val intent = Intent(this, ManuSarapan::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box3self.setOnClickListener(){
            val intent = Intent(this, ManuDessert::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box4self.setOnClickListener(){
            val intent = Intent(this, MenuSnack::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }
//        membuat animasi
//
//        handler = Handler(Looper.getMainLooper()){
//            runnable = object:Runnable{
//                var index = 0
//                override fun run() {
//                    if (index == gambar.size)
//                        index = 0
//
//                }
//            }
//        }

        ImageId = arrayOf(
            R.drawable.croissant,
            R.drawable.roastedchicken,
            R.drawable.icecream,
            R.drawable.snack
        )
        name = arrayOf("Sarapan","Utama","Dessert","Snack")

        //box2

        ImageId2 = arrayOf(
            R.drawable.lontong,
            R.drawable.rotipanggang,
            R.drawable.oatmeal2,
            R.drawable.telurmatasapi
        )

        news2 = arrayOf(
            getString(R.string.food_a),
            getString(R.string.food_b),
            getString(R.string.food_c),
            getString(R.string.food_d)
        )


        text2 = arrayOf(
            "Lontong",
            "Roti Panggang",
            "Oatmeal",
            "Telur Mata Sapi"
        )
        //box3
        ImageId3 = arrayOf(
            R.drawable.memotong,
            R.drawable.sayuran
        )

        text = arrayOf(
            "Beberapa tips dalam memasak agar lebih",
            "Rekomendasi makanan diet"
        )
        //data
        news = arrayOf(
            getString(R.string.news_a),
            getString(R.string.news_b)
        )

        tipe1 = "Menu Rekomendasi"
        tipe2 = "Informasi Lain"
        tipe3 = "Daftar Resep Makanan"

        //box1

        tipe = arrayOf(
            "Sarapan",
            "Menu Utama",
            "Dessert",
            "Snack"
        )
//
//        news1 = intArrayOf(listOf(R.drawable.lontong), listOf(R.drawable.roti);
//        news1= arrayOf(arrayOf(listOf(R.drawable.lontong, R.drawable.roti), listOf(R.drawable.nasigoreng, R.drawable.oat)).toString())
        news1 = arrayOf(
            arrayOf(
                listOf(R.drawable.lontong, R.drawable.oatmeal2,R.drawable.nasigoreng, R.drawable.bubur)
            ),
            arrayOf(
                listOf(R.drawable.lontong, R.drawable.oatmeal2,R.drawable.nasigoreng, R.drawable.bubur)
            ),
            arrayOf(
                listOf(R.drawable.lontong, R.drawable.oatmeal2,R.drawable.nasigoreng, R.drawable.bubur)
            ),
            arrayOf(
                listOf(R.drawable.lontong, R.drawable.oatmeal2,R.drawable.nasigoreng, R.drawable.bubur)
            )
        )


        newrecycleview = findViewById(R.id.box1)
        newrecycleview.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        newrecycleview.setHasFixedSize(true)

        newrecycleview2 = findViewById(R.id.box2)
        newrecycleview2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        newrecycleview2.setHasFixedSize(true)

        newrecycleview3 = findViewById(R.id.box3)
        newrecycleview3.layoutManager = LinearLayoutManager(this)
        newrecycleview3.setHasFixedSize(true)

        newarraylist = arrayListOf<Modal>()
        getUserdata()
        newarraylist2 = arrayListOf<Modal2>()
        getUserdata2()
        newarraylist3 = arrayListOf<Modal3>()
        getUserdata3()


        val imageSlider = findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()

        imageList.add(SlideModel(R.drawable.seblak,"\tSeblak\n\t20 menit"))
        imageList.add(SlideModel(R.drawable.coffe,"\tCoffe\n\t" +
                "10 menit"))
        imageList.add(SlideModel(R.drawable.bubur,"\tBubur\n" +
                "60 menit"))

        imageSlider.setImageList(imageList, ScaleTypes.FIT)



    }



    private fun getUserdata3() {
        for(i in ImageId3.indices){
                val modal3 = Modal3(ImageId3[i], text[i])
                newarraylist3.add(modal3)
        }
        newrecycleview3.adapter = Adapter3(newarraylist3)

        val adapter = Adapter3(newarraylist3)
        adapter.setOnItemClickListener(object : Adapter3.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity, "You clicked on item ${position+1}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("heading",newarraylist3[position].text)
                intent.putExtra("imageId3",newarraylist3[position].ImageId3)
                intent.putExtra("news",news[position])
                intent.putExtra("tipe",tipe2)
                startActivity(intent)
            }
        })
        newrecycleview3.adapter = adapter

    }

    private fun getUserdata2() {
        for(i in ImageId2.indices){
            val modal2 = Modal2(ImageId2[i], text2[i])
            newarraylist2.add(modal2)
        }

        newrecycleview2.adapter = Adapter2(newarraylist2)

        val adapter = Adapter2(newarraylist2)
        adapter.setOnItemClickListener(object : Adapter2.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity, "You clicked on item ${position+1}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MainActivity2::class.java)
                intent.putExtra("heading",newarraylist2[position].text2)
                intent.putExtra("imageId3",newarraylist2[position].ImageId2)
                intent.putExtra("news",news2[position])
                intent.putExtra("tipe",tipe1)
                startActivity(intent)
            }
        })
        newrecycleview2.adapter = adapter

    }

    private fun getUserdata() {
        for(i in ImageId.indices){
            val modal = Modal(ImageId[i], name[i])
            newarraylist.add(modal)
        }

        newrecycleview.adapter = Myadapter(newarraylist)
        val adapter = Myadapter(newarraylist)
        adapter.setOnItemClickListener(object : Myadapter.onItemClickListener {
            override fun onItemClick(position: Int) {
//                Toast.makeText(this@MainActivity, "You clicked on item ${position+1}", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@MainActivity, MainActivity4::class.java)
//                intent.putExtra("heading",newarraylist[position].titleimage)
//                intent.putExtra("heading",newarraylist[position].heading)
                intent.putExtra("tipe",name[position])
//                intent.putExtra("gridimage",news1[position])
                startActivity(intent)
            }
        })
        newrecycleview.adapter = adapter

    }
}