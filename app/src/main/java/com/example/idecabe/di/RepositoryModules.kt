package com.example.idecabe.di

import android.content.SharedPreferences
import com.example.idecabe.core.data.repository.HomeRepository
import com.example.idecabe.core.data.repository.HomeRepositoryImp
import com.example.idecabe.core.sources.remote.repositories.AuthRepository
import com.example.idecabe.core.sources.remote.repositories.ProjectRepository
import com.example.idecabe.core.sources.remote.repositories.ProjectRepositoryImp
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.StorageReference
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModules {

    @Provides
    @Singleton
    fun providehomeRepo(database: FirebaseFirestore): HomeRepository {
        return HomeRepositoryImp(database)
    }



//    @Provides
//    @Singleton
//    fun provideAutghRepository(
//        database: FirebaseFirestore,
//        auth: FirebaseAuth,
//        appPreferences: SharedPreferences,
//        gson: Gson
//    ): AuthRepository {
////        return AuthRepositoryImp(auth,database,appPreferences,gson)
//    }

//    @Provides
//    @Singleton
//    fun provideNoteRepository(
//        database: FirebaseDatabase,
//        storageReference: StorageReference
//    ): ProjectRepository {
//        return ProjectRepositoryImp(database)
//    }

    @Provides
    @Singleton
    fun provideProjectReposiory(
        database: FirebaseFirestore
    ): ProjectRepository{
        return ProjectRepositoryImp(database)
    }

}