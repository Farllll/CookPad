package com.nadif.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.nadif.home.databinding.ActivityMainBinding
import com.nadif.home.databinding.ActivityRegisterBinding

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btnRegister.setOnClickListener {
            val email = binding.email.text.toString().trim()
            val password = binding.pass.text.toString().trim()
            val cpassword = binding.cpass.text.toString().trim()

            if (email.isEmpty() || password.isEmpty() || cpassword.isEmpty()) {
                Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (password != cpassword) {
                Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        val user = auth.currentUser
                        Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, Login::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
                    }
                }
        }
//
//        binding.btnRegister.setOnClickListener {
//            startActivity(Intent(this, Login::class.java))
//            finish()
//        }

//        binding.btnRegister.setOnClickListener {
//            val name = binding.email.text.toString().trim()
//            val password = binding.pass.text.toString().trim()
//
//            // Mengecek apakah kolom input kosong atau tidak
//            if (name.isEmpty() || password.isEmpty()) {
//                Toast.makeText(this, "Isi Semua Data", Toast.LENGTH_SHORT).show()
//                return@setOnClickListener
//            }
//
//            // Membuat objek User dan mengisi dengan data dari input
//            val user = user(name, password)
//
//            database = FirebaseDatabase.getInstance().reference.child("users")
//            database.child(name).setValue(user).addOnSuccessListener {
//                binding.email.text.clear()
//                binding.pass.text.clear()
//
//                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()
//            }.addOnFailureListener {
//                Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT).show()
//            }
//
//        }
    }
}