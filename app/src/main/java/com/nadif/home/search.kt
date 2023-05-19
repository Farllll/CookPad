package com.nadif.home

import Adapter6
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nadif.home.databinding.ActivityMainBinding
import androidx.appcompat.widget.SearchView
import java.util.Locale.filter
import android.widget.Filterable
import android.widget.Filter


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class search : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    lateinit var ImageId4 : Array<Int>
    lateinit var heading : Array<String>
    private lateinit var searchView: SearchView
    private lateinit var newrecycleview4 : RecyclerView
    private lateinit var newarraylist4 : ArrayList<Modal4>
    private lateinit var news : Array<String>
    private lateinit var tipe : String

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
        val view = inflater.inflate(R.layout.fragment_search, container, false)


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
            "Teriyaki",
            "Beef",
            "Brownies",
            "Bubur Ayam",
            "Pretzel",
            "Ayam Bakar",
            "Onion Ring",

            "Popcorn",
            "Potato",
            "Coffe",
            "Pudding",
            "Roti Panggang",
            "Seblak",
            "Spaghetti",
            "Seblak",
            "Bubur",
            "Telur Mata Sapi",

            "Waffle",
            "Nasi Goreng"
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

        tipe = "Resep Makanan"

        newrecycleview4 = view.findViewById(R.id.grid)
        newrecycleview4.layoutManager = GridLayoutManager(context,2);
        newrecycleview4.setHasFixedSize(true)

        newarraylist4 = arrayListOf<Modal4>()
        getUserdata4()


        newrecycleview4.adapter = Adapter6(newarraylist4)
        val adapter = Adapter6(newarraylist4)

        newrecycleview4.adapter = adapter

        search("")

//        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView = view.findViewById(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
//                query?.let { search(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
//                Adapter4.filter.filter(newText)
//                adapter.filter.filter(newText)
//                newText?.let { search(it) }
//                return false
                if (newText.isNullOrEmpty()) {
                    adapter.filter.filter("")
                    search("")
                } else {
                    adapter.filter.filter(newText)
                    search(newText)
                }
                return true
            }
        })
        return view
    }


    private fun getUserdata4() {
        for(i in ImageId4.indices){
            val modal4 = Modal4(ImageId4[i], heading[i])
            newarraylist4.add(modal4)
        }
        val adapter = Adapter6(newarraylist4)
        newrecycleview4.adapter = adapter

        adapter.setOnItemClickListener(object : Adapter6.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("heading", newarraylist4[position].heading)
                intent.putExtra("imageId3", newarraylist4[position].ImageId4)
                intent.putExtra("news",news[position])
                intent.putExtra("tipe",tipe)
                startActivity(intent)
            }
        })

    }
    private fun search(query: String) {
        val filteredList = ArrayList<Modal4>()
        val adapter = Adapter6(newarraylist4)

        if (query != "" || query.isNotEmpty() || query.isNotBlank()) {
            for (item in newarraylist4) {
                if (item.heading.toLowerCase().contains(query.toLowerCase())) {
                    filteredList.add(item)
                }
            }
            adapter.Modallist4 = filteredList
            adapter.notifyDataSetChanged()
        }
        newrecycleview4.adapter = adapter

//        adapter.setOnItemClickListener(object : Adapter6.OnItemClickListener {
//            override fun onItemClick(position: Int) {
//                val intent = Intent(context, MainActivity2::class.java)
//                intent.putExtra("heading", newarraylist4[position].heading)
//                intent.putExtra("imageId3", newarraylist4[position].ImageId4)
//                intent.putExtra("news",news[position])
//                intent.putExtra("tipe",tipe)
//                startActivity(intent)
//            }
//        })

        adapter.setOnItemClickListener(object : Adapter6.OnItemClickListener {
            override fun onItemClick(position: Int) {
                val intent = Intent(context, MainActivity2::class.java)
                intent.putExtra("heading", adapter.Modallist4[position].heading)
                intent.putExtra("imageId3", adapter.Modallist4[position].ImageId4)
                intent.putExtra("news", news[position])
                intent.putExtra("tipe", tipe)
                startActivity(intent)
            }
        })

    }

    companion object {
        fun newInstance(): search {
            return search()
        }
    }
}