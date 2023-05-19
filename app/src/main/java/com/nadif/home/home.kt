package com.nadif.home

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Looper
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import org.w3c.dom.Text


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class home : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var newrecycleview : RecyclerView
    private lateinit var newarraylist : ArrayList<Modal>
    private lateinit var newrecycleview2 : RecyclerView
    private lateinit var newarraylist2 : ArrayList<Modal2>
    private lateinit var newrecycleview3 : RecyclerView
    private lateinit var newarraylist3 : ArrayList<Modal3>
    lateinit var ImageId : Array<Int>
    lateinit var ImageId2 : Array<Int>
    lateinit var ImageId3 : Array<Int>
    lateinit var sliderimages : Array<Int>
    lateinit var name : Array<String>
    lateinit var text : Array<String>
    lateinit var text2 : Array<String>
    lateinit var news : Array<String>
    lateinit var sub : Array<String>
    lateinit var title : Array<String>
    lateinit var news2 : Array<String>
    lateinit var news1: Array<Array<List<Int>>>
    lateinit var tipe1 : String
    lateinit var tipe : Array<String>
    lateinit var tipe2 : String
    lateinit var tipe3 : String
    lateinit var handler: Handler
    lateinit var runnable: Runnable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        val box1self : RelativeLayout = view.findViewById(R.id.box1self)
        val box2self : RelativeLayout = view.findViewById(R.id.box2self)
        val box3self : RelativeLayout = view.findViewById(R.id.box3self)
        val box4self : RelativeLayout = view.findViewById(R.id.box4self)
        val all : TextView = view.findViewById(R.id.all)
//        val sett : ImageView = view.findViewById(R.id.setting)
//
//        sett.setOnClickListener(){
//            val frag = Intent(context, setting::class.java)
//            startActivity(frag)
//        }


        all.setOnClickListener(){
            val intent = Intent(context, MainActivity3::class.java)
            intent.putExtra("tipe",tipe3)
            startActivity(intent)

        }

        box1self.setOnClickListener(){
            val intent = Intent(context, MenuUtama::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box1self.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, MenuUtama::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        })

        box2self.setOnClickListener(){
            val intent = Intent(context, ManuSarapan::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box3self.setOnClickListener(){
            val intent = Intent(context, ManuDessert::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

        box4self.setOnClickListener(){
            val intent = Intent(context, MenuSnack::class.java);
            intent.putExtra("tipe",tipe3)
            startActivity(intent)
        }

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

        sliderimages = arrayOf(
            R.drawable.yambar,
            R.drawable.popcorn,
            R.drawable.coffe,
            R.drawable.spaghetti,
            R.drawable.bubur
        )
        title = arrayOf(
            "Ayam Bakar",
            "Popcorn",
            "Coffe Americano",
            "Spaghetti",
            "Bubur"
        )
        sub = arrayOf(
            "240 Menit",
            "30 Menit",
            "5 Menit",
            "45 Menit",
            "60 Menit"
        )
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


        newrecycleview = view.findViewById(R.id.box1)
        newrecycleview.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newrecycleview.setHasFixedSize(true)

        newrecycleview2 = view.findViewById(R.id.box2)
        newrecycleview2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        newrecycleview2.setHasFixedSize(true)

        newrecycleview3 = view.findViewById(R.id.box3)
        newrecycleview3.layoutManager = LinearLayoutManager(context)
        newrecycleview3.setHasFixedSize(true)

        newarraylist = arrayListOf<Modal>()
        getUserdata()
        newarraylist2 = arrayListOf<Modal2>()
        getUserdata2()
        newarraylist3 = arrayListOf<Modal3>()
        getUserdata3()


        val imageSlider = view.findViewById<ImageSlider>(R.id.imageSlider)
        val imageList = ArrayList<SlideModel>()
        for (i in sliderimages.indices) {
            val slideModel = SlideModel(sliderimages[i], "\t"+title[i]+"\n\t${sub[i]}" , ScaleTypes.CENTER_CROP)
            imageList.add(slideModel)
        }
        imageSlider.setImageList(imageList)


//        imageList.add(SlideModel(R.drawable.seblak, "\tSeblak\n\t20 menit", ScaleTypes.CENTER_CROP).apply {Color.TRANSPARENT
//        })
//        imageList.add(SlideModel(R.drawable.coffe, "\tCoffe\n\t10 menit", ScaleTypes.CENTER_CROP).apply {Color.TRANSPARENT
//        })
//        imageList.add(SlideModel(R.drawable.bubur, "\tBubur\n\t60 menit", ScaleTypes.CENTER_CROP).apply {Color.TRANSPARENT
//        })
//
//
//        imageSlider.setImageList(imageList, ScaleTypes.FIT)


        return view
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
                val intent = Intent(context, MainActivity2::class.java)
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
                val intent = Intent(context, MainActivity2::class.java)
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
                val intent = Intent(context, MainActivity4::class.java)
//                intent.putExtra("heading",newarraylist[position].titleimage)
//                intent.putExtra("heading",newarraylist[position].heading)
                intent.putExtra("tipe",name[position])
//                intent.putExtra("gridimage",news1[position])
                startActivity(intent)
            }
        })
        newrecycleview.adapter = adapter

    }

    companion object {
        fun newInstance(): home {
            return home()
        }
    }

}
