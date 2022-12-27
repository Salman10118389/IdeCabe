package com.example.idecabe.di

import com.example.idecabe.core.data.repository.HomeRepository
import com.example.idecabe.core.data.repository.HomeRepositoryImp
import com.google.firebase.firestore.FirebaseFirestore
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


}