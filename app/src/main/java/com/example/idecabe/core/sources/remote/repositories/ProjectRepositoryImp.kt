package com.example.idecabe.core.sources.remote.repositories

import android.annotation.SuppressLint
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.utils.FireDatabase
import com.example.idecabe.utils.UiState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class ProjectRepositoryImp(val database: FirebaseFirestore): ProjectRepository {
    override fun getProjects(user: FirebaseAuth, result: (UiState<List<Project>>) -> Unit) {
        database.collection(FireDatabase.PROJECT).get()
            .addOnSuccessListener {
                val allProjects = arrayListOf<Project>()
                for (document in it ){
                    val project = document.toObject(Project::class.java)
                    allProjects.add(project)
                }
                result.invoke(
                    UiState.Success(allProjects)
                )
            }
            .addOnFailureListener{
                result.invoke(
                    UiState.Failure(it.localizedMessage)
                )
            }
    }

    @SuppressLint("RestrictedApi")
//    override fun getProjects(user: User?, result: (UiState<List<Project>>) -> Unit) {
//        database.collection(FireStoreCollectionProject.PROJECT)
//            .whereEqualTo(FireStoreDocumentField.USER_ID, user?.uid)
//            .orderBy(FireStoreDocumentField.DATE, Query.Direction.DESCENDING)
//            .get()
//            .addOnSuccessListener {
//                val projects = arrayListOf<Project>()
//                for (document in it){
//                val project =document.toObject(Project::class.java)
//                    projects.add(project)
//                }
//            }
    override fun addProject(project: Project, result: (UiState<Pair<Project, String>>) -> Unit){
        val document = database.collection(FireDatabase.PROJECT).document()
        project.id = document.id

        //Push that data to Firebasdatabase
        document.set(project)
            .addOnSuccessListener {
                result.invoke(
                    UiState.Success(Pair(project, "Project has Been Uploadad"))
                )
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