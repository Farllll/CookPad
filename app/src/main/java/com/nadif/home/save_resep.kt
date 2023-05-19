package com.nadif.home

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class save_resep : AppCompatActivity() {
    private lateinit var favoResepAdapter: FavoResepAdapter
    private lateinit var savedreseplist: MutableList<String>
    private lateinit var sp: SharedPreferences
    private lateinit var rv_save: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_resep)

        // munculin save
        val sp = getSharedPreferences("user", Context.MODE_PRIVATE)

        val backButton = findViewById<ImageView>(R.id.back)
        backButton.setOnClickListener {
//            requireActivity().onBackPressed()
//            requireActivity().supportFragmentManager.popBackStack()
            onBackPressed()
        }
        rv_save = findViewById(R.id.rv_save)
        savedreseplist = mutableListOf()
        var counter: Int = sp.getInt("count", 0)
        var start: Int = 0
        while (start < counter) {
            savedreseplist.add(sp.getString("title"+start, "Unknown").toString())
            start = start + 1
        }
        favoResepAdapter = FavoResepAdapter(savedreseplist)
        rv_save.layoutManager = LinearLayoutManager(this)
        rv_save.adapter = favoResepAdapter
        rv_save.addOnItemTouchListener(
            RecyclerItemClickListener(this, rv_save, object : RecyclerItemClickListener.OnItemClickListener {
                override fun onItemClick(view: View, position: Int) {
                    // remove the item from savedMovieList and update the RecyclerView
                    savedreseplist.removeAt(position)
                    favoResepAdapter.notifyItemRemoved(position)

                    // update the SharedPreferences
                    val editor = sp.edit()
                    editor.remove("title$position")
                    editor.putInt("count", savedreseplist.size)
                    for (i in 0 until savedreseplist.size) {
                        editor.putString("title$i", savedreseplist[i])
                    }
                    editor.apply()
                }

                override fun onLongItemClick(view: View?, position: Int) {
                    // do nothing
                }
            })
        )
    }
}