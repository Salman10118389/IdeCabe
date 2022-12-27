package com.example.idecabe.core.data.repository

import com.google.firebase.firestore.FirebaseFirestore

class HomeRepositoryImp (
    val database : FirebaseFirestore
        ) : HomeRepository {
}