package com.example.idecabe.ui.project_detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.idecabe.R
import com.example.idecabe.adapter.PhotoAdapter
import com.example.idecabe.databinding.ActivityProjectDetailBinding
import com.example.idecabe.core.sources.remote.model.Photo
import com.google.android.flexbox.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class ProjectDetail : AppCompatActivity() {
    private lateinit var ViewModel: ProjectDetailViewModel
    private lateinit var binding: ActivityProjectDetailBinding
    private val adapterPhoto = PhotoAdapter()
    //FireStore
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val firebaseAuth = FirebaseAuth.getInstance()
    val firebaseStorage = FirebaseStorage.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val listOfImages: List<Photo>

        val layoutManager = FlexboxLayoutManager(this).apply {
            justifyContent = JustifyContent.CENTER
            alignItems = AlignItems.CENTER
            flexDirection = FlexDirection.ROW
            flexWrap = FlexWrap.WRAP
        }
        val recyclerView: RecyclerView = findViewById(R.id.rv_photo)
        recyclerView.layoutManager = layoutManager

        setAdapter()
        setData()

    }
    private fun addPhoto(){
        binding.btnUploadImages.setOnClickListener(View.OnClickListener {

        })
    }
    private fun setAdapter(){
        binding.rvPhoto.adapter = PhotoAdapter()

    }
    private fun setData(){
        ViewModel.listOfPhoto.observe(this, {
            adapterPhoto.addItems(it)
        })
    }
}