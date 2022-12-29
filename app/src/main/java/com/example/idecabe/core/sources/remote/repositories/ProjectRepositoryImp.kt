package com.example.idecabe.core.sources.remote.repositories

import android.annotation.SuppressLint
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.utils.FireStoreCollectionProject
import com.example.idecabe.utils.FireStoreDocumentField
import com.example.idecabe.utils.UiState
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.auth.User

class ProjectRepositoryImp(val database: FirebaseFirestore): ProjectRepository {
    @SuppressLint("RestrictedApi")
    override fun getProjects(user: User?, result: (UiState<List<Project>>) -> Unit) {
        database.collection(FireStoreCollectionProject.PROJECT)
            .whereEqualTo(FireStoreDocumentField.USER_ID, user?.uid)
            .orderBy(FireStoreDocumentField.DATE, Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener {
                val projects = arrayListOf<Project>()
                for (document in it){
                val project =document.toObject(Project::class.java)
                    projects.add(project)
                }
            }
    }

    override fun addProject(project: Project, result: (UiState<Pair<Project, String>>) -> Unit){
        val document = database.collection(FireStoreCollectionProject.PROJECT).document()
        project.id = document.id

        document
            .set(project)
            .addOnSuccessListener {
                UiState.Success(Pair(project, "Project has been Created Successfully"))
            }
            .addOnFailureListener{
                result.invoke(
                    UiState.Failure(
                        it.localizedMessage
                    )
                )
            }
    }


}