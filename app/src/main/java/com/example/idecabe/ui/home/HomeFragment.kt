package com.example.idecabe.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.idecabe.BottomNavigationActivity
import com.example.idecabe.databinding.FragmentHomeBinding
import com.example.idecabe.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var firebaseAuth:  FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        initVars()
        return root
    }

    override fun onStart() {
        super.onStart()
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null){
            val intent = Intent(this.activity, LoginActivity::class.java)
            startActivity(intent)
        }else {
            val currentUser: String = firebaseAuth.currentUser?.uid.toString()
            firestore.collection("Users").document(currentUser).get().addOnCompleteListener({
                if (it.isSuccessful){
                    startActivity(Intent(this.activity, BottomNavigationActivity::class.java))
                }
            })
        }
    }

    private fun initVars() {
        firestore = FirebaseFirestore.getInstance()
        firebaseAuth = FirebaseAuth.getInstance()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}