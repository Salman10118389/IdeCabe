package com.example.idecabe.core.sources.remote.repositories

import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.utils.UiState
import com.google.firebase.auth.FirebaseAuth

interface ProjectRepository {
    fun getProjects(user: FirebaseAuth, result: (UiState<List<Project>>) -> Unit)
    fun addProject(project: Project, result: (UiState<Pair<Project, String>>) -> Unit)
}