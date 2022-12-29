package com.example.idecabe.core.sources.remote.repositories

import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.utils.UiState
import com.google.firebase.firestore.auth.User

interface ProjectRepository {
    fun getProjects(user: User?, result: (UiState<List<Project>>) -> Unit)
    fun addProject(project: Project, result: (UiState<Pair<Project, String>>) -> Unit)
}