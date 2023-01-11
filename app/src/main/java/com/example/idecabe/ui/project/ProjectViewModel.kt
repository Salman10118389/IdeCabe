package com.example.idecabe.ui.project

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.core.sources.remote.repositories.ProjectRepository
import com.example.idecabe.core.sources.remote.repositories.ProjectRepositoryImp
import com.example.idecabe.utils.UiState
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
@HiltViewModel
class ProjectViewModel@Inject constructor(val repository: ProjectRepository) : ViewModel() {

    private val _addProject = MutableLiveData<UiState<Pair<Project, String>>>()
    val addProject: LiveData<UiState<Pair<Project, String>>>
    get() = _addProject

    fun addProject(project: Project){
        _addProject.value = UiState.Loading
        repository.addProject(project) {
            _addProject.value = it
        }
    }


}