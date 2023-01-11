package com.example.idecabe.core.sources.remote.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.*

data class Project (
    var id: String = "",
    var user_id: String = "",
    var project_name: String = "",
    @ServerTimestamp
    var date: Date = Date()
        )