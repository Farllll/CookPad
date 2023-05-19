package com.nadif.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.etebarian.meowbottomnavigation.MeowBottomNavigation



class MainActivity6 : AppCompatActivity() {
    private lateinit var navigation: MeowBottomNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        navigation = findViewById(R.id.navigation)

        setFragment(home.newInstance())
        navigation.add(MeowBottomNavigation.Model(1, R.drawable.home))
        navigation.add(MeowBottomNavigation.Model(2, R.drawable.search))
        navigation.add(MeowBottomNavigation.Model(3, R.drawable.setting))

        navigation.setOnClickMenuListener{
            when(it.id){
                1 -> setFragment(home.newInstance())
                2 -> setFragment(search.newInstance())
                3 -> setFragment(setting2.newInstance())
                else -> " "
            }
        }
        navigation.show(1)
    }
    fun setFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frame, fragment)
            .commit()
    }
}