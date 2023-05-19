package com.nadif.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.nadif.home.databinding.FragmentSetting2Binding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class setting2 : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding: FragmentSetting2Binding
    private lateinit var auth: FirebaseAuth
//    private lateinit var name: TextView

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
        binding = FragmentSetting2Binding.inflate(inflater, container, false)
        val view = binding.root
//        val view = inflater.inflate(R.layout.fragment_setting2, container, false)
        // Inflate the layout for this fragment

            binding = FragmentSetting2Binding.inflate(layoutInflater)
//            view.setContentView(binding.root)


            auth = FirebaseAuth.getInstance()
            var name : TextView =view.findViewById(R.id.name)
            if(auth.currentUser != null){
                auth.currentUser?.let{
                    binding.name.text=it.email
                    name.text=it.email

                }
            }

//        val backButton = view.findViewById<ImageView>(R.id.app)
//        backButton.setOnClickListener {
////            requireActivity().onBackPressed()
////            requireActivity().supportFragmentManager.popBackStack()
//            requireActivity()
//        }


        val saveResep = view.findViewById<ImageView>(R.id.btn_favorite)
        saveResep.setOnClickListener {
//            requireActivity().onBackPressed()
//            requireActivity().supportFragmentManager.popBackStack()
            val saveResep = Intent(context, save_resep::class.java)
            startActivity(saveResep)
        }

        val all : ImageView =view.findViewById(R.id.btn_logout)
        all.setOnClickListener(){
            auth.signOut()
            startActivity(
                Intent(context, Login::class.java)
            )
            requireActivity().finish()
        }


        val all2 : TextView =view.findViewById(R.id.text10)
        all2.setOnClickListener(){
            auth.signOut()
            startActivity(
                Intent(context, Login::class.java)
            )
            requireActivity().finish()
        }

        return view
        }



    companion object {
            fun newInstance(): setting2 {
                return setting2()
            }

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment setting2.
         */
        // TODO: Rename and change types and number of parameters
    }
}