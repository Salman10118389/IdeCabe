package com.example.idecabe.ui.project_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idecabe.core.sources.local.Dummy
import com.example.idecabe.core.sources.remote.model.Photo

class ProjectDetailViewModel: ViewModel() {
    val listOfPhoto: LiveData<List<Photo>> = MutableLiveData<List<Photo>>().apply {
        value = Dummy.listPhoto
    }
}