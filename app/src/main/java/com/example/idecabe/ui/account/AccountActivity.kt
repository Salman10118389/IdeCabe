package com.example.idecabe.ui.account

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idecabe.BottomNavigationActivity
import com.example.idecabe.databinding.ActivityAccountBinding
import com.google.firebase.auth.FirebaseAuth

class AccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAccountBinding
    private lateinit var auth: FirebaseAuth
    private lateinit var userId: String
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()
        val currentUser = auth.currentUser.toString()

        if (currentUser.isNotEmpty()){
            logout()
        }

    }

    private fun logout() {
        auth.signOut()
        val intentBottomNav = Intent(this, BottomNavigationActivity::class.java)
        startActivity(intentBottomNav)
        finish()
    }
}