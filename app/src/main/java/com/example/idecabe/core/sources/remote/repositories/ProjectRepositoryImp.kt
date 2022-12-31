package com.example.idecabe.core.sources.remote.repositories

import android.annotation.SuppressLint
import com.example.idecabe.core.sources.remote.model.Project
import com.example.idecabe.utils.FireDatabase
import com.example.idecabe.utils.FireStoreCollectionProject
import com.example.idecabe.utils.FireStoreDocumentField
import com.example.idecabe.utils.UiState
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.auth.User
import dagger.hilt.android.AndroidEntryPoint

class ProjectRepositoryImp(val database: FirebaseDatabase): ProjectRepository {
    override fun getProjects(user: User?, result: (UiState<List<Project>>) -> Unit) {
        TODO("Not yet implemented")
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
        val reference = database.reference.child(FireDatabase.PROJECT).push()
        val uniqueKey = reference.key ?: "Unique is Invalid"
        project.id = uniqueKey

        //Push that data to Firebasdatabase
        reference
            .setValue(project)
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