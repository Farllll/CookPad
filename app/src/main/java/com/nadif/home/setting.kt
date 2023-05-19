package com.nadif.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.nadif.home.databinding.ActivitySettingBinding

class setting : AppCompatActivity() {

    private lateinit var binding: ActivitySettingBinding
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        binding = ActivitySettingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        if(auth.currentUser != null){
            auth.currentUser?.let{
                binding.name.text=it.email
            }
        }


        val backButton = findViewById<ImageView>(R.id.app)
        backButton.setOnClickListener {
            onBackPressed()
        }
        binding.text10.setOnClickListener(){
            auth.signOut()
            startActivity(
                Intent(this, Login::class.java)
            )
            finish()
        }

        val all : ImageView =findViewById(R.id.btn_logout)
        all.setOnClickListener(){
            auth.signOut()
            startActivity(
                Intent(this, Login::class.java)
            )
            finish()
        }

    }
}