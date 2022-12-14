package com.example.idecabe.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.idecabe.databinding.FragmentHomeBinding
import com.example.idecabe.ui.auth.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private lateinit var firebaseAuth:  FirebaseAuth
    private lateinit var firestore: FirebaseFirestore
    val homeViewModel: HomeViewModel by viewModels()
    private val adapter by lazy {
        HomeAdapter(
            onItemClicked ={ pos, item ->

            }
        )
    }

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,

    ): View {


        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        (activity as AppCompatActivity?)!!.supportActionBar!!.hide()
        val root: View = binding.root

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        initVars()
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerViewhome.adapter = adapter
        homeViewModel.getProjects()
        
    }

    override fun onStart() {
        super.onStart()
        val firebaseUser = firebaseAuth.currentUser

        if (firebaseUser == null){
            val intent = Intent(this.activity, LoginActivity::class.java)
            startActivity(intent)
        }else {
            homeViewModel.getProjects()
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