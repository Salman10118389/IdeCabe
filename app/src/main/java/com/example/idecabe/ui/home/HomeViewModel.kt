package com.example.idecabe.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.core.sources.remote.repositories.ProjectRepository
import com.example.idecabe.utils.UiState
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor (private val firebaseUser: FirebaseAuth, private val homeRepository: ProjectRepository) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _getProjects = MutableLiveData<UiState<List<Project>>>()
    val getProject: LiveData<UiState<List<Project>>>
        get() = _getProjects

    fun getProjects() {
        _getProjects.value = UiState.Loading
        homeRepository.getProjects(user = firebaseUser) {
            _getProjects.value = it
        }
    }
}