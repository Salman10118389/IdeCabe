package com.example.idecabe.ui.project_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idecabe.core.sources.local.Dummy
import com.example.idecabe.core.sources.remote.model.Photo
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage

class ProjectDetailViewModel: ViewModel() {

    val listOfPhoto: LiveData<List<Photo>> = MutableLiveData<List<Photo>>().apply {
        value = Dummy.listPhoto
    }


}