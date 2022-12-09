package com.example.idecabe.ui.dashboard

import android.net.Uri
import android.opengl.GLES20
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.FirebaseFirestore.getInstance
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class ProjectViewModel : ViewModel(){
    private val firebaseAuth = FirebaseAuth.getInstance()
    private val storageReference = FirebaseStorage.getInstance().getReference()
    private var postImageUri: Uri? = null
    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }

    private val noFieldEmpty = MutableLiveData<String>().apply {
        value  = "Lngkapi data terlebih dahulu"
    }



    fun sendData(projectName: String, masking: String, label: String, collaborator: String) {
        val postRef: StorageReference = storageReference.child("projectIcon").child(FieldValue.serverTimestamp().toString() + ".jpg")
        postImageUri?.let {
            postRef.putFile(it).addOnCompleteListener({
                if (it.isSuccessful){
                    postRef.downloadUrl.addOnSuccessListener {

                    }
                }
            })
        }
    }




    val text: LiveData<String> = _text
}