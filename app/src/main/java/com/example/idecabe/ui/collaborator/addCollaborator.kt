package com.example.idecabe.ui.collaborator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.idecabe.databinding.ActivityAddCollaboratorBinding

class addCollaborator() : AppCompatActivity() {
    private lateinit var binding: ActivityAddCollaboratorBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddCollaboratorBinding.inflate(layoutInflater)
        setContentView(binding.root)




    }
}